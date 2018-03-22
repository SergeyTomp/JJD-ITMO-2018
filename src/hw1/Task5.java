package hw1;
// циклы для вывода последовательностей
public class Task5
{
    public static void main(String[] args)
    {
        for (int i = 1000; i <= 1999; i += 3) //вместо 1999 надо 9999, но уж очень много выйдет
        {System.out.print(i + " ");}
        System.out.println();
        for (int i = 90; i >= 0; i -= 5)
        {System.out.print(i + " ");}
        System.out.println();
        int i = 2;
        for (int j = 0; j < 20; j++)
        {
            System.out.print(i + " ");
            i *= 2;
        }
    }
}