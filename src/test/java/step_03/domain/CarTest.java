package step_03.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("Car 생성자 테스트")
	void createInstanceTest() {
		Car red = new Car(new CarName("red"));
		assertThat(red).isEqualTo(new Car(new CarName("red")));

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Car(new CarName("beLong"));
		}).withMessageMatching("CarName의 길이는 1~5 이여야 합니다..");
	}

	@Test
	@DisplayName("인자가 true 일 경우 Car의 point를 증가시킨다.")
	void moveCarTest() {
		Car red = new Car(new CarName("red"));
		red = red.move(true);
		red = red.move(false);
		assertThat(red).isEqualTo(new Car(new CarName("red"), new CarPoint(1)));
	}
}
