package step_03.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

	public RacingCars moveCars(RacingCars playCars, boolean[] isMoves) {
		List<Car> movedCars = new ArrayList<>();
		int count = 0;
		for (Car car : playCars.getRacingCars()) {
			movedCars.add(car.move(isMoves[count]));
			count++;
		}
		return new RacingCars(movedCars);
	}

	public RacingCars getWinners(RacingCars playCars, int goal) {
		return new RacingCars(playCars.getRacingCars().stream()
				.filter(car -> car.getCarPoint().getPoint() >= goal)
				.collect(Collectors.toList()));
	}
}