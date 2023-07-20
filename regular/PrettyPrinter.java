package regular;

public class PrettyPrinter implements Visitor {

    private StringBuilder prettyString;

    public PrettyPrinter() {
        this.prettyString = new StringBuilder();
    }

    @Override
    public void visit(Epsilon e) {
        this.prettyString.append('\u03B5');
    }

    @Override
    public void visit(Literal e) {
        this.prettyString.append(e.getLiteral());
    }

    @Override
    public void visit(Or e) {
        this.prettyString.append('(');
        e.getLeft().accept(this);
        this.prettyString.append('|');
        e.getRight().accept(this);
        this.prettyString.append(')');
    }

    @Override
    public void visit(Then e) {
        this.prettyString.append('(');
        e.getLeft().accept(this);
        e.getRight().accept(this);
        this.prettyString.append(')');
    }

    @Override
    public void visit(Star e) {
        this.prettyString.append('(');
        e.getExpression().accept(this);
        this.prettyString.append(')');
        this.prettyString.append('*');
    }

    @Override
    public void visit(Plus e) {
        this.prettyString.append('(');
        e.getLeft().accept(this);
        this.prettyString.append('+');
        e.getRight().accept(this);
        this.prettyString.append(')');
    }

    public StringBuilder getPrettyString() {
        return prettyString;
    }
}
