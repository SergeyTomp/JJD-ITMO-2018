package hw3;

//геттеры/сеттеры делать не стал, не это сейчас главное и времени нет

class Triangle {
    double x1, x2, x3;
    double y1, y2, y3;
    double a, b, с;

    Triangle (float x1, float y1, float x2, float y2, float x3, float y3){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y1 = y1;
        this.y1 = y1;
        a = getLength (x1, y1, x2, y2);
        b = getLength (x2, y2, x3, y3);
        с = getLength (x1, y1, x3, y3);
    }

    float getLength (double x1, double y1, double x2, double y2) {
        return (float)Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
    }

    void getSquare (){
        double halfPer = (a + b + с)/2;
        double square = Math.sqrt (halfPer*(halfPer - a)*(halfPer - b)*(halfPer - с));
        System.out.println ("Площадь = " + square);
    }

    double getPerimetr (){
        double р = (a + b + с);
        System.out.println ("Периметр = " + р);
        return р;
    }

    void getSides (){
            System.out.println ("Сторона А = " + a + "\n" + "Сторона В = " + b + "\n" + "Сторона C = " + с);
    }
}

class Rectangle {
    double a, b; //длины сторон
    double x1, y1; //координата одного угла
    double alfa; //угол поворота для получения остальных координат
    double x2, x3, x4; //вычисляемые координаты
    double y2, y3, y4; //вычисляемые координаты

    Rectangle (double a, double b, double x, double y, double alfa){
        this.a = a;
        this.b = b;
        this.alfa = alfa*2* Math.PI /360;
        x1 = x;
        y1 = y;
        x2 = x1 + a * Math.cos(alfa);
        y2 = y1 + a * Math.sin(alfa);
        x4 = x1 + b * Math.sin(alfa);
        y4 = y1 + b * Math.cos(alfa);
        x3 = x2 + b * Math.sin(alfa);
        y3 = y2 + b * Math.cos(alfa);
    }

    void getSquare (){
        System.out.println ("Площадь = " + a*b);
    }

    void getPerimetr (){
        System.out.println ("Периметр = " + (2*a + 2*b));
    }
}

class Circle {
    double x1, y1, r;

    Circle (double x1, double y1, double r){
        this.x1 = x1;
        this.y1 = y1;
        this.r = r;
    }

    void getSquare (){
        System.out.println ("Площадь = " + Math.PI*r*r);
    }

    void getPerimetr (){
        System.out.println ("Периметр = " + 2*Math.PI*r);
    }
}
public class Figures {
    public static void main (String [] args){
        Triangle triang1 = new Triangle (0, 0, 2, 3, 10, 10);
        Rectangle rect1 = new Rectangle (10, 20, 30, 30, 60);
        Circle circ1 = new Circle (0, 0, 10);
        System.out.println("Треугольник:");
        triang1.getPerimetr();
        triang1.getSquare();
        triang1.getSides ();
        System.out.println();
        System.out.println("Прямоугольник:");
        rect1.getPerimetr();
        rect1.getSquare();
        System.out.println();
        System.out.println("Круг:");
        circ1.getPerimetr();
        circ1.getSquare();
    }
}