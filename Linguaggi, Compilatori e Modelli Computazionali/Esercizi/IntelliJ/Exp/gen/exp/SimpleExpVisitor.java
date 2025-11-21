// Generated from C:/Users/xxsal/Desktop/Appunti Magistrale/Linguaggi, Compilatori e Modelli Computazionali/Esercizi/IntelliJ/Exp/src/exp/SimpleExp.g4 by ANTLR 4.13.2
package exp;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleExpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleExpVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleExpParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(SimpleExpParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expProd2}
	 * labeled alternative in {@link SimpleExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpProd2(SimpleExpParser.ExpProd2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code expProd3}
	 * labeled alternative in {@link SimpleExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpProd3(SimpleExpParser.ExpProd3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code expProd1}
	 * labeled alternative in {@link SimpleExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpProd1(SimpleExpParser.ExpProd1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code expProd4}
	 * labeled alternative in {@link SimpleExpParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpProd4(SimpleExpParser.ExpProd4Context ctx);
}