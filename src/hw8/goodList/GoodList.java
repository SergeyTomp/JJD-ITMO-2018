package hw8.goodList;

// переделал код ближе к ООП подходу, без многочисленных вложенных if-else
// реализованы проверки на корректность команды, полноту данных, корректность числового значения

import java.util.Scanner;

public class GoodList {
    public static final String ADD = "add data";
    public static final String SHOW = "show data";
    public static final String CLOSE = "close";

    public static void main (String [] args) {

        Journal transactList = new Journal();
        Scanner scaner = new Scanner(System.in);

        while (true) {
            System.out.println("Ведите команду: ");
            String data = scaner.nextLine();
            if (data.equals(ADD)) {
                System.out.println("Введите данные: ");
                data = scaner.nextLine();
                if (transactList.addTransact(data) != 0){
                    System.out.println("Некорректные данные!");
                }
            }
            else if (data.equals(SHOW)) {
                transactList.showJournal();
            }
            else if (data.equals(CLOSE)) {
                System.exit(0);
            }
            else System.out.println("Некорректная команда!");

        }
    }
}
