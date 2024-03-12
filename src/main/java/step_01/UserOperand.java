package step_01;

public class UserOperand {
	private final String separator;
	private final String regex;
	private final int[] numbers;
	public UserOperand(UserInput userInput) {
		this.separator = extractSeparator(userInput.getValue());
		this.regex = createRegex();
		this.numbers = extractNumbers(userInput.getValue());
	}

	public String getSeparator() {
		return separator;
	}

	public int[] getNumbers() {
		return numbers;
	}

	private String extractSeparator(String input) {
		int delimiterStartIndex = input.indexOf("//") + 2;
		int delimiterEndIndex = input.indexOf("\n");
		if(delimiterEndIndex > -1){
			return input.substring(delimiterStartIndex, delimiterEndIndex);
		}
		return ",";
	}

	private int[] extractNumbers(String input) {
		String[] split = replaceInput(input).split(separator + "|,|:");
		int[] numbers = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			numbers[i] = Integer.parseInt((split[i]));
		}
		return numbers;
	}

	private String createRegex() {
		String regex = "[^0-9,:";
		if(!separator.isEmpty()){
			regex += separator;
		}
		regex += "]";
		return regex;
	}

	private String replaceInput(String input) {
		input = input.replaceAll(regex, "");
		input = input.replaceAll("^[^0-9]+", "");
		input = input.replaceAll("[^0-9]+$", "");
		return input;
	}
}
