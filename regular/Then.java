package regular;

public final class Then implements Expression {

    private BinaryOperator binaryOperator; // delegator

    public Then(Expression left, Expression right) {
        binaryOperator = new BinaryOperator(left, right);
    }

    public Expression getLeft() {
        return binaryOperator.getLeft();
    }

    public Expression getRight() {
        return binaryOperator.getRight();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
