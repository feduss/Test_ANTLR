// Generated from TesiParser.g4 by ANTLR 4.8
package test;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TesiParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TesiParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TesiParser#blocks}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlocks(TesiParser.BlocksContext ctx);
	/**
	 * Visit a parse tree produced by {@link TesiParser#if_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_else(TesiParser.If_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TesiParser#view}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitView(TesiParser.ViewContext ctx);
	/**
	 * Visit a parse tree produced by {@link TesiParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(TesiParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TesiParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(TesiParser.AssignmentContext ctx);
}