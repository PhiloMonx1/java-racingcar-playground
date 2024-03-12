package step_01;

public class UserInput {
	private final String value;

	public UserInput(String value) {
		this.value = validateAndProcessInput(value);
	}

	public String getValue() {
		return value;
	}

	private String validateAndProcessInput(String value) {
		if (value == null || value.isEmpty()) {
			return "0";
		}
		return checkContainsNegative(value);
	}

	private String checkContainsNegative(String value) {
		if (value.contains("-")) {
			throw new RuntimeException("음수는 입력할 수 없습니다.");
		}
		return value;
	}
}
