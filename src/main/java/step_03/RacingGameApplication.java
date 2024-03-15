package step_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import step_02.MessageView;
import step_03.domain.Car;
import step_03.domain.Goal;
import step_03.domain.Racing;
import step_03.domain.RacingCars;
import step_03.utils.RandomUtil;
import step_03.view.GameMessageView;

public class RacingGameApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		MessageView.printAskCarNames();
		String carNames = scanner.nextLine();

		MessageView.printAskGoal();
		String goal = scanner.nextLine();

		playGame(carNames, goal);
		scanner.close();
	}

	public static void playGame(String carNames, String goal) {
		RacingCars playCars = new RacingCars(carNames);
		int goalPoint = new Goal(goal).getGoal();

		Racing racing = new Racing();
		GameMessageView gameView = new GameMessageView();

		List<Car> winners = new ArrayList<>();
		while (winners.isEmpty()) {
			playCars = racing.moveCars(playCars,
					RandomUtil.getRandomBooleans(playCars.getRacingCars().size()));
			gameView.printCurrentPointOfCars(playCars);
			System.out.print("\n");
			winners = racing.getWinners(playCars, goalPoint);
		}
		gameView.printWinners(new RacingCars(winners));
	}
}