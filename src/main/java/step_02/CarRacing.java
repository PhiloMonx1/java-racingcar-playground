package step_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarRacing {
	private final List<Car> cars;
	private final int goal;

	public List<Car> getCars() {
		return cars;
	}

	public int getGoal() {
		return goal;
	}

	public CarRacing(String carNames, int goal) {
		this.cars = createCars(validateCarNames(carNames));
		this.goal = validateGoal(goal);
	}

	public Map<String, Integer> getCarsCurrentPoint() {
		Map<String, Integer> pointMap = new java.util.TreeMap<>();
		for(Car car : cars) {
			pointMap.put(car.getName(), car.getPoint());
		}
		return pointMap;
	}

	public String[] getChampionNames(){
		return cars.stream()
				.filter(car -> car.getPoint() >= goal)
				.map(Car::getName)
				.toArray(String[]::new);
	}

	public String[] racing() {
		while (!isFinished()) {
			start();
			MessageView.printCarsCurrentPoint(getCarsCurrentPoint());
		}
		return getChampionNames();
	}

	private List<Car> createCars(String carNames) {
		String[] names = carNames.split(",");
		List<Car> cars = new ArrayList<>();
		for(String name : names) {
			cars.add(new Car(name));
		}
		return cars;
	}

	private String validateCarNames(String carNames) {
		if(carNames == null || carNames.isEmpty()) {
			throw new RuntimeException("빈 이름은 입력할 수 없습니다.");
		}
		return carNames;
	}

	private int validateGoal(int goal) {
		if(goal < 1) {
			throw new RuntimeException("목적지는 1이상 설정해야 합니다.");
		}
		return goal;
	}

	private void start() {
		for (Car car : cars) {
			car.increasePoint(car.isGo());
		}
	}

	private boolean isFinished() {
		return cars.stream().anyMatch(car -> car.getPoint() >= goal);
	}
}
