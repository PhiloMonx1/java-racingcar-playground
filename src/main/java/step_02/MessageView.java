package step_02;

import java.util.Map;

public class MessageView {
	public static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	public static final String ASK_GOAL = "시도할 회수는 몇회인가요?";
	public static final String WINNER = "(이)가 최종 우승했습니다.";

	public static void printAskCarNames() {
		System.out.println(ASK_CAR_NAMES);
	}

	public static void printAskGoal() {
		System.out.println(ASK_GOAL);
	}

	public static void printCarsCurrentPoint(Map<String, Integer> carsCurrentPoint) {
		for (int i = 0; i < carsCurrentPoint.size(); i++) {
			System.out.println(carsCurrentPoint.keySet().toArray()[i] + " : " + makePointView((Integer) carsCurrentPoint.values().toArray()[i]));
		}
		System.out.println("\n");
	}

	public static void printWinner(String[] championNames) {
		String champions = String.join(", ", championNames);
		System.out.println(champions + WINNER);
	}

	private static String makePointView(int currentPoint){
		StringBuilder pointView = new StringBuilder();
		for(int i = 0; i < currentPoint; i++) {
			pointView.append("-");
		}
		return pointView.toString();
	}
}
