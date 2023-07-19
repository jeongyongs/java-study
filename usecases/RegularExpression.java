package usecases;

import regular.Epsilon;
import regular.Expression;
import regular.Literal;
import regular.Or;
import regular.Star;
import regular.Then;

public final class RegularExpression {

    private RegularExpression() {
    };

    public static void main(String[] args) {
        Literal a = new Literal('a');
        Literal b = new Literal('b');

        Expression a_ab = new Or(a, new Then(a, b));
        System.out.println(a_ab.prettyPrint());
        a_ab = a.or(a.then(b)); // sugar syntax
        System.out.println(a_ab.prettyPrint());

        Expression ba_a0n = new Or(new Then(b, a), new Or(Epsilon.getInstance(), new Star(a)));
        System.out.println(ba_a0n.prettyPrint());
        ba_a0n = b.then(a).or(Epsilon.getInstance().or(a.star())); // sugar syntax
        System.out.println(ba_a0n.prettyPrint());
    }
}
