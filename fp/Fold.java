package fp;

// ---------------------------------------------------- Fold class
public class Fold {

    public static void main(String[] args) { // entry point
        System.out.println(sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(product(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    static int fold(BinaryOperator binaryOperator, int... numbers) { // sum
        int result = binaryOperator.getId();

        for (int number : numbers) {
            result = binaryOperator.apply(result, number);
        }
        return result;
    }

    static int sum(int... numbers) { // syntax sugar
        return fold(new Plus(), numbers);
    }

    static int product(int... numbers) {
        return fold(new Multiply(), numbers);
    }
}

// ---------------------------------------------------- BinaryOperator interface
interface BinaryOperator {

    public int getId();

    public int apply(int x, int y);
}

// ---------------------------------------------------- Plus class
class Plus implements BinaryOperator {

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int apply(int x, int y) {
        return x + y;
    }
}

// ---------------------------------------------------- Multiply class
class Multiply implements BinaryOperator {

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public int apply(int x, int y) {
        return x * y;
    }
}
