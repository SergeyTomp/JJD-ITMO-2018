package taskManager;

import java.io.*;
import java.util.Scanner;

public class StartProcess {

    public static void main (String[]args) throws IOException, ClassNotFoundException {

        File dataBase = new File("dataBase.bin");
        Company ifmo;
        if(!dataBase.exists()) {
            ifmo = new Company();
        }
        else {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataBase))){
                ifmo = (Company) ois.readObject();
            }
        }

//        Company ifmo = new Company();
        Processor.initProcess(ifmo);
        try (ObjectOutputStream oouts = new ObjectOutputStream(new FileOutputStream(dataBase))){
            oouts.writeObject(ifmo);
        }
        System.exit(0);


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
