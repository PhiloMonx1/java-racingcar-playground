package step_03.utils;

public class StringUtil {
	public String repeatedSymbol(String symbol, int count) {
		StringBuilder symbolBuilder = new StringBuilder();
		for (int i = 0; i < count; i++) {
			symbolBuilder.append(symbol);
		}
		return symbolBuilder.toString();
	}
}
