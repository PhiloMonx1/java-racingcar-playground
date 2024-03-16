package step_03.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

	private final Racing game = new Racing();


	@Test
	@DisplayName("moveCars 테스트 : red만 한 칸 이동")
	void moveCars() {
		Car red = new Car(new CarName("red"));
		Car green = new Car(new CarName("green"));

		RacingCars racingCars = new RacingCars(Arrays.asList(red, green));
		boolean[] onlyRedMove = {true, false};
		racingCars = game.moveCars(racingCars, onlyRedMove);

		assertThat(racingCars.getRacingCars().get(0)).isEqualTo(
				new Car(new CarName("red"), new CarPoint(1)));
		assertThat(racingCars.getRacingCars().get(1)).isEqualTo(new Car(new CarName("green")));
	}

	@Test
	@DisplayName("여러 명의 winner 테스트")
	void getMultipleWinners() {
		Car red = new Car(new CarName("red"));
		Car green = new Car(new CarName("green"), new CarPoint(10));
		Car blue = new Car(new CarName("blue"), new CarPoint(10));

		RacingCars racingCars = new RacingCars(Arrays.asList(red, green, blue));

		RacingCars winner = new RacingCars(
				Arrays.asList(new Car(new CarName("green"), new CarPoint(10)),
						new Car(new CarName("blue"), new CarPoint(10))));

		RacingCars winners = game.getWinners(racingCars, 10);

		assertThat(winners).isEqualTo(winner);
	}
}
