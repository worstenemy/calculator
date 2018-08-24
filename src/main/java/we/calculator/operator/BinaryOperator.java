package we.calculator.operator;

import we.calculator.expression.Expression;

public enum BinaryOperator {
	add {
		@Override
		public int evaluate(Expression left, Expression right) {
			return left.evaluate() + right.evaluate();
		}
	},
	minus {
		@Override
		public int evaluate(Expression left, Expression right) {
			return left.evaluate() - right.evaluate();
		}
	},
	multiply {
		@Override
		public int evaluate(Expression left, Expression right) {
			return left.evaluate() * right.evaluate();
		}
	},
	divide {
		@Override
		public int evaluate(Expression left, Expression right) {
			int rightValue = right.evaluate();
			if (0 == rightValue) {
				throw new IllegalArgumentException("divide by 0");
			}
			return left.evaluate() / rightValue;
		}
	};

	public abstract int evaluate(Expression left, Expression right);
}