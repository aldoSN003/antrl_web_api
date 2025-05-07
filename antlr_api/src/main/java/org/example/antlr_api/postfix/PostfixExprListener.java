// Generated from /home/josealdo/antrl_api_web/antlr_api/src/main/java/org/example/antlr_api/PostfixExpr.g4 by ANTLR 4.13.2
package org.example.antlr_api.postfix;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PostfixExprParser}.
 */
public interface PostfixExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PostfixExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PostfixExprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PostfixExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PostfixExprParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryOperation}
	 * labeled alternative in {@link PostfixExprParser#validExpr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperation(PostfixExprParser.BinaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryOperation}
	 * labeled alternative in {@link PostfixExprParser#validExpr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperation(PostfixExprParser.BinaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleOperand}
	 * labeled alternative in {@link PostfixExprParser#validExpr}.
	 * @param ctx the parse tree
	 */
	void enterSingleOperand(PostfixExprParser.SingleOperandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleOperand}
	 * labeled alternative in {@link PostfixExprParser#validExpr}.
	 * @param ctx the parse tree
	 */
	void exitSingleOperand(PostfixExprParser.SingleOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link PostfixExprParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(PostfixExprParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link PostfixExprParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(PostfixExprParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link PostfixExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(PostfixExprParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PostfixExprParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(PostfixExprParser.OperatorContext ctx);
}