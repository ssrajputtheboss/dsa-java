package main.designs.proxy;

public class ATM extends BankAccount{

    public ATM(long balance) {
        super(balance);
    }
    public void withdraw(long amount){
        super.deduct(amount);
    }

    public void deposit(long amount){
        super.add(amount);
    }
}
