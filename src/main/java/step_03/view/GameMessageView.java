package step_03.view;

import step_03.domain.Car;
import step_03.domain.RacingCars;

public class GameMessageView extends MessageView {

	public void printWinners(RacingCars winners) {
		String[] winnersNames = new String[winners.getRacingCars().size()];
		for (int i = 0; i < winners.getRacingCars().size(); i++) {
			winnersNames[i] = extractCarName(winners.getRacingCars().get(i));
		}
		super.printWinners(winnersNames);
	}

	public void printCurrentPointOfCars(RacingCars cars) {
		for (Car car : cars.getRacingCars()) {
			printCurrentPointOfCar(car);
		}
	}

	private void printCurrentPointOfCar(Car car) {
		super.printCurrentPointOfCar(extractCarName(car), extractCarPoint(car));
	}

	private String extractCarName(Car car) {
		return car.getCarName().toString();
	}

	private int extractCarPoint(Car car) {
		return car.getCarPoint().getPoint();
	}
}
