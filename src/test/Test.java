package test;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Test {

    public static void main (String[] args){
        try{
            //Lexer(input) -> Tokens(lexer) -> Parser(Tokens)
            //the foundation of every ANTLR program: you create the stream of chars from the input,
            // you give it to the lexer and it transforms them in tokens, that are then interpreted by the parser.

            //String input = "se il button1 viene cliccato, allora la lista viene mostrata";
            String input = "if de button b1 is cclicked then the label l1 is hidden";
            ///Custom Lexer ->  A lexer takes the individual characters and transforms them
            // in tokens, the atoms that the parser uses to create the logical structure
            TesiLexer tesiLexer = new TesiLexer(CharStreams.fromString(input));
            tesiLexer.removeErrorListeners();
            //Create syntax error listener
            SyntaxErrorListener errorListener = new SyntaxErrorListener();
            //Add it to lexer
            tesiLexer.addErrorListener(errorListener);
            ///https://www.antlr.org/api/Java/org/antlr/v4/runtime/CommonTokenStream.html
            CommonTokenStream commonTokenStream = new CommonTokenStream(tesiLexer);

            ///Custom Parser
            TesiParser tesiParser = new TesiParser(commonTokenStream);
            tesiParser.removeErrorListeners();
            //Add prev syntax error listener to parser
            tesiParser.addErrorListener(errorListener);

            tesiParser.setBuildParseTree(true);
            //Set the root of parse tree as upper parser rules i've defined, aka blocks
            TesiParser.BlocksContext treeRoot = tesiParser.blocks();

            TesiParserBaseVisitor visitor = new TesiParserBaseVisitor();
            visitor.visit(treeRoot);

            if(tesiParser.getNumberOfSyntaxErrors() == 0){
                //Se ha riconosciuto regole
                if(tesiParser.getRuleNames() != null || tesiParser.getRuleNames().length == 0) {
                    System.out.println("Rules detected: " + tesiParser.getRuleNames().length);

                    //Concatena i nomi delle regole in una string
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String rule : tesiParser.getRuleNames()) {
                        //System.out.println("\n " + rule);
                        stringBuilder.append(rule);
                        stringBuilder.append(" ;");
                    }
                    //System.out.println(tree.toStringTree(tesiParser));
                    //E poi la visualizza
                    System.out.println(stringBuilder.toString());
                }
                else{
                    System.out.println("No rules detected.");
                }
            }
            else{
                System.out.println("\nCheck the following " + tesiParser.getNumberOfSyntaxErrors()  + " error/s and try again:");
                for(String error : errorListener.getSyntaxErrorList()){
                    System.out.println("- " + error);
                }
            }
        }
        catch (Exception error){
            System.out.println(error.toString());
        }
    }
}
