package step_03.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MessageViewTest {
	@Test
	@DisplayName("printGameMessage()에서 우승자 출력 시도 시 예외 발생")
	void printGameMessageException() {
		MessageView messageView = new MessageView();
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			messageView.printGameMessage(GameMessage.GAME_RESULT);
		}).withMessageMatching("GAME_RESULT는 printWinners 메서드를 통해 출력해야 합니다.");
	}
}