package we.calculator.expression;

import we.calculator.operator.BinaryOperator;

public class BinaryExpression implements Expression {
	private final Expression left;

	private final Expression right;

	private final BinaryOperator operator;

	public BinaryExpression(Expression left, Expression right, BinaryOperator operator) {
		this.left = left;
		this.right = right;
		this.operator = operator;
	}

	@Override
	public int evaluate() {
		return this.operator.evaluate(this.left, this.right);
	}
}