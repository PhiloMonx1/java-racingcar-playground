package step_03.domain;

import java.util.Objects;

public class Car {

	private final CarName carName;
	private final CarPoint carPoint;

	public Car(CarName carName) {
		this(carName, new CarPoint(0));
	}

	public Car(CarName carName, CarPoint carPoint) {
		this.carName = carName;
		this.carPoint = carPoint;
	}

	public Car move(boolean isMove) {
		if (isMove) {
			return new Car(carName, carPoint.move());
		}
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Car car = (Car) o;
		return Objects.equals(carName, car.carName) && Objects.equals(carPoint,
				car.carPoint);
	}

	@Override
	public int hashCode() {
		return Objects.hash(carName, carPoint);
	}
}
