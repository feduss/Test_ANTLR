package test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.BitSet;

public class SyntaxErrorListener implements ANTLRErrorListener {

    ArrayList<String> syntaxErrorList = new ArrayList<>();

    public SyntaxErrorListener(){}

    ArrayList<String> getSyntaxErrorList(){
        return syntaxErrorList;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        //super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
        /*syntaxErrorList.add("\nrecognizer: " + recognizer.toString() +
                "\noffendingSymbol: " + offendingSymbol.toString() +
                "\nline: " + line +
                "\ncharPositionInLine: " + charPositionInLine +
                "\nmgs: " + msg +
                "\ne: " + e);*/
        syntaxErrorList.add(msg + " at line " + line + ", char " + charPositionInLine);
    }

    @Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
        syntaxErrorList.add("reportAmbiguity!");
    }

    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
        syntaxErrorList.add("reportAttemptingFullContext!");
    }

    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
        syntaxErrorList.add("reportContextSensitivity!");
    }
}
