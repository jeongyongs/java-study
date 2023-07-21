package usecases;

class 물체 {
    private int n = 0;

    public 물체(int m) {
        n = m;
    }

    public void modify(int m) {
        n = m;
    }

    public String toString() {
        return "" + n;
    }
}

public class CallByValue {
    public static void callByValue(int 복사본) {
        복사본 = 0;
    }

    public static void callByValue(물체 copy) {
        copy.modify(0);
    }

    public static void main(String[] args) {
        int 원본 = 1;
        System.out.println(원본);
        callByValue(원본);
        System.out.println(원본);

        물체 source = new 물체(1);
        System.out.println(source);
        callByValue(source);
        System.out.println(source);
    }
}
