package hw1;
// проверка числа на простоту
public class Task6
{
    public static void main(String[] args)
    {
        // натуральное чисто N простое, если в диапазоне (2 - sqrt N) нет ни одного делителя
        int num = 98;
        for(int i = (int)Math.sqrt(num); i >= 1; i--)
        {
            if(((num % i) == 0) && (i != 1))
            {
                System.out.println("Заданное число - составное");
                break;
            }
            if(i == 1) System.out.println("Заданное число простое");
        }
    }
}
