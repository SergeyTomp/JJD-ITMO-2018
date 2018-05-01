package taskManager;

import java.util.Scanner;
import static taskManager.CommandStrings.*;

public class TaskProcessor {

    public static void main (String[]args){

        Company ifmo = new Company();
        Scanner scaner = new Scanner(System.in);
        boolean login = false;
        Staff operator = null;
        while (true) {
            while (!login) {
                System.out.println("Ведите логин: ");
                String data = scaner.nextLine();
                if (ifmo.staffList.containsKey(data)) {
                    // теперь переменной родителя Staff присваивается ссылка на выбранного по логину наследника
                    // дальше вся работа идёт с обезличеным оператором
                    operator = ifmo.staffList.get(data);
                    login = true;
                } else {
                    System.out.println("Неверный логин!");
                }
            }

            login = false;
            int trials = 0;
            while (!login) {
                System.out.println("Ведите пароль: ");
                String data = scaner.nextLine();
                if (data.equals(operator.getPass())) {
                    login = true;
                } else {
                    System.out.println("Неверный пароль!");
                    trials += 1;
                }
                if (trials > 3) {
                    System.exit(0);
                }
            }

            while (login) {
                System.out.println("Введите команду:");
                String data = scaner.nextLine();
//                try {

                    if (login = operator.accessTable.get(AccessLevel.valueOf(operator.access)).contains(CommandStrings.valueOf(data))){
                        login = CommandFactory.getHandler(CommandStrings.valueOf(data)).make(operator);
                    }
                    else {
                        System.out.println("У вас нет доступа");
                    }

//                }
//                catch (IllegalArgumentException e){
//                    System.out.println("Введена несуществующая команда");
//                }
//                catch (NullPointerException e){
//                    System.out.println("У вас нет доступа");
//                }
                // дальше по аналогии с работой меню:
                // handler команды запрашивает параметры, если они ему нужны согласно текста команды,
                // принимает ввод и продолжает выполнение метода
            }
        }
    }
}
