package cw;

import java.util.Map;

public class Bank {

    private Map <Account, User> accList;

    public Bank(Map<Account, User> accList) {
        this.accList = accList;
    }

    boolean bankTransferMoney (Account src, Account dst, int value){
        if (src.amount >= 0 && src != dst){
            src.amount = src.amount - value;
            dst.amount = dst.amount + value;
            return true;
        }
        else {
            System.out.println("Сообщение для клиента: " + src.client.userMail + "На счёте недостаточно средств!");
            return false;
        }
    }
    public void addClient (User usr, Account acc){
        accList.put(acc, usr);
    }
}
