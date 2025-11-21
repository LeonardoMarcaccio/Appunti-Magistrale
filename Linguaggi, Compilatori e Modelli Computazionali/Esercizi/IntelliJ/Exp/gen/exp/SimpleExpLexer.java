// Generated from C:/Users/xxsal/Desktop/Appunti Magistrale/Linguaggi, Compilatori e Modelli Computazionali/Esercizi/IntelliJ/Exp/src/exp/SimpleExp.g4 by ANTLR 4.13.2
package exp;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimpleExpLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MINUS=1, TIMES=2, LPAR=3, RPAR=4, NUM=5, WHITESP=6, COMMENT=7, ERR=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"MINUS", "TIMES", "LPAR", "RPAR", "NUM", "WHITESP", "COMMENT", "ERR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-'", "'*'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MINUS", "TIMES", "LPAR", "RPAR", "NUM", "WHITESP", "COMMENT", 
			"ERR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	    int lexicalErrors=0;


	public SimpleExpLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleExp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 7:
			ERR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:

			    System.out.println("Invalid char: "+ getText());
			    lexicalErrors++;

			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\b=\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004\u001d\b\u0004\n\u0004\f\u0004 \t\u0004\u0003\u0004\"\b\u0004"+
		"\u0001\u0005\u0004\u0005%\b\u0005\u000b\u0005\f\u0005&\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006/\b"+
		"\u0006\n\u0006\f\u00062\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u00010\u0000\b\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0001\u0000\u0001\u0003\u0000\t\n"+
		"\r\r  @\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0001"+
		"\u0011\u0001\u0000\u0000\u0000\u0003\u0013\u0001\u0000\u0000\u0000\u0005"+
		"\u0015\u0001\u0000\u0000\u0000\u0007\u0017\u0001\u0000\u0000\u0000\t!"+
		"\u0001\u0000\u0000\u0000\u000b$\u0001\u0000\u0000\u0000\r*\u0001\u0000"+
		"\u0000\u0000\u000f8\u0001\u0000\u0000\u0000\u0011\u0012\u0005-\u0000\u0000"+
		"\u0012\u0002\u0001\u0000\u0000\u0000\u0013\u0014\u0005*\u0000\u0000\u0014"+
		"\u0004\u0001\u0000\u0000\u0000\u0015\u0016\u0005(\u0000\u0000\u0016\u0006"+
		"\u0001\u0000\u0000\u0000\u0017\u0018\u0005)\u0000\u0000\u0018\b\u0001"+
		"\u0000\u0000\u0000\u0019\"\u00050\u0000\u0000\u001a\u001e\u000219\u0000"+
		"\u001b\u001d\u000209\u0000\u001c\u001b\u0001\u0000\u0000\u0000\u001d "+
		"\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001f"+
		"\u0001\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 \u001e\u0001"+
		"\u0000\u0000\u0000!\u0019\u0001\u0000\u0000\u0000!\u001a\u0001\u0000\u0000"+
		"\u0000\"\n\u0001\u0000\u0000\u0000#%\u0007\u0000\u0000\u0000$#\u0001\u0000"+
		"\u0000\u0000%&\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001"+
		"\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000()\u0006\u0005\u0000\u0000"+
		")\f\u0001\u0000\u0000\u0000*+\u0005/\u0000\u0000+,\u0005*\u0000\u0000"+
		",0\u0001\u0000\u0000\u0000-/\t\u0000\u0000\u0000.-\u0001\u0000\u0000\u0000"+
		"/2\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00000.\u0001\u0000\u0000"+
		"\u000013\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u000034\u0005/\u0000"+
		"\u000045\u0005*\u0000\u000056\u0001\u0000\u0000\u000067\u0006\u0006\u0000"+
		"\u00007\u000e\u0001\u0000\u0000\u000089\t\u0000\u0000\u00009:\u0006\u0007"+
		"\u0001\u0000:;\u0001\u0000\u0000\u0000;<\u0006\u0007\u0000\u0000<\u0010"+
		"\u0001\u0000\u0000\u0000\u0005\u0000\u001e!&0\u0002\u0000\u0001\u0000"+
		"\u0001\u0007\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}