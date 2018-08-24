package we.calculator;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import we.calculator.expression.Expression;

@RunWith(JUnit4.class)
public class CalculatorTest {
	@Test
	public void test_add() {
		String text = "1 + 2 + 3";
		Expression expression = Expressions.create(text);
		Assert.assertEquals(6, expression.evaluate());
	}

	@Test
	public void test_minus() {
		String text = "1 + 2 - 3";
		Expression expression = Expressions.create(text);
		Assert.assertEquals(0, expression.evaluate());
	}

	@Test
	public void test_multiply() {
		String text = "1 * 2 * 3";
		Expression expression = Expressions.create(text);
		Assert.assertEquals(6, expression.evaluate());
	}

	@Test
	public void test_divide() {
		String text = "3 / 2";
		Expression expression = Expressions.create(text);
		Assert.assertEquals(1, expression.evaluate());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_divide_by_zero() {
		String text = "3 / 0";
		Expression expression = Expressions.create(text);
		expression.evaluate();
	}

	@Test
	public void test_paren() {
		String text = "1 + 2 + 3 * (5 - 2 + (2 - 0))";
		Expression expression = Expressions.create(text);
		Assert.assertEquals(18, expression.evaluate());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_paren_divide_by_zero() {
		String text = "1 + 2 + 3 * (5 - 2 + (2 - 0)) / 0";
		Expression expression = Expressions.create(text);
		expression.evaluate();
	}

	@Test(expected = ParseCancellationException.class)
	public void test_illegal_number() {
		String text = "123.a + 2 + 3";
		Expressions.create(text);
	}
}