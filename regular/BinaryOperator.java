package regular;

public class BinaryOperator {

    private Expression left;
    private Expression right;
    private String symbol;

    public BinaryOperator(Expression left, Expression right, String symbol) { // constructor
        this.left = left;
        this.right = right;
        this.symbol = symbol;
    }

    public Expression getLeft() { // getter
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public String prettyPrint() {
        return "(" + left.prettyPrint() + symbol + right.prettyPrint() + ")";
    }
}

// type invariance, sub typing ---> interface : make type
// sub classing ---> abstract class : just macro, but i dont want that this can
// be type
// delegation ---> ~Impl, ~Base, etc.,
