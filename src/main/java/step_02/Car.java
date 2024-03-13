package step_02;

import java.util.Random;

public class Car {
	private final String name;
	private int point;
	public Car(String name) {
		this.name = validateName(name);
		this.point = 0;
	}

	public String getName() {
		return name;
	}

	public int getPoint() {
		return point;
	}

	private String validateName(String name){
		if(name == null || name.isEmpty()){
			throw new RuntimeException("빈 이름은 입력할 수 없습니다.");
		}
		if(name.length() > 5){
			throw new RuntimeException("이름은 5자를 초과할 수 없습니다.");
		}

		return name;
	}

	public void increasePoint(boolean isGo) {
		if(isGo){
			this.point++;
		}
	}

	public boolean isGo() {
		Random random = new Random();
		return random.nextInt(10) < 4;
	}
}
