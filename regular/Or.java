package regular;

public final class Or extends BinaryOperator implements Expression {

    public Or(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
