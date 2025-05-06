// Generated from /home/josealdo/IdeaProjects/antlr_api/src/main/java/org/example/antlr_api/pythonIdentifiers.g4 by ANTLR 4.13.2
package org.example.antlr_api.identificadores;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link pythonIdentifiersParser}.
 */
public interface pythonIdentifiersListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link pythonIdentifiersParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(pythonIdentifiersParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link pythonIdentifiersParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(pythonIdentifiersParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link pythonIdentifiersParser#right}.
	 * @param ctx the parse tree
	 */
	void enterRight(pythonIdentifiersParser.RightContext ctx);
	/**
	 * Exit a parse tree produced by {@link pythonIdentifiersParser#right}.
	 * @param ctx the parse tree
	 */
	void exitRight(pythonIdentifiersParser.RightContext ctx);
	/**
	 * Enter a parse tree produced by {@link pythonIdentifiersParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(pythonIdentifiersParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link pythonIdentifiersParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(pythonIdentifiersParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link pythonIdentifiersParser#test}.
	 * @param ctx the parse tree
	 */
	void enterTest(pythonIdentifiersParser.TestContext ctx);
	/**
	 * Exit a parse tree produced by {@link pythonIdentifiersParser#test}.
	 * @param ctx the parse tree
	 */
	void exitTest(pythonIdentifiersParser.TestContext ctx);
}