package hw8.taskLister;

import java.util.Scanner;

public class TaskProcessor {

    public static void main (String[]args){

        Company ifmo = new Company();
        Scanner scaner = new Scanner(System.in);
        boolean login = false;
        Staff operator = null;

        while (!login){
            System.out.println("Ведите логин: ");
            String data = scaner.nextLine();
            if (ifmo.staffList.containsKey(data)){
                // теперь переменной родителя Staff присваивается ссылка на выбранного по логину наследника
                // дальше вся работа идёт с обезличеным оператором
                operator = ifmo.staffList.get(data);
                login = true;
            }
        else{
                System.out.println("Неверный логин!");
            }
        }

        login = false;
        int trials = 0;
        while (!login){
            System.out.println("Ведите пароль: ");
            String data = scaner.nextLine();
            if (data.equals(operator.getPass())){
                login = true;
            }
            else {
                System.out.println("Неверный пароль!");
                trials += 1;
            }
            if (trials > 3){
                System.exit(0);
            }
        }

        while (login){
            System.out.println("Введите команду:");
            String data = scaner.nextLine();
            operator.commands.get(data).make();
            // дальше по аналогии с работой меню:
            // handler команды запрашивает параметры, если они ему нужны согласно текста команды,
            // принимает ввод и продолжает выполнение метода
            //запросы пока не реализованы, но методы описаны в admin и worker
            // примерная реализация запросов параметров в классе Worker в подклассах Take и Complete
            // остальные классы для в Worker содержат метод без параметров
            // нужно прописать это всё админу, там все команды требуют параметров.
            // но идея должна быть понятна
        }
    }
}
