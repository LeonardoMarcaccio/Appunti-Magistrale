package compiler;

import compiler.lib.BaseASTVisitor;
import compiler.lib.Node;

public class AST {
    public static class ProgNode implements Node {
		Node exp;
		ProgNode(Node e) { exp=e; }

        @Override
        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visitNode(this);
        }
	}

	public static class PlusNode implements Node {
		Node left;
		Node right;
		PlusNode(Node l, Node r) { left=l; right=r; }

        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visitNode(this);
        }
	}

	public static class TimesNode implements Node {
		Node left;
		Node right;
		TimesNode(Node l, Node r) { left=l; right=r; }

        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visitNode(this);
        }
	}

	public static class IntNode implements Node {
		Integer val;
		IntNode(Integer n) { val=n; }

        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visitNode(this);
        }
	}

    public static class EqualNode implements Node {
        Node left;
        Node right;

        EqualNode(Node l, Node r) {
            left=l;
            right=r;
        }

        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visitNode(this);
        }
    }

    public static class BoolNode implements Node {
        Boolean flag;

        BoolNode(Boolean f) {
            flag=f;
        }

        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visitNode(this);
        }
    }

    public static class IfNode implements Node {
        Node condition;
        Node solution;
        Node alternative;

        IfNode(Node c, Node s, Node a) {
            condition = c;
            solution = s;
            alternative = a;
        }

        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visitNode(this);
        }
    }

    public static class PrintNode implements Node {
        Node content;

        PrintNode(Node c) {
            content=c;
        }

        public <S> S accept(BaseASTVisitor<S> visitor) {
            return visitor.visitNode(this);
        }
    }
}
