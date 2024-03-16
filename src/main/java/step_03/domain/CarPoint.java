package step_03.domain;

import java.util.Objects;

public class CarPoint {

	private final int point;

	public CarPoint(int point) {
		validatePoint(point);
		this.point = point;
	}

	public int getPoint() {
		return point;
	}

	public CarPoint move() {
		return new CarPoint(point + 1);
	}

	private void validatePoint(int point) {
		if (point < 0) {
			throw new IllegalArgumentException("CarPoint는 음수 일 수 없습니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CarPoint carPoint = (CarPoint) o;
		return point == carPoint.point;
	}

	@Override
	public int hashCode() {
		return Objects.hash(point);
	}
}
