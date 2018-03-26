package hw2;
//Для проверки остаточных знаний учеников после летних каникул.......
public class Task8 {
    public static void main(String[] args) {
        int rnd_min = 2;
        int rnd_max = 9;
        int arr2d [][] = new int[15][3];
        for (int i=0; i<arr2d.length; i++){
            for (int j=0; j<arr2d[i].length; j++){
                //если элемемент не третий, просто заполняем
                if (j != arr2d[i].length - 1){
                    arr2d[i][j] = (int)(Math.random()*(rnd_max - rnd_min + 1) + rnd_min);
                }
                else {
                    //третий элемент = произведение первых двух
                    arr2d[i][j] = arr2d[i][j-1]*arr2d[i][j-2];
                    //начиная со второй строки проверяем совпадения результататов
                    if (i>0){
                        for (int k=0; k<i; k++){
                            //если произведение совпало с каким-то из предыдущих, то и множители совпадают, даже если и в другом порядке
                            if (arr2d[i][j] == arr2d[k][j]){
                                i -=1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (int i=0; i<arr2d.length; i++){
            System.out.println("Пример №" + (i+1) + " " + arr2d[i][0] + " x " + arr2d[i][1] + " =?");
        }
    }
}
