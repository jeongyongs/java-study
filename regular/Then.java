package regular;

public final class Then implements Expression {

    private BinaryOperator binaryOperator; // delegator

    public Then(Expression left, Expression right) {
        binaryOperator = new BinaryOperator(left, right, "");
    }

    @Override
    public String prettyPrint() {
        return binaryOperator.prettyPrint();
    }
}
