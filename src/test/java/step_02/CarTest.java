package step_02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
public class CarTest {
	@Test
	@DisplayName("Car 생성자 테스트 : 이름 길이 초과")
	void carTestException_NameLength() {
		assertThatExceptionOfType(RuntimeException.class)
				.isThrownBy(() -> {
					Car car = new Car("orange");
				}).withMessageMatching("이름은 5자를 초과할 수 없습니다.");
	}

	@Test
	@DisplayName("Car 생성자 테스트 : 빈 이름")
	void carTestException_EmptyName() {
		assertThatExceptionOfType(RuntimeException.class)
				.isThrownBy(() -> {
					Car car = new Car("");
				}).withMessageMatching("빈 이름은 입력할 수 없습니다.");
		assertThatExceptionOfType(RuntimeException.class)
				.isThrownBy(() -> {
					Car car = new Car(null);
				}).withMessageMatching("빈 이름은 입력할 수 없습니다.");
	}

	@Test
	@DisplayName("Car 생성자 테스트 : 정상")
	void carTest() {
		Car car = new Car("red");
		assertThat(car.getName()).isEqualTo("red");
	}

	@Test
	@DisplayName("2칸 앞으로")
	void goTest() {
		Car car = new Car("red");
		assertThat(car.getPoint()).isEqualTo(0);
		car.increasePoint(true);
		car.increasePoint(false);
		car.increasePoint(true);
		assertThat(car.getPoint()).isEqualTo(2);
	}
}
