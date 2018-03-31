package Calc;

public class Percent extends Operation {
    @Override
    protected double execute (double a, double b) {
        System.out.println("" + a + " % от " + b + " = " + (a * b / 100));
        return 0;
    }
}
