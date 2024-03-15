package step_03.domain;

import java.util.ArrayList;
import java.util.List;

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

	public List<Car> getWinners(RacingCars playCars, int goal) {
		List<Car> winners = new ArrayList<>();

		for (Car car : playCars.getRacingCars()) {
			if (car.getCarPoint().getPoint() >= goal) {
				winners.add(car);
			}
		}
		return winners;
	}
}