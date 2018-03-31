package Calc;

public class Divide extends Operation {
    @Override
    protected double execute (double a, double b){
        if (b == 0){
            System.out.println ("Error: Impossible to divide by zero");
            return  -1;
        }
        System.out.println("" + a + " / " + b + " = " + (a / b));
        return 0;
    }
}
