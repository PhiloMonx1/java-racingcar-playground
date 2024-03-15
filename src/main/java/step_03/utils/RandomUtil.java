package step_03.utils;

import java.util.Random;

public class RandomUtil {

	public static boolean[] getRandomBooleans(int count) {
		boolean[] booleans = new boolean[count];
		for (int i = 0; i < count; i++) {
			booleans[i] = getRandomBoolean();
		}
		return booleans;
	}

	private static boolean getRandomBoolean() {
		return new Random().nextInt(10) < 4;
	}

}
