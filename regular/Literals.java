package regular;

public class Literals {

    public static String of(Expression expression) {
        PrettyPrinter prettyPrinter = new PrettyPrinter();
        expression.accept(prettyPrinter);
        return prettyPrinter.getPrettyString().toString();
    }
}
