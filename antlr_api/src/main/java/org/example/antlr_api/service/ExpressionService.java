package org.example.antlr_api.service;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.antlr_api.identificadores.pythonIdentifiersLexer;
import org.example.antlr_api.identificadores.pythonIdentifiersParser;
import org.springframework.stereotype.Service;

import static org.antlr.v4.runtime.CharStreams.fromString;

@Service
public class ExpressionService {

    public String parseExpression(String input) {
        try {
            CharStream ch = fromString(input + "\n");
            pythonIdentifiersLexer lexer = new pythonIdentifiersLexer(ch);
            CommonTokenStream token = new CommonTokenStream(lexer);
            pythonIdentifiersParser parser = new pythonIdentifiersParser(token);

            // Capture the system.err output to include it in the response
            StringBuilder errors = new StringBuilder();
            System.setErr(new java.io.PrintStream(new java.io.OutputStream() {
                @Override
                public void write(int b) {
                    errors.append((char) b);
                }
            }));

            ParseTree tree = parser.test();
            String parseTree = tree.toStringTree(parser);

            // Reset the system.err
            System.setErr(System.err);

            // Construct a JSON response containing both the parse tree and any errors
            StringBuilder response = new StringBuilder();
            response.append("{\n");
            response.append("  \"parseTree\": \"").append(parseTree.replace("\"", "\\\"")).append("\",\n");

            if (errors.length() > 0) {
                response.append("  \"errors\": \"").append(errors.toString().trim().replace("\"", "\\\"")).append("\"\n");
            } else {
                response.append("  \"errors\": \"\"\n");
            }

            response.append("}");

            System.out.println("Sending response: " + response.toString());
            return response.toString();
        } catch (Exception e) {
            return "{ \"parseTree\": \"\", \"errors\": \"Error parsing expression: " + e.getMessage().replace("\"", "\\\"") + "\" }";
        }
    }
}