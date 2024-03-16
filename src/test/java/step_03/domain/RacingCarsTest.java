package step_03.domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

	@Test
	@DisplayName("RacingCars 생성자 테스트")
	void createInstanceTest() {
		Car red = new Car(new CarName("red"));
		Car blue = new Car(new CarName("blue"));
		RacingCars racingCars = new RacingCars(Arrays.asList(red, blue));
		assertThat(racingCars).isEqualTo(new RacingCars(
				Arrays.asList(new Car(new CarName("red")), new Car(new CarName("blue")))));
	}
}
