package org.example.antlr_api.service;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import org.example.antlr_api.identificadores.pythonIdentifiersLexer;
import org.example.antlr_api.identificadores.pythonIdentifiersParser;

import org.springframework.stereotype.Service;

import static org.antlr.v4.runtime.CharStreams.fromString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpressionService {

    public String parseExpression(String input) {
        try {
            System.out.println("Input received: '" + input + "'");

            // Create the lexer and parser
            CharStream ch = fromString(input + "\n");
            pythonIdentifiersLexer lexer = new pythonIdentifiersLexer(ch);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Capture errors
            StringBuilder errors = new StringBuilder();
            java.io.PrintStream originalErr = System.err;
            System.setErr(new java.io.PrintStream(new java.io.OutputStream() {
                @Override
                public void write(int b) {
                    errors.append((char) b);
                }
            }));

            // First, get all tokens
            lexer.reset();
            tokens.fill();
            List<Map<String, Object>> tokenList = new ArrayList<>();

            // Debug: Print all tokens to console
            System.out.println("Tokens found:");
            for (Token token : tokens.getTokens()) {
                System.out.println("Token: " + token.getText() + ", Type: " + token.getType() +
                        ", Line: " + token.getLine() + ", Column: " + token.getCharPositionInLine());

                // Skip EOF tokens for the response
                if (token.getType() != Token.EOF) {
                    Map<String, Object> tokenInfo = new HashMap<>();
                    String tokenTypeName;

                    // Get token type name - try symbolic first, then literal, then number
                    tokenTypeName = lexer.getVocabulary().getSymbolicName(token.getType());
                    if (tokenTypeName == null) {
                        tokenTypeName = lexer.getVocabulary().getLiteralName(token.getType());
                        if (tokenTypeName == null) {
                            tokenTypeName = "TOKEN_" + token.getType();
                        }
                    }

                    tokenInfo.put("type", tokenTypeName);
                    tokenInfo.put("text", token.getText());
                    tokenInfo.put("line", token.getLine());
                    tokenInfo.put("column", token.getCharPositionInLine());
                    tokenList.add(tokenInfo);
                }
            }

            System.out.println("Total tokens found: " + tokenList.size());

            // Reset for parsing
            tokens.seek(0);
            pythonIdentifiersParser parser = new pythonIdentifiersParser(tokens);

            // Parse the expression
            ParseTree tree = parser.test();
            String parseTree = tree.toStringTree(parser);

            // Reset the system.err
            System.setErr(originalErr);

            // Construct a JSON response containing the parse tree, tokens, and any errors
            // Construct JSON response with additional debugging information
            StringBuilder response = new StringBuilder();
            response.append("{\n");
            response.append("  \"parseTree\": \"").append(parseTree.replace("\"", "\\\"")).append("\",\n");

            // Add token count for debugging
            response.append("  \"tokenCount\": ").append(tokenList.size()).append(",\n");

            // Add tokens array
            response.append("  \"tokens\": [\n");
            for (int i = 0; i < tokenList.size(); i++) {
                Map<String, Object> tokenInfo = tokenList.get(i);
                response.append("    {\n");
                response.append("      \"type\": \"").append(tokenInfo.get("type")).append("\",\n");
                response.append("      \"text\": \"").append(String.valueOf(tokenInfo.get("text")).replace("\"", "\\\"")).append("\",\n");
                response.append("      \"line\": ").append(tokenInfo.get("line")).append(",\n");
                response.append("      \"column\": ").append(tokenInfo.get("column")).append("\n");
                response.append("    }").append(i < tokenList.size() - 1 ? ",\n" : "\n");
            }
            response.append("  ],\n");

            if (errors.length() > 0) {
                response.append("  \"errors\": \"").append(errors.toString().trim().replace("\"", "\\\"")).append("\"\n");
            } else {
                response.append("  \"errors\": \"\"\n");
            }

            response.append("}");

            // Print the final JSON response for debugging
            String finalResponse = response.toString();
            System.out.println("Response JSON (first 500 chars): " +
                    (finalResponse.length() > 500 ? finalResponse.substring(0, 500) + "..." : finalResponse));

            return finalResponse;
        } catch (Exception e) {
            return "{ \"parseTree\": \"\", \"tokens\": [], \"errors\": \"Error parsing expression: " + e.getMessage().replace("\"", "\\\"") + "\" }";
        }
    }
}