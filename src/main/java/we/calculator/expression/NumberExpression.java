package we.calculator.expression;

public class NumberExpression implements Expression {
	private final int number;

	public NumberExpression(String number) {
		this.number = Integer.parseInt(number);
	}

	@Override
	public int evaluate() {
		return this.number;
	}
}