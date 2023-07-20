package regular;

public interface Expression {

    public default Expression or(Expression expression) { // or
        return new Or(this, expression);
    }

    public default Expression then(Expression expression) { // then
        return new Then(this, expression);
    }

    public default Expression star() { // star
        return new Star(this);
    }

    void accept(Visitor visitor);
}
