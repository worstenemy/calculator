package we.calculator.expression;

public class ParenExpression implements Expression {
	private final Expression expression;

	public ParenExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public int evaluate() {
		return this.expression.evaluate();
	}
}