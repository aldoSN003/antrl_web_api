// Generated from /home/josealdo/IdeaProjects/antlr_api/src/main/java/org/example/antlr_api/pythonIdentifiers.g4 by ANTLR 4.13.2
package org.example.antlr_api.identificadores;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link pythonIdentifiersParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface pythonIdentifiersVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link pythonIdentifiersParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(pythonIdentifiersParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link pythonIdentifiersParser#right}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRight(pythonIdentifiersParser.RightContext ctx);
	/**
	 * Visit a parse tree produced by {@link pythonIdentifiersParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(pythonIdentifiersParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link pythonIdentifiersParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest(pythonIdentifiersParser.TestContext ctx);
}