package compiler;

import java.util.*;
import java.util.Map;

import compiler.AST.*;
import compiler.lib.*;
import compiler.lib.Node;

public class SymbolTableASTVisitor extends BaseASTVisitor<Void> {
	
	int stErrors=0;
	private List<Map<String, STentry>> symTable = new ArrayList<>();
	private int nestingLevel=0;
	//livello ambiente con dichiarazioni piu' esterno e' 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle e' symTable.get(nestingLevel)

	SymbolTableASTVisitor() {}
	SymbolTableASTVisitor(boolean debug) {super(debug);} // p=true enables print for debugging

	@Override
	public Void visitNode(ProgNode n) {
		if (print) printNode(n);
		visit(n.exp);
		return null;
	}
	
	@Override
	public Void visitNode(IntNode n) {
		if (print) printNode(n, n.val.toString());
		return null;
	}
	
	@Override
	public Void visitNode(PlusNode n) {
		if (print) printNode(n);
		visit(n.left);
		visit(n.right);
		return null;
	}
	
	@Override
	public Void visitNode(TimesNode n) {
		if (print) printNode(n);
		visit(n.left);
		visit(n.right);
		return null;
	}
	
	@Override
	public Void visitNode(EqualNode n) {
		if (print) printNode(n);
		visit(n.left);
		visit(n.right);
		return null;
	}
	
	@Override
	public Void visitNode(BoolNode n) {
		if (print) printNode(n, n.val.toString());
		return null;
	}
	
	@Override
	public Void visitNode(IfNode n) {
		if (print) printNode(n);
		visit(n.cond);
		visit(n.th);
		visit(n.el);
		return null;
	}
	
	@Override
	public Void visitNode(PrintNode n) {
		if (print) printNode(n);
		visit(n.exp);
		return null;
	}

//
	@Override
	public Void visitNode(ProgLetInNode n) {
		if (print) {
            printNode(n);
        }

        Map<String, STentry> hm = new HashMap<>();
        symTable.add(hm);

        for (Node dec : n.declist) {
            visit(dec);
        }

        visit(n.exp);
        symTable.removeFirst();

		return null;
	}

	@Override
	public Void visitNode(VarNode n) {
		if (print) {
            printNode(n, n.id);
        }

		visit(n.exp);

        Map<String, STentry> hm = symTable.get(nestingLevel);
        STentry e = new STentry(nestingLevel);

        if (hm.put(n.id, e) != null) {
            System.out.println("Var id " + n.id + " at line " + n.getLine() + " already declared");
            stErrors++;
        }

		return null;
	}

	@Override
	public Void visitNode(FunNode n) {
		if (print) {
            printNode(n, n.id);
        }

        Map<String, STentry> hm = symTable.get(nestingLevel);
        STentry e = new STentry(nestingLevel);

        if (hm.put(n.id, e) != null) {
            System.out.println("Fun id " + n.id + " at line " + n.getLine() + " already declared");
            stErrors++;
        }

        nestingLevel++;

        Map<String, STentry> nm = new HashMap<>();
        symTable.add(nm);

        for (ParNode par : n.parlist) {
            if (nm.put(par.id, e) != null) {
                System.out.println("Par id " + par.id + " at line " + par.getLine() + " already declared");
                stErrors++;
            }
        }

        for (Node dec : n.declist) {
            visit(dec);
        }
		visit(n.exp);
        symTable.remove(nestingLevel--);
		return null;
	}

	private STentry stLookup(String id) {
        int j = nestingLevel;
        STentry entry = null;

        while (j >= 0 && entry == null) {
            entry = symTable.get(j--).get(id);
        }

        return  entry;
    }
	
	@Override
	public Void visitNode(IdNode n) {
		if (print) {
            printNode(n);
        }

        STentry e = stLookup(n.id);

        if (e == null) {
            System.out.println("Var or Par id " + n.id + " at line " + n.getLine() + " is not declared");
            stErrors++;
        } else {
            n.entry = e;
        }

		return null;
	}

	@Override
	public Void visitNode(CallNode n) {
        if (print) {
            printNode(n);
        }

        for (Node arg : n.arglist) {
            visit(arg);
        }

        STentry e = stLookup(n.id);

        if (e == null) {
            System.out.println("Fun id " + n.id + " at line " + n.getLine() + " is not declared");
            stErrors++;
        } else {
            n.entry = e;
        }
        return null;
	}
}
