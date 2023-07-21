package fold;

public class Fold {

    private final static Predicate even = x -> x % 2 == 0;
    private final static Predicate odd = x -> x % 2 != 0;
    private final static BinaryOperator plus = (x, y) -> x + y; // rambda expression with variable definition
    private final static BinaryOperator muliply = (x, y) -> x * y;

    static int fold(BinaryOperator binaryOperator, int init, int... numbers) { // sum
        return foldIf(x -> true, binaryOperator, init, numbers);
    }

    private static int foldIf(Predicate predicate, BinaryOperator binaryOperator, int init, int[] numbers) {
        int result = init;

        for (int number : numbers) {
            if (predicate.apply(number)) {
                result = binaryOperator.apply(result, number);
            }
        }
        return result;
    }

    private static int sumIf(Predicate predicate, int... numbers) {
        return foldIf(predicate, plus, 0, numbers);
    }

    private static int productIf(Predicate predicate, int... numbers) {
        return foldIf(predicate, muliply, 1, numbers);
    }

    public static int sum(int... numbers) {
        return fold(plus, 0, numbers);
    }

    public static int sumOdd(int... numbers) {
        return sumIf(odd, numbers);
    }

    public static int sumEven(int... numbers) {
        return sumIf(even, numbers);
    }

    public static int product(int... numbers) {
        return fold(muliply, 1, numbers);
    }

    public static int productEven(int... numbers) {
        return productIf(even, numbers);
    }

    public static int productOdd(int... numbers) {
        return productIf(odd, numbers);
    }
}

// abstract fold and foldIF, which one is modified? more detailed one
// If i wanna make predicate gets 2 params, then how?
