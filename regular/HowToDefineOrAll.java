package regular;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class HowToDefineOrAll {

    public static Expression orAll(String literals) {
        List<Expression> expressionList = new LinkedList<Expression>();

        for (int i = 0, n = literals.length(); i < n; i++) {
            expressionList.add(new Literal(literals.charAt(i)));
        }
        return orAll(expressionList);
    }

    public static Expression orAll(Iterable<Expression> expressions) {
        Expression orExpression = Epsilon.getInstance();

        for (Expression expression : expressions)
            orExpression = orExpression.or(expression);

        return orExpression;
    }

    public static Expression orStream(String literals) {
        List<Expression> expressionList = new ArrayList<Expression>();
        Expression orExpression = Epsilon.getInstance();

        expressionList.add(orExpression);
        for (int i = 0, n = literals.length(); i < n; i++) {
            expressionList.add(new Literal(literals.charAt(i)));
        }
        return orStream(expressionList.stream());
    }

    public static Expression orStream(Stream<Expression> expressions) {
        return expressions.reduce((e1, e2) -> e1.or(e2)).get();
    }

    private static <ReturnType> ReturnType operationWithElapsedTimeInMillis(
            String doSomething,
            Supplier<ReturnType> delayedOperation) {

        long startTime = Calendar.getInstance().getTimeInMillis();
        ReturnType returnValue = delayedOperation.get();
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("It took " + (endTime - startTime) + " ms" +
                " to " + doSomething + ".");
        return returnValue;
    }

    public static void main(String[] args) {
        final String 닿소리 = "ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ";
        final String 홀소리 = "ㅏㅑㅓㅕㅗㅛㅜㅠㅡㅣ";
        final String[] 한글 = { 홀소리, 닿소리 };

        for (String literals : 한글) {
            System.out.println(Literals
                    .of(operationWithElapsedTimeInMillis("orAll( " + literals + " )", () -> orAll(literals))));
            System.out.println(Literals.of(operationWithElapsedTimeInMillis("orStream( "
                    + literals + " )", () -> orStream(literals))));
        }
    }
}