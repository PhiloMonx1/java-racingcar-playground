package step_03.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarPointTest {

	@Test
	@DisplayName("CarPoint 생성자 테스트")
	void crateInstanceTest() {
		CarPoint carPoint = new CarPoint(5);
		assertThat(carPoint).isEqualTo(new CarPoint(5));
	}

	@Test
	@DisplayName("CarPoint가 음수일 경우 예외 발생")
	void validCarPointTest() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new CarPoint(-1);
		}).withMessageMatching("CarPoint는 음수 일 수 없습니다.");
	}

	@Test
	@DisplayName("CarPoint를 증가시킨다")
	void moveTest() {
		CarPoint carPoint = new CarPoint(5);
		assertThat(carPoint.move()).isEqualTo(new CarPoint(6));
	}
}
