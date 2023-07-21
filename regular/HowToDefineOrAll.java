package regular;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class HowToDefineOrAll {

    public static Expression orAll(String literals) { // orAll
        List<Expression> expressionList = new LinkedList<Expression>();

        for (int i = 0, n = literals.length(); i < n; i++) {
            expressionList.add(new Literal(literals.charAt(i)));
        }
        return orAll(expressionList);
    }

    public static Expression orAll(Iterable<Expression> expressions) { // orAll
        Expression orExpression = Epsilon.getInstance();

        for (Expression expression : expressions)
            orExpression = orExpression.or(expression);

        return orExpression;
    }

    public static Expression orStream(String literals) { // onStream
        return orStream(literals.chars().mapToObj(integer -> (new Literal((char) integer))));
    }

    public static Expression orStream(Stream<Expression> expressions) { // onStream
        return expressions.reduce(Epsilon.getInstance(), Expression::or);
    }

    private static <ReturnType> ReturnType operationWithElapsedTimeInMillis(
            String doSomething,
            Supplier<ReturnType> delayedOperation) { // check running time

        long startTime = Calendar.getInstance().getTimeInMillis();
        ReturnType returnValue = delayedOperation.get();
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("It took " + (endTime - startTime) + " ms" +
                " to " + doSomething + ".");
        return returnValue;
    }

    public static void main(String[] args) { // entry point
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
