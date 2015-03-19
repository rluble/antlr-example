/**
 * Created by rluble on 3/19/15.
 */
public class UnaryExpr extends Expr {
    private Expr e;
    private String op;
    public UnaryExpr(String op, Expr e) {
        this.e = e;
        this.op = op;
    }

    public int eval() {
        assert op.equals("-");
        return - e.eval();
    }

    @Override
    public String print() {
        return "(-" + e.print() + ")";
    }
}
