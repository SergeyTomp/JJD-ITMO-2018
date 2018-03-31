package Calc;

public class Opposite extends Operation{

    @Override
    protected double execute (double a){
        System.out.println("" + "1" + " / " + a + " = " + (1 / a));
        return 0;
    }
}
