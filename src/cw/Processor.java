package cw;

public class Processor implements Runnable{

    Bank bank;
    Processor(Bank bank){
        this.bank = bank;
    }
    @Override
    public void run() {
        while (true){
            try {
                Transaction task = bank.queue.take();
                synchronized (task.srcAccID.accID < task.dstAccID.accID ? task.srcAccID : task.dstAccID) {
                    synchronized (task.srcAccID.accID < task.dstAccID.accID ? task.dstAccID : task.srcAccID){
                        bank.bankTransferMoney(task);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
