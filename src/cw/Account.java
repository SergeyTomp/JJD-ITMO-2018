package cw;

public class Account {
    int accID;
    int amount;
    User client;

    public Account(int amount, User client, int accID) {
        this.amount = amount;
        this.client = client;
        this.accID = accID;
    }
}
