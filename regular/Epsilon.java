package regular;

public final class Epsilon implements Expression {

    private static Epsilon instance;

    private Epsilon() { // constructor
    }

    public static Epsilon getInstance() { // singleton pattern
        if (instance == null) {
            instance = new Epsilon();
        }
        return instance;
    }

    @Override
    public String prettyPrint() {
        return "\u03B5";
    }
}