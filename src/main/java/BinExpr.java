/**
 * Created by rluble on 3/19/15.
 */
public class BinExpr extends Expr {
    private Expr e1;
    private Expr e2;
    private String op;
    public BinExpr(String op, Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    public int eval() {
        int e1Val = e1.eval();
        int e2Val = e2.eval();
        if (op.equals("+")) {
            return e1Val + e2Val;
        } else if (op.equals("-")) {
            return e1Val - e2Val;
        } else if (op.equals("*")) {
        return e1Val * e2Val;
        } else if (op.equals("/")) {
            return e1Val / e2Val;
        }
        throw new IllegalStateException();
    }

    @Override
    public String print() {
        return "(" + e1.print() + op + e2.print() + ")";
    }
}
