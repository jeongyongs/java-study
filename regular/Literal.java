package regular;

public final class Literal implements Expression { // invariable condition

    private char literal;

    public Literal(char literal) { // constructor
        this.literal = literal;
    }

    public char getLiteral() { // getter
        return this.literal;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
