package step_03.domain;

import java.util.Objects;

public class Goal {

	static public final String NUMBER_REGEX = "[0-9]+";
	private final int goal;

	public Goal(String goal) {
		if (!goal.matches(NUMBER_REGEX) || Integer.parseInt(goal) < 1) {
			throw new IllegalArgumentException("Goal은 1이상의 숫자여야 합니다.");
		}
		this.goal = Integer.parseInt(goal);
	}

	public int getGoal() {
		return goal;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Goal goal1 = (Goal) o;
		return goal == goal1.goal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(goal);
	}
}
