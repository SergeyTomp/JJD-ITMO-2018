package Calc;

public class Plus extends Operation {
    @Override
    protected double execute (double a, double b){

        System.out.println("" + a + " + " + b + " = " + (a + b));
        return 0;
    }
}
