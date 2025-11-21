package compiler;

import compiler.AST.*;
import compiler.lib.*;

public class CalcASTVisitor extends BaseASTVisitor<Integer> {

	@Override
	public Integer visitNode(ProgNode n) {
	   return visit(n.exp);
	}

	@Override
	public Integer visitNode(PlusNode n) {
	    return visit(n.left) + visit(n.right);
	}

	@Override
	public Integer visitNode(TimesNode n) {
		return visit(n.left) * visit(n.right);
	}

	@Override
	public Integer visitNode(IntNode n) {
        return n.val;
	}

    public Integer visitNode(EqualNode e) {
        return visit(e.left) == visit(e.right) ? 1 : 0;
    }

    public Integer visitNode(BoolNode b) {
        return b.flag ? 1 : 0;
    }

    public Integer visitNode(IfNode i) {
        visit(i.condition);

        if (visit(i.condition) == 1) {
            return visit(i.solution);
        } else {
            return visit(i.alternative);
        }
    }

    public Integer visitNode(PrintNode p) {
        return visit(p.content);
    }
}
