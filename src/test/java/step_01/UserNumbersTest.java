package step_01;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserNumbersTest {
	@Test
	@DisplayName("UserOperand 생성자 테스트 : 1")
	void operandTestOnlyOneNumber() {
		UserInput userInput = new UserInput("1");
		UserOperand userNumbers = new UserOperand(userInput);

		assertThat(userNumbers.getSeparator()).isEqualTo(",");
		assertThat(userNumbers.getNumbers()).isEqualTo(new int[] {1});
	}

	@Test
	@DisplayName("UserOperand 생성자 테스트 : 1,2")
	void operandTestCommaSeparator() {
		UserInput userInput = new UserInput("1,2");
		UserOperand userNumbers = new UserOperand(userInput);

		assertThat(userNumbers.getSeparator()).isEqualTo(",");
		assertThat(userNumbers.getNumbers()).isEqualTo(new int[] {1, 2});
	}

	@Test
	@DisplayName("UserOperand 생성자 테스트 : 1,2:3")
	void
	operandTestCommaSeparatorWithColonSeparator() {
		UserInput userInput = new UserInput("1,2:3");
		UserOperand userNumbers = new UserOperand(userInput);

		assertThat(userNumbers.getSeparator()).isEqualTo(",");
		assertThat(userNumbers.getNumbers()).isEqualTo(new int[] {1, 2, 3});
	}
	@Test
	@DisplayName("UserOperand 생성자 테스트 : //;\\n1;2;3")
	void operandTestCustomSeparator() {
		UserInput userInput = new UserInput("//;\\n1;2;3");
		UserOperand userNumbers = new UserOperand(userInput);

		assertThat(userNumbers.getSeparator()).isEqualTo(";");
		assertThat(userNumbers.getNumbers()).isEqualTo(new int[] {1, 2, 3});
	}

	@Test
	@DisplayName("UserOperand 생성자 테스트 : //;\\n1,2:3;4")
	void operandTestCustomSeparatorWithCommaAndColonSeparator() {
		UserInput userInput = new UserInput("//;\\n1,2:3;4");
		UserOperand userNumbers = new UserOperand(userInput);

		assertThat(userNumbers.getSeparator()).isEqualTo(";");
		assertThat(userNumbers.getNumbers()).isEqualTo(new int[] {1, 2, 3, 4});
	}
}
