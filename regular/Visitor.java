package regular;

public interface Visitor {

    void visit(Epsilon e);

    void visit(Literal e);

    void visit(Or e);

    void visit(Then e);

    void visit(Star e);

    void visit(Plus e);
}
