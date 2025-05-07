// Generated from /home/josealdo/antrl_api_web/antlr_api/src/main/java/org/example/antlr_api/PostfixExpr.g4 by ANTLR 4.13.2
package org.example.antlr_api.postfix;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PostfixExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PostfixExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PostfixExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PostfixExprParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryOperation}
	 * labeled alternative in {@link PostfixExprParser#validExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperation(PostfixExprParser.BinaryOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleOperand}
	 * labeled alternative in {@link PostfixExprParser#validExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleOperand(PostfixExprParser.SingleOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostfixExprParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(PostfixExprParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PostfixExprParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(PostfixExprParser.OperatorContext ctx);
}