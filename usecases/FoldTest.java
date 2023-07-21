package usecases;

import fold.Fold;

public class FoldTest {
    public static void main(String[] args) { // entry point
        System.out.println(Fold.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(Fold.product(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(Fold.sumEven(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(Fold.sumOdd(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(Fold.productEven(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(Fold.productOdd(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}
