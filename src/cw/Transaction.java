package cw;

import static cw.TransPermit.IDLE;

public class Transaction implements Runnable{
    long transID;
    Account srcAccID;
    Account dstAccID;
    int amount;
    Bank bank;

    public Transaction (long transID, Account srcAccID, Account dstAccID, int amount, Bank bank) {
        this.transID = transID;
        this.srcAccID = srcAccID;
        this.dstAccID = dstAccID;
        this.amount = amount;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                synchronized (bank) {
                    bank.wait();
                    if (bank.transOpen == IDLE) {
                        bank.bankTransferMoney(srcAccID, dstAccID, amount);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bank.notify();
        }
    }
}
