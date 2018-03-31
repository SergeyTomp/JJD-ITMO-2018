package Calc;

public class Accum {

    Operation operation;
    Accum (Operation operation){
        this.operation = operation;
    }

    protected void accum (double frst, double scnd){
        operation.execute(frst, scnd);
    }
    //перегружаем метод для выполнения действий с одним аргументом
    protected void accum (double arg){
        operation.execute( arg );
    }

    public static void main (String []args){
        //можно так, как на уроке, но непонятно зачем и перегржать метод нужно в двух местах, в Accum и Operation
        Accum acc = new Accum(new Plus());
        acc.accum(5, 3);
        acc = new Accum(new Divide());
        acc.accum(5,3);
        acc.accum(5,0);
        acc = new Accum(new Opposite());
        acc.accum(5);
        acc = new Accum(new Sqrt());
        acc.accum(-1);
        acc = new Accum(new Subtract());
        acc.accum(5, 9);
        acc = new Accum(new Multiply ());
        acc.accum(5, 9);
        acc = new Accum(new Percent ());
        acc.accum(5, 9);

        //мне кажется лучше так, это проще и перегрузка метода только в Operation
        Operation oper = new Plus();
        oper.execute(7, 3);
        oper = new Sqrt();
        oper.execute(7);
    }
}
