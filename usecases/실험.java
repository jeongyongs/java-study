package usecases;

interface Top {
    default void accept(Visitor v) {
        printDirection();
        v.visit(this);
    }

    void printDirection();
}

class Left implements Top {
    @Override
    public void printDirection() {
        System.out.print("왼쪽으로 ");
    }
}

class Right implements Top {
    @Override
    public void printDirection() {
        System.out.print("오른쪽으로 ");
    }
}

interface Visitor {
    void visit(Top top);
}

class 걸어 implements Visitor {
    @Override
    public void visit(Top top) {
        System.out.println("걸어");
    }
}

class 뛰어 implements Visitor {
    @Override
    public void visit(Top top) {
        System.out.println("뛰어");
    }
}

public class 실험 {
    public static void main(String[] args) {
        Top leftTop = new Left();
        Top rightTop = new Right();
        leftTop.accept(new 걸어());
        rightTop.accept(new 뛰어());
    }
}
