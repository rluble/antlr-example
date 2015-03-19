/**
 * Created by rluble on 3/19/15.
 */
public class IntValue extends Expr {
    private int value;
    public IntValue(int v) {
        this.value = v;
    }
    @Override
    public int eval() {
        return value;
    }

    @Override
    public String print() {
        return String.valueOf(value);
    }
}
