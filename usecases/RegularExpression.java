package usecases;

import regular.Epsilon;
import regular.Expression;
import regular.Literal;
import regular.Literals;
import regular.Plus;
import regular.PrettyPrinter;

public final class RegularExpression {

    private RegularExpression() { // prevent new
    };

    public static void main(String[] args) {
        Literal a = new Literal('a');
        Literal b = new Literal('b');

        Expression a_ab = a.or(a.then(b)); // sugar syntax
        Expression ba_a0n = b.then(a).or(Epsilon.getInstance().or(a.star())); // sugar syntax
        Expression plus = new Plus(a_ab, ba_a0n);

        System.out.println(Literals.of(plus));
    }
}
