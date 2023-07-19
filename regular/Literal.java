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
    public String prettyPrint() {
        return "" + literal;
    }
}
