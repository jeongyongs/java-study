package fold;

@FunctionalInterface
public interface BinaryOperator {

    public int apply(int x, int y);
}
