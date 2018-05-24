package cw;

public class Transaction{
    long transID;
    final Account srcAccID;
    final Account dstAccID;
    int amount;
    Bank bank;

    public Transaction (long transID, Account srcAccID, Account dstAccID, int amount, Bank bank) {
        this.transID = transID;
        this.srcAccID = srcAccID;
        this.dstAccID = dstAccID;
        this.amount = amount;
        this.bank = bank;
    }
    public int getAmount() {
        return amount;
    }
    public Account getSrcAccID() {

        return srcAccID;
    }
    public Account getDstAccID() {
        return dstAccID;
    }

    public void setTransID(long transID) {
        this.transID = transID;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
