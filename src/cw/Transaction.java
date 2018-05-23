package cw;

import static cw.TransPermit.IDLE;

public class Transaction implements Runnable{
    private long transID;
    private final Account srcAccID;
    private final Account dstAccID;
    private int amount;
    private Bank bank;

    public Transaction (long transID, Account srcAccID, Account dstAccID, int amount, Bank bank) {
        this.transID = transID;
        this.srcAccID = srcAccID;
        this.dstAccID = dstAccID;
        this.amount = amount;
    }

    @Override
    public void run() {
        synchronized (srcAccID.accID < dstAccID.accID ? srcAccID : dstAccID) {
            synchronized (srcAccID.accID < dstAccID.accID ? dstAccID : srcAccID){
                bank.bankTransferMoney(srcAccID, dstAccID, amount);

            }
        }
    }
}
