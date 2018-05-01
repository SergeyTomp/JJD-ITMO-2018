package taskManager;

import java.util.Scanner;

public class TaskProcessor {

    public static void main (String[]args){

        Company ifmo = new Company();
        Processor.initProcess(ifmo);
//        Scanner scaner = new Scanner(System.in);
//        boolean login = false;
//        Staff operator = null;
//        while (true) {
//            while (!login) {
//                System.out.println("Ведите логин: ");
//                String data = scaner.nextLine();
//                if (ifmo.staffList.containsKey(data)) {
//                    // теперь переменной родителя Staff присваивается ссылка на выбранного по логину наследника
//                    // дальше вся работа идёт с обезличеным оператором
//                    operator = ifmo.staffList.get(data);
//                    login = true;
//                } else {
//                    System.out.println("Неверный логин!");
//                }
//            }
//
//            login = false;
//            int trials = 0;
//            while (!login) {
//                System.out.println("Ведите пароль: ");
//                String data = scaner.nextLine();
//                if (data.equals(operator.getPass())) {
//                    login = true;
//                } else {
//                    System.out.println("Неверный пароль!");
//                    trials += 1;
//                }
//                if (trials > 3) {
//                    System.exit(0);
//                }
//            }
//
//            while (login) {
//                System.out.println("Введите команду:");
//                try{
//                    CommandStrings data = CommandStrings.valueOf(scaner.nextLine());
//                    if (operator.accessTable.get(operator.access).contains(data)){
//                        login = CommandFactory.getHandler(data).make(operator);
//                    }
//                    else {
//                        System.out.println("У вас нет доступа");
//                    }
//                }
//                catch (IllegalArgumentException e){
//                    System.out.println("Введена несуществующая команда");
//                }
//            }
//        }
    }
}
