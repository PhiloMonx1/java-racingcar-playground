package step_01;

public class StringAddCalculator {
	public static int splitAndSum(String input) {
		UserInput userInput = new UserInput(input);
		UserOperand operand = new UserOperand(userInput);
		int[] numbers = operand.getNumbers();

		int result = 0;
		for (int number : numbers) {
			result += number;
		}
		return result;
	}
}
