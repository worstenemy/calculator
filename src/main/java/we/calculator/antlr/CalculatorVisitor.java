// Generated from C:/Users/Lenovo/Desktop/calculator/src/main/java/we/calculator\Calculator.g4 by ANTLR 4.7
package we.calculator.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalculatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalculatorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#calculate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalculate(CalculatorParser.CalculateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(CalculatorParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simple}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple(CalculatorParser.SimpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lowOrder}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLowOrder(CalculatorParser.LowOrderContext ctx);
	/**
	 * Visit a parse tree produced by the {@code highOrder}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHighOrder(CalculatorParser.HighOrderContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(CalculatorParser.NumberContext ctx);
}