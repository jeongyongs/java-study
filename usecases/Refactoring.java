package usecases;

class ImperativeCalculator {

    private int result;

    public ImperativeCalculator() {
        this.result = 0;
    }

    public void add(int num) {
        this.result += num;
    }

    public void subtract(int num) {
        this.result -= num;
    }

    public void multiply(int num) {
        this.result *= num;
    }

    public void divide(int num) {
        if (num != 0) {
            this.result /= num;
        } else {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
    }

    public int getResult() {
        return this.result;
    }

    public static void main(String[] args) {
        ImperativeCalculator calculator = new ImperativeCalculator();
        calculator.add(5);
        calculator.multiply(2);
        calculator.subtract(3);
        calculator.divide(2);
        System.out.println("Result: " + calculator.getResult());
    }
}
