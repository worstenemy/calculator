// Generated from C:/Users/Lenovo/Desktop/calculator/src/main/java/we/calculator\Calculator.g4 by ANTLR 4.7
package we.calculator.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#calculate}.
	 * @param ctx the parse tree
	 */
	void enterCalculate(CalculatorParser.CalculateContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#calculate}.
	 * @param ctx the parse tree
	 */
	void exitCalculate(CalculatorParser.CalculateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paren}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParen(CalculatorParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParen(CalculatorParser.ParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simple}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSimple(CalculatorParser.SimpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simple}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSimple(CalculatorParser.SimpleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lowOrder}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLowOrder(CalculatorParser.LowOrderContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lowOrder}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLowOrder(CalculatorParser.LowOrderContext ctx);
	/**
	 * Enter a parse tree produced by the {@code highOrder}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterHighOrder(CalculatorParser.HighOrderContext ctx);
	/**
	 * Exit a parse tree produced by the {@code highOrder}
	 * labeled alternative in {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitHighOrder(CalculatorParser.HighOrderContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(CalculatorParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(CalculatorParser.NumberContext ctx);
}