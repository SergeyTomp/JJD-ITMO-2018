package hw1;
//выводbv на экран ближайшее к 10 из двух чисел, записанных в переменные
public class Task1
{
 public static void main (String [] args)
 {
     float num1 = 8.36f;
     float num2 = 15.9f;
     int pnt = 10;
     float dif1 = pnt - num1;
     if (dif1 < 0){dif1 = dif1 - 2*dif1;} //берём модуль если разница отрицательная
     float dif2 = pnt - num2;
     if (dif2 < 0){dif2 = dif2 - 2*dif2;} //берём модуль если разница отрицательная
     if (dif1 == dif2) {System.out.println("Числа равноудалены от " + pnt);}
     else {System.out.println("Из " + num1 + " и " + num2 + " ближайшее к " + pnt + " число " + ((dif1 < dif2) ? num1:num2));}
 }
}
