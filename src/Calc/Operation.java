package Calc;

public class Operation {

    protected double execute (double a, double b){
        return 0;
    }
    //перегружаем метод для выполнения действий с одним аргументом
    protected double execute (double a){
        return 0;
    }
}
