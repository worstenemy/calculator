package we.calculator;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import we.calculator.antlr.CalculatorBaseVisitor;
import we.calculator.antlr.CalculatorLexer;
import we.calculator.antlr.CalculatorParser;
import we.calculator.expression.BinaryExpression;
import we.calculator.expression.Expression;
import we.calculator.expression.NumberExpression;
import we.calculator.expression.ParenExpression;
import we.calculator.operator.BinaryOperator;

import java.util.function.Function;

public class Expressions extends CalculatorBaseVisitor<Expression> {
	private static final String SYMBOL_MINUS = "-";

	private static final String SYMBOL_MULTIPLY = "*";

	private static final BaseErrorListener ERROR_LISTENER = new BaseErrorListener() {
		@Override
		public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String message, RecognitionException e) {
			throw new ParseCancellationException("exception found in line " + line + ", position " + charPositionInLine + ", " + message);
		}
	};

	private static <T extends Parser, U extends Lexer>
	ParseTree parse(String input,
	                Function<TokenStream, T> parserCreator,
	                Function<CharStream, U> lexerCreator,
	                Function<T, ParseTree> parseRule) {
		CharStream stream = CharStreams.fromString(input);
		U lexer = lexerCreator.apply(stream);
		lexer.removeErrorListeners();
		lexer.addErrorListener(ERROR_LISTENER);

		CommonTokenStream tokenStream = new CommonTokenStream(lexer);

		T parser = parserCreator.apply(tokenStream);
		parser.removeErrorListeners();
		parser.addErrorListener(ERROR_LISTENER);

		ParseTree tree;
		try {
			tree = parse(parseRule, tokenStream, parser);
		} catch (StackOverflowError error) {
			throw new ParseCancellationException("parse is too large (stack overflow)");
		}
		return tree;
	}

	private static <T extends Parser> ParseTree parse(Function<T, ParseTree> parseRule, CommonTokenStream tokenStream, T parser) {
		ParseTree tree;
		try {
			parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
			tree = parseRule.apply(parser);
		} catch (ParseCancellationException e) {
			tokenStream.seek(0);
			parser.reset();
			parser.getInterpreter().setPredictionMode(PredictionMode.LL);
			tree = parseRule.apply(parser);
		}
		return tree;
	}

	public static Expression create(String text) {
		ParseTree tree = parse(text,
				CalculatorParser::new,
				CalculatorLexer::new,
				CalculatorParser::calculate);
		Expressions builder = new Expressions();
		return builder.visit(tree);
	}

	private Expressions() {

	}

	@Override
	public Expression visitParen(CalculatorParser.ParenContext ctx) {
		Expression delegate = visit(ctx.expression());
		return new ParenExpression(delegate);
	}

	@Override
	public Expression visitSimple(CalculatorParser.SimpleContext ctx) {
		return visitNumber(ctx.number());
	}

	@Override
	public Expression visitLowOrder(CalculatorParser.LowOrderContext ctx) {
		Expression left = visit(ctx.left);
		Expression right = visit(ctx.right);
		if (SYMBOL_MINUS.equals(ctx.op.getText())) {
			return new BinaryExpression(left, right, BinaryOperator.minus);
		} else {
			return new BinaryExpression(left, right, BinaryOperator.add);
		}
	}

	@Override
	public Expression visitHighOrder(CalculatorParser.HighOrderContext ctx) {
		Expression left = visit(ctx.left);
		Expression right = visit(ctx.right);
		if (SYMBOL_MULTIPLY.equals(ctx.op.getText())) {
			return new BinaryExpression(left, right, BinaryOperator.multiply);
		} else {
			return new BinaryExpression(left, right, BinaryOperator.divide);
		}
	}

	@Override
	public Expression visitNumber(CalculatorParser.NumberContext ctx) {
		return new NumberExpression(ctx.getText());
	}
}