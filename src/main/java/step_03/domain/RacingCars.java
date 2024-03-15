package step_03.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCars {

	private final List<Car> cars;

	public RacingCars(List<Car> cars) {
		this.cars = cars;
	}

	public RacingCars(String carNames) {
		String[] carNamesArray = carNames.split(",");
		List<Car> cars = new ArrayList<>();
		for (String carName : carNamesArray) {
			cars.add(new Car(new CarName(carName)));
		}
		this.cars = cars;
	}

	public List<Car> getRacingCars() {
		return cars;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RacingCars that = (RacingCars) o;
		return Objects.equals(cars, that.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars);
	}
}
