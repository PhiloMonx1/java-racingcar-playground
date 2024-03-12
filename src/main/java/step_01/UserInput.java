package step_01;

public class UserInput {
	public final String input;

	public UserInput(String input) {
		this.input = validateAndProcessInput(input);
	}

	private String validateAndProcessInput(String input) {
		if (input == null || input.isEmpty()) {
			return "0";
		}
		return checkContainsNegative(input);
	}

	private String checkContainsNegative(String input) {
		if (input.contains("-")) {
			throw new RuntimeException("음수는 입력할 수 없습니다.");
		}
		return input;
	}
}
