package compiler;

import compiler.AST.*;
import compiler.lib.BaseASTVisitor;
import compiler.lib.Node;

public class PrintASTVisitor extends BaseASTVisitor<Void> {

    String indent;

    void printNode(Node n) {
        System.out.println(indent + extractNodeName(n.getClass().getName()));
    }

    void printNode(Node n, String s) {
        System.out.println(indent + extractNodeName(n.getClass().getName()) + ": " + s);
    }

    String extractNodeName(String s) {
        return s.substring(s.lastIndexOf('$') + 1, s.length()-4);
    }

    public Void visit(Node n) {
        String temp=indent;
        indent=(indent==null) ? "" : indent + "  ";
        super.visit(n);
        indent=temp;
        return null;
    }

    public Void visitNode(ProgNode n) {
		printNode(n);
        visit(n.exp);
        return null;
	}

	public Void visitNode(PlusNode n) {
		printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
	}

	public Void visitNode(TimesNode n) {
		printNode(n);
        visit(n.left);
        visit(n.right);
        return null;
	}

	public Void visitNode(IntNode n) {
		printNode(n, " " + n.val);  // must also print value!
        return null;
	}

    public Void visitNode(EqualNode e) {
        printNode(e);
        visit(e.left);
        visit(e.right);
        return null;
    }

    public Void visitNode(BoolNode b) {
        printNode(b, " " + b.flag);
        return null;
    }

    public Void visitNode(IfNode ifNode) {
        printNode(ifNode);
        visit(ifNode.condition);
        visit(ifNode.solution);
        visit(ifNode.alternative);
        return null;
    }

    public Void visitNode(PrintNode p) {
        printNode(p);
        visit(p.content);
        return null;
    }
}





