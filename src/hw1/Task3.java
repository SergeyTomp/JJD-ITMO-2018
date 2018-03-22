package hw1;
//ищем наибольшую цифру в трёхзначном числе
public class Task3
{
    public static void main (String [] args)
    {
        int x = 982;
        int a = x%10;
        int b = (x/10)%10;
        int c = (x/100)%10;
        if(((a >= b) && (a > c))||((a > b) && (a >= c))){System.out.println("В числе " + x + " наибольшая цифра " + a);}
        else if ((b > a) && (b >= c)) {System.out.println("В числе " + x + " наибольшая цифра " + b);}
        else {System.out.println("В числе " + a + " наибольшая цифра " + c);}
    }
}
