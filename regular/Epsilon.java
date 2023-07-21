package regular;

public final class Epsilon implements Expression {

    private static Epsilon instance;

    private Epsilon() { // constructor
    }

    public static synchronized Epsilon getInstance() { // singleton pattern
        if (instance == null) {
            instance = new Epsilon();
        }
        return instance;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
