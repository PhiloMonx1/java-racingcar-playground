package step_03.view;

public enum GameMessage {
	ASK_CARS_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
	ASK_GOAL("시도할 회수는 몇회인가요?"),
	GAME_RESULT("(이)가 최종 우승했습니다."),
	;
	private final String message;

	GameMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
