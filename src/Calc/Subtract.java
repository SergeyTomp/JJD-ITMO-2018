package Calc;

public class Subtract extends Operation{
    @Override
    protected double execute (double a, double b) {

        System.out.println("" + a + " - " + b + " = " + (a - b));
        return 0;
    }
}
