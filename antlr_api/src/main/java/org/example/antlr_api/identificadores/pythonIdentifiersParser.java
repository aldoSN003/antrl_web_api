// Generated from /home/josealdo/IdeaProjects/antlr_api/src/main/java/org/example/antlr_api/pythonIdentifiers.g4 by ANTLR 4.13.2
package org.example.antlr_api.identificadores;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class pythonIdentifiersParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Letter=1, Digit=2, OpenParenthesis=3, ClosingParenthesis=4, EqualSign=5, 
		InputWord=6, DataType=7, WS=8;
	public static final int
		RULE_identifier = 0, RULE_right = 1, RULE_sentence = 2, RULE_test = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"identifier", "right", "sentence", "test"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'('", "')'", "'='", "'input'", "'int'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Letter", "Digit", "OpenParenthesis", "ClosingParenthesis", "EqualSign", 
			"InputWord", "DataType", "WS"
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

	@Override
	public String getGrammarFileName() { return "pythonIdentifiers.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public pythonIdentifiersParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public List<TerminalNode> Letter() { return getTokens(pythonIdentifiersParser.Letter); }
		public TerminalNode Letter(int i) {
			return getToken(pythonIdentifiersParser.Letter, i);
		}
		public List<TerminalNode> Digit() { return getTokens(pythonIdentifiersParser.Digit); }
		public TerminalNode Digit(int i) {
			return getToken(pythonIdentifiersParser.Digit, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pythonIdentifiersListener ) ((pythonIdentifiersListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pythonIdentifiersListener ) ((pythonIdentifiersListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pythonIdentifiersVisitor ) return ((pythonIdentifiersVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			match(Letter);
			setState(12);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Letter || _la==Digit) {
				{
				{
				setState(9);
				_la = _input.LA(1);
				if ( !(_la==Letter || _la==Digit) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(14);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RightContext extends ParserRuleContext {
		public TerminalNode DataType() { return getToken(pythonIdentifiersParser.DataType, 0); }
		public List<TerminalNode> OpenParenthesis() { return getTokens(pythonIdentifiersParser.OpenParenthesis); }
		public TerminalNode OpenParenthesis(int i) {
			return getToken(pythonIdentifiersParser.OpenParenthesis, i);
		}
		public TerminalNode InputWord() { return getToken(pythonIdentifiersParser.InputWord, 0); }
		public List<TerminalNode> ClosingParenthesis() { return getTokens(pythonIdentifiersParser.ClosingParenthesis); }
		public TerminalNode ClosingParenthesis(int i) {
			return getToken(pythonIdentifiersParser.ClosingParenthesis, i);
		}
		public RightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_right; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pythonIdentifiersListener ) ((pythonIdentifiersListener)listener).enterRight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pythonIdentifiersListener ) ((pythonIdentifiersListener)listener).exitRight(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pythonIdentifiersVisitor ) return ((pythonIdentifiersVisitor<? extends T>)visitor).visitRight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightContext right() throws RecognitionException {
		RightContext _localctx = new RightContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_right);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			match(DataType);
			setState(16);
			match(OpenParenthesis);
			setState(17);
			match(InputWord);
			setState(18);
			match(OpenParenthesis);
			setState(19);
			match(ClosingParenthesis);
			setState(20);
			match(ClosingParenthesis);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SentenceContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EqualSign() { return getToken(pythonIdentifiersParser.EqualSign, 0); }
		public RightContext right() {
			return getRuleContext(RightContext.class,0);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pythonIdentifiersListener ) ((pythonIdentifiersListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pythonIdentifiersListener ) ((pythonIdentifiersListener)listener).exitSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pythonIdentifiersVisitor ) return ((pythonIdentifiersVisitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sentence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			identifier();
			setState(23);
			match(EqualSign);
			setState(24);
			right();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TestContext extends ParserRuleContext {
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public TestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof pythonIdentifiersListener ) ((pythonIdentifiersListener)listener).enterTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof pythonIdentifiersListener ) ((pythonIdentifiersListener)listener).exitTest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof pythonIdentifiersVisitor ) return ((pythonIdentifiersVisitor<? extends T>)visitor).visitTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TestContext test() throws RecognitionException {
		TestContext _localctx = new TestContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_test);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			sentence();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\b\u001d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0005"+
		"\u0000\u000b\b\u0000\n\u0000\f\u0000\u000e\t\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0000\u0000\u0004\u0000\u0002\u0004\u0006\u0000\u0001\u0001\u0000\u0001"+
		"\u0002\u0019\u0000\b\u0001\u0000\u0000\u0000\u0002\u000f\u0001\u0000\u0000"+
		"\u0000\u0004\u0016\u0001\u0000\u0000\u0000\u0006\u001a\u0001\u0000\u0000"+
		"\u0000\b\f\u0005\u0001\u0000\u0000\t\u000b\u0007\u0000\u0000\u0000\n\t"+
		"\u0001\u0000\u0000\u0000\u000b\u000e\u0001\u0000\u0000\u0000\f\n\u0001"+
		"\u0000\u0000\u0000\f\r\u0001\u0000\u0000\u0000\r\u0001\u0001\u0000\u0000"+
		"\u0000\u000e\f\u0001\u0000\u0000\u0000\u000f\u0010\u0005\u0007\u0000\u0000"+
		"\u0010\u0011\u0005\u0003\u0000\u0000\u0011\u0012\u0005\u0006\u0000\u0000"+
		"\u0012\u0013\u0005\u0003\u0000\u0000\u0013\u0014\u0005\u0004\u0000\u0000"+
		"\u0014\u0015\u0005\u0004\u0000\u0000\u0015\u0003\u0001\u0000\u0000\u0000"+
		"\u0016\u0017\u0003\u0000\u0000\u0000\u0017\u0018\u0005\u0005\u0000\u0000"+
		"\u0018\u0019\u0003\u0002\u0001\u0000\u0019\u0005\u0001\u0000\u0000\u0000"+
		"\u001a\u001b\u0003\u0004\u0002\u0000\u001b\u0007\u0001\u0000\u0000\u0000"+
		"\u0001\f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}