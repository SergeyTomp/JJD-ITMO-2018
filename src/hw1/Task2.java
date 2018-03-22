package hw1;

//корни квадратного уравнения
public class Task2 {
    public static void main(String[] args) {
        float a = 2;
        float b = 18;
        float c = 36;
        double discr = (b * b) - (4 * a * c);
        float root1 = 0;
        float root2 = 0;
        if (discr == 0) {
            root1 = -1 * (b / (2 * a));
            System.out.println("Уравнеие имеет 1 квадратный корень, который равен " + root1);
        } else if (discr > 0) {
            root1 = ((-1 * b) + (float) Math.sqrt(discr)) / (2 * a);
            root2 = ((-1 * b) - (float) Math.sqrt(discr)) / (2 * a);
            System.out.println("Уравнение имеет 2 квадратных корня: " + root1 + " и " + root2);
        } else {
            System.out.println("Уравнение не имеет квадратных корней");
        }
    }
}
