package regular;

public class BinaryOperator {

    private Expression left;
    private Expression right;

    public BinaryOperator(Expression left, Expression right) { // constructor
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() { // getter
        return left;
    }

    public Expression getRight() {
        return right;
    }
}

// type invariance, sub typing ---> interface : make type
// sub classing ---> abstract class : just macro, but i dont want that this can
// be type
// delegation ---> ~Impl, ~Base, etc.,
