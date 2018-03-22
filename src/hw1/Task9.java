package hw1;
//симметричное время
public class Task9
{
    public static void main(String[] args)
    {
        int cntr = 0;
        for (int hour = 0; hour < 24; hour++)
        {
            for (int minutes = 0; minutes < 60; minutes++)
            {
                if ((hour / 10)%10 == (minutes % 10) && ((minutes / 10)%10 == (hour % 10))) {cntr+=1;}
            }
        }
        System.out.print(cntr);
    }
}