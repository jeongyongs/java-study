package usecases;

class Calculator {

    private final int value;

    public Calculator(int value) {
        this.value = value;
    }

    public Calculator add(int num) {
        return new Calculator(this.value + num);
    }

    public Calculator subtract(int num) {
        return new Calculator(this.value - num);
    }

    public Calculator multiply(int num) {
        return new Calculator(this.value * num);

    }

    public Calculator divide(int num) {
        if (num != 0) {
            return new Calculator(this.value / num);
        }
        throw new IllegalArgumentException("Cannot divide by zero.");
    }

    public int getValue() {
        return this.value;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(0);

        int result = calculator.add(5)
                .multiply(2)
                .subtract(3)
                .divide(2)
                .getValue();

        System.out.println("Result: " + result);
    }
}
