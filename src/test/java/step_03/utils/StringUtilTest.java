package step_03.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {
	@Test
	@DisplayName("첫 번째 인자의 String을 두 번째 인자의 횟수만큼 String으로 묶어서 return한다.")
	void printRepeatedSymbol() {
		StringUtil stringUtil = new StringUtil();
		assertThat(stringUtil.repeatedSymbol("-", 5)).isEqualTo("-----");
		assertThat(stringUtil.repeatedSymbol("hello", 5)).isEqualTo("hellohellohellohellohello");

		assertThat(stringUtil.repeatedSymbol("", 99)).isEmpty();
		assertThat(stringUtil.repeatedSymbol("-", 0)).isEmpty();
		assertThat(stringUtil.repeatedSymbol("hello", -99)).isEmpty();
	}
}
