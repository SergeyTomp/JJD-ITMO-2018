package Calc;

public class Multiply extends Operation {
    @Override
    protected double execute (double a, double b) {

        System.out.println("" + a + " x " + b + " = " + (a * b));
        return 0;
    }
}
