package compiler;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import compiler.AST.*;
import compiler.FOOLParser.*;
import compiler.lib.*;

import java.util.ArrayList;
import java.util.List;

import static compiler.lib.FOOLlib.*;

public class ASTGenerationSTVisitor extends FOOLBaseVisitor<Node> {

	String indent;
    public boolean print;
	
    ASTGenerationSTVisitor() {}    
    ASTGenerationSTVisitor(boolean debug) { print=debug; }
        
    private void printVarAndProdName(ParserRuleContext ctx) {
        String prefix="";        
    	Class<?> ctxClass=ctx.getClass(), parentClass=ctxClass.getSuperclass();
        if (!parentClass.equals(ParserRuleContext.class)) // the var context is parentClass (and not ctxClass itself)
        	prefix=lowerizeFirstChar(extractCtxName(parentClass.getName()))+": production #";
    	System.out.println(indent+prefix+lowerizeFirstChar(extractCtxName(ctxClass.getName())));                               	
    }
        
    @Override
	public Node visit(ParseTree t) {
        String temp=indent;
        indent=(indent==null)?"":indent+"  ";
        Node result = super.visit(t);
        indent=temp;
        return result; 
	}

	@Override
	public Node visitProg(ProgContext c) {
		if (print) printVarAndProdName(c);
		return visit(c.progbody());
	}

	@Override
	public Node visitLetInProg(LetInProgContext c) { 
		if (print) printVarAndProdName(c);
        List<Node> dL = new ArrayList<>();
		for (DecContext dec : c.dec()) {
            dL.add(visit(dec));
        }
		return new ProgLetInNode(dL, visit(c.exp()));
	}

	@Override
	public Node visitNoDecProg(NoDecProgContext c) {
		if (print) printVarAndProdName(c);
		return new ProgNode(visit(c.exp()));
	}

	@Override
	public Node visitTimes(TimesContext c) {
		if (print) printVarAndProdName(c);
		return new TimesNode(visit(c.exp(0)), visit(c.exp(1)));
	}

	@Override
	public Node visitPlus(PlusContext c) {
		if (print) printVarAndProdName(c);
		return new PlusNode(visit(c.exp(0)), visit(c.exp(1)));
	}

	@Override
	public Node visitEq(EqContext c) {
		if (print) printVarAndProdName(c);
		return new EqualNode(visit(c.exp(0)), visit(c.exp(1)));
	}

	@Override
	public Node visitVardec(VardecContext c) {
		if (print) printVarAndProdName(c);

        Node n = null;

        if (c.ID()!=null) { //non-incomplete ST
            n = new VarNode(c.ID().getText(), visit(c.type()), visit(c.exp()));
            n.setLine(c.ID().getSymbol().getLine());
		}

        return n;
	}

	@Override
	public Node visitFundec(FundecContext c) {
		if (print) printVarAndProdName(c);

        List<ParNode> pL = new ArrayList<>();
        ParNode par = null;

        for (int i = 1; i <= (c.ID().size() - 1); i++) {
            par = new ParNode(c.ID(i).getText(), visit(c.type(i)));
            par.setLine(c.ID(i).getSymbol().getLine());
            pL.add(par);
        }

        List<Node> dL = new ArrayList<>();
        for (DecContext dec : c.dec()) {
            dL.add(visit(dec));
        }

        Node n = null;

        if (c.ID().size()>0) { //non-incomplete ST
            n = new FunNode(
                c.ID(0).getText(),
                visit(c.type(0)),
                pL,
                dL,
                visit(c.exp())
            );
            n.setLine(c.FUN().getSymbol().getLine());
        }
        visit(c.type(0));
        visit(c.exp());
        return n;
    }

	@Override
	public Node visitIntType(IntTypeContext c) {
		if (print) printVarAndProdName(c);
		return new IntTypeNode();
	}

	@Override
	public Node visitBoolType(BoolTypeContext c) {
		if (print) printVarAndProdName(c);
		return new BoolTypeNode();
	}

	@Override
	public Node visitInteger(IntegerContext c) {
		if (print) printVarAndProdName(c);
		int v = Integer.parseInt(c.NUM().getText());
		return new IntNode(c.MINUS()==null?v:-v);
	}

	@Override
	public Node visitTrue(TrueContext c) {
		if (print) printVarAndProdName(c);
		return new BoolNode(true);
	}

	@Override
	public Node visitFalse(FalseContext c) {
		if (print) printVarAndProdName(c);
		return new BoolNode(false);
	}

	@Override
	public Node visitIf(IfContext c) {
		if (print) printVarAndProdName(c);
		Node ifNode = visit(c.exp(0));
		Node thenNode = visit(c.exp(1));
		Node elseNode = visit(c.exp(2));
		return new IfNode(ifNode, thenNode, elseNode);
	}

	@Override
	public Node visitPrint(PrintContext c) {
		if (print) printVarAndProdName(c);
		return new PrintNode(visit(c.exp()));
	}

	@Override
	public Node visitPars(ParsContext c) {
		if (print) {
            printVarAndProdName(c);
        }

		return visit(c.exp());
	}

	@Override
	public Node visitId(IdContext c) {
		if (print) {
            printVarAndProdName(c);
        }

        Node n = null;
        n = new IdNode(c.ID().getText());
        n.setLine(c.ID().getSymbol().getLine());

        return n;
	}

	@Override
	public Node visitCall(CallContext c) {
		if (print) {
            printVarAndProdName(c);
        }

        List<Node> aL = new ArrayList<>();

        for (int i=0; i < c.exp().size(); i++) {
            aL.add(visit(c.exp(i)));
        }

        Node n = null;
        n = new CallNode(c.ID().getText(), aL);
        n.setLine(c.ID().getSymbol().getLine());

		return n;
	}
}

//n.setLine(c.ID().getSymbol().getLine());
