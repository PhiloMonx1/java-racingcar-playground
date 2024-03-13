package step_02;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		MessageView.printAskCarNames();
		String carNames = scanner.nextLine();

		MessageView.printAskGoal();
		int goal = scanner.nextInt();

		CarRacing carRacing = new CarRacing(carNames, goal);

		MessageView.printWinner(carRacing.racing());
		scanner.close();
	}
}