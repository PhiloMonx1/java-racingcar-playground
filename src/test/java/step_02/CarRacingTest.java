package step_02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarRacingTest {
	@Test
	@DisplayName("CarRacing 생성자 테스트 : 정상")
	void carRacingTest() {
		String carNames = "red,blue,green";

		CarRacing carRacing = new CarRacing(carNames, 5);
		assertThat(carRacing.getGoal()).isEqualTo(5);

		String[] names = carNames.split(",");
		List<Car> cars = carRacing.getCars();

		assertThat(cars).isNotEmpty();
		assertThat(cars.size()).isEqualTo(names.length);
		assertThat(cars.get(0).getName()).isEqualTo("red");
		assertThat(cars.get(1).getName()).isEqualTo("blue");
		assertThat(cars.get(2).getName()).isEqualTo("green");
	}

	@Test
	@DisplayName("CarRacing 생성자 테스트 : 빈 이름")
	void carRacingTestException_EmptyName() {
		assertThatExceptionOfType(RuntimeException.class)
				.isThrownBy(() -> {
					new CarRacing("", 5);
				}).withMessageMatching("빈 이름은 입력할 수 없습니다.");
		assertThatExceptionOfType(RuntimeException.class)
				.isThrownBy(() -> {
					new CarRacing(null, 5);
				}).withMessageMatching("빈 이름은 입력할 수 없습니다.");
	}

	@Test
	@DisplayName("CarRacing 생성자 테스트 : 이름 길이 초과")
	void carRacingTestException_NameLength() {
		assertThatExceptionOfType(RuntimeException.class)
				.isThrownBy(() -> {
					new CarRacing("red,blue,green,orange", 5);
				}).withMessageMatching("이름은 5자를 초과할 수 없습니다.");
	}

	@Test
	@DisplayName("CarRacing 생성자 테스트 : 1이하의 goal")
	void carRacingTestException_NullCarNames() {
		assertThatExceptionOfType(RuntimeException.class)
				.isThrownBy(() -> {
					new CarRacing("red,blue,green", -1);
				}).withMessageMatching("목적지는 1이상 설정해야 합니다.");
	}

	//TODO: 자동차 경주 단위테스트 추가 (TDD fail)

}