package usecases;

interface Top {
    default void accept(Visitor v) {
        v.visit(this);
    }
}

class Left implements Top {
}

class Right implements Top {
}

interface Visitor {
    default void visit(Top top) {
        throw new NoSuchMethodError();
    }

    void visit(Left left);

    void visit(Right right);
}

class 걸어 implements Visitor {
    public void visit(Left left) {
        System.out.println("왼쪽으로 걸어");
    };

    public void visit(Right right) {
        System.out.println("오른쪽으로 걸어");
    }
}

class 뛰어 implements Visitor {
    public void visit(Left left) {
        System.out.println("왼쪽으로 뛰어");
    };

    public void visit(Right right) {
        System.out.println("오른쪽으로 뛰어");
    }
}

class 실험 {
    public static void main(String[] args) {
        Top leftTop = new Left();
        Top rightTop = new Right();
        leftTop.accept(new 걸어());
        rightTop.accept(new 뛰어());
    }
}
