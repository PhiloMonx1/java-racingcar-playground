package step_03.domain;

import java.util.Objects;

public class CarName {

	private final String name;

	public CarName(String name) {
		validateCarName(name);
		this.name = name;
	}

	private void validateCarName(String carName) {
		if (carName == null || carName.isEmpty() || carName.length() > 5) {
			throw new IllegalArgumentException("CarName의 길이는 1~5 이여야 합니다..");
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
		CarName carName1 = (CarName) o;
		return Objects.equals(name, carName1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
