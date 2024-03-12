package step_01;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine(); //"//;\n1;2;3" 케이스의 경우

		int result = StringAddCalculator.splitAndSum(input);
		System.out.println(result);
		scanner.close();
	}
}
