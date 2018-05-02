package taskManager;

import java.util.Scanner;

public class Processor {
    public static int initProcess(Company company){
        Scanner scaner = new Scanner(System.in);
        int login =0;
        Staff operator = null;
        while (true) {
            while (login == 0) {
                System.out.println("Ведите логин: ");
                String data = scaner.nextLine();
                if (company.staffList.containsKey(data)) {
                    // теперь переменной родителя Staff присваивается ссылка на выбранного по логину наследника
                    // дальше вся работа идёт с обезличеным оператором
                    operator = company.staffList.get(data);
                    login = 1;
                } else {
                    System.out.println("Неверный логин!");
                }
            }

            login = 0;
            int trials = 0;
            while (login == 0) {
                System.out.println("Ведите пароль: ");
                String data = scaner.nextLine();
                if (data.equals(operator.getPass())) {
                    login = 1;
                } else {
                    System.out.println("Неверный пароль!");
                    trials += 1;
                }
                if (trials > 3) {
                    System.exit(0);
                }
            }

            while (login == 1) {
                System.out.println("Введите команду:");
                try{
                    CommandStrings data = CommandStrings.valueOf(scaner.nextLine());
                    if (operator.accessTable.get(operator.access).contains(data)){
                        login = CommandFactory.getHandler(data).make(operator);
                    }
                    else {
                        System.out.println("У вас нет доступа");
                    }
                }
                catch (IllegalArgumentException e){
                    System.out.println("Введена несуществующая команда");
                }
                if (login == -1){
                    return 0;
                }
            }
        }
    }
}
