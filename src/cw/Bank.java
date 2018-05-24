package cw;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Bank {

    List<Account> accList = new ArrayList<>();
    BlockingQueue<Transaction> queue = new LinkedBlockingQueue<>();

    boolean bankTransferMoney (Transaction task){

        if (task.amount > 0 && task.getSrcAccID() != task.getDstAccID() && task.amount != 0){
            task.srcAccID.amount -= task.amount;
            task.dstAccID.amount += task.amount;
            System.out.println(Thread.currentThread().getName() +
                    " Сообщение для клиента: " +
                    task.srcAccID.client.userMail +
                    " Перевод на сумму " + task.getAmount() +
                    " произведён! Остаток " +
                    task.srcAccID.amount);
            return true;
        }
            System.out.println("Сообщение для клиента: " +
                    task.srcAccID.client.userMail +
                    " На счёте недостаточно средств!");
            return false;
    }
    public void addClient (Account acc){
        accList.add(acc);
    }

    public BlockingQueue<Transaction> getQueue() {
        return queue;
    }

    public List<Account> getAccList() {
        return accList;
    }
}
