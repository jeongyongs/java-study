package regular;

public final class Or implements Expression {

    private Expression left;
    private Expression right;

    public Or(Expression left, Expression right) { // constructor
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() { // getter
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public String prettyPrint() {
        return "(" + left.prettyPrint() + "|" + right.prettyPrint() + ")";
    }
}
