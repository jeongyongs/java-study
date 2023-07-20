package regular;

public class Plus extends BinaryOperator implements Expression {

    public Plus(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
