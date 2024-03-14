package step_03.view;

import step_03.utils.StringUtil;

public class MessageView {
	public void printGameMessage(GameMessage gameMessage) {
		if (gameMessage == GameMessage.GAME_RESULT) {
			throw new IllegalArgumentException("GAME_RESULT는 printWinners 메서드를 통해 출력해야 합니다.");
		}
		System.out.println(gameMessage);
	}

	protected void printWinners(String[] winnersName) {
		System.out.println(String.join(" ,", winnersName) + GameMessage.GAME_RESULT);
	}

	protected void printCurrentPointOfCar(String carName, int currentPoint) {
		StringUtil stringUtil = new StringUtil();
		System.out.println(carName + " : " + stringUtil.repeatedSymbol("-", currentPoint));
	}
}
