package step_01;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class UserInputTest {
	@Test
	@DisplayName("음수를 입력할 경우 RuntimeException 발생")
	void userInputTestException_Negative() {
		String inputNegative = "-1,2,3";

		assertThatExceptionOfType(RuntimeException.class)
				.isThrownBy(() -> {
					UserInput userInput = new UserInput(inputNegative);
				}).withMessageMatching("음수는 입력할 수 없습니다.");
	}

	@Test
	@DisplayName("아무것도 입력하지 않거나, 빈 문자열 입력시 인스턴스 변수 (String)0으로 설정")
	void userInputTestPass_NullOrEmpty() {
		String inputEmpty = "";
		UserInput userInputEmpty = new UserInput(inputEmpty);
		assertThat(userInputEmpty.input).isEqualTo("0");

		String inputNull = null;
		UserInput userInputNull = new UserInput(inputNull);
		assertThat(userInputNull.input).isEqualTo("0");
	}

	@Test
	@DisplayName("userInput 생성자 테스트")
	void userInputTest() {
		String input = "//;\\n1;2;3";
		UserInput userInput = new UserInput(input);
		assertThat(userInput.input).isEqualTo("//;\\n1;2;3");
	}
}
