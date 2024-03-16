package step_03.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

	@Test
	@DisplayName("CarName 생성자 테스트")
	void crateInstanceTest() {
		CarName one = new CarName("1");
		CarName five = new CarName("five5");

		assertThat(one).isEqualTo(new CarName("1"));
		assertThat(five).isEqualTo(new CarName("five5"));
	}

	@ParameterizedTest
	@DisplayName("CarName이 1~5 길이가 아닐 경우 예외 발생")
	@NullAndEmptySource
	@ValueSource(strings = {"123456"})
	void validCarNameTest(String input) {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new CarName(input);
		}).withMessageMatching("CarName의 길이는 1~5 이여야 합니다..");
	}
}
