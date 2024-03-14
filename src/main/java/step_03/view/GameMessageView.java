package step_03.view;

import java.util.List;
import step_03.domain.Car;

public class GameMessageView extends MessageView {

	public void printWinners(List<Car> winnersName) {
		String[] winners = new String[winnersName.size()];
		for (int i = 0; i < winnersName.size(); i++) {
			winners[i] = extractCarName(winnersName.get(i));
		}
		super.printWinners(winners);
	}

	public void printCurrentPointOfCar(Car car) {
		super.printCurrentPointOfCar(extractCarName(car), extractCarPoint(car));
	}

	private String extractCarName(Car car) {
		return car.getCarName().toString();
	}

	private int extractCarPoint(Car car) {
		return car.getCarPoint().getPoint();
	}
}
