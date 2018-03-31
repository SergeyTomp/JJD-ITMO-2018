package Calc;

public class Sqrt extends Operation{

    @Override
    protected double execute (double a){
        if (a < 0){
            System.out.println ("Error: SQRT from negative number is imaginary");
            return  -1;
        }
        System.out.println("SQRT " +  a + " = " + (Math.sqrt(a)));
        return 0;
    }
}
