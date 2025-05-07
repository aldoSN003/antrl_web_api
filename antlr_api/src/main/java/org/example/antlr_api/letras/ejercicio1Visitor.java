// Generated from /home/josealdo/antrl_api_web/antlr_api/src/main/java/org/example/antlr_api/ejercicio1.g4 by ANTLR 4.13.2
package org.example.antlr_api.letras;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ejercicio1Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ejercicio1Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ejercicio1Parser#prule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrule(ejercicio1Parser.PruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ejercicio1Parser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA(ejercicio1Parser.AContext ctx);
	/**
	 * Visit a parse tree produced by {@link ejercicio1Parser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitB(ejercicio1Parser.BContext ctx);
}