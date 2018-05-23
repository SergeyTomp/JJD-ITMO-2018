package cw;

import java.util.Map;

import static cw.TransPermit.IDLE;

public class Bank {

    Map <Account, User> accList;
    TransPermit transOpen = IDLE;

    public Bank(Map<Account, User> accList) {
        this.accList = accList;
    }

    boolean bankTransferMoney (Account src, Account dst, int value){
        if (src.amount >= 0 && src.client != dst.client){
            src.amount = src.amount - value;
            dst.amount = dst.amount + value;
            return true;
        }
        else {
            System.out.println("Сообщение для клиента: " + src.client.userMail + "На счёте недостаточно средств!");
            return false;
        }
    }
}
