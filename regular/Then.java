package regular;

public final class Then implements Expression {

    private Expression left;
    private Expression right;

    public Then(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public String prettyPrint() {
        return "(" + left.prettyPrint() + right.prettyPrint() + ")";
    }
}
