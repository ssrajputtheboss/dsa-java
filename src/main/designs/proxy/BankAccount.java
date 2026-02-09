package main.designs.proxy;

abstract public class BankAccount {
    private static final long MAX_ADD_LIMIT = 10000, MAX_DEDUCT_LIMIT=1000;
    private final Object lock = new Object();
    private Long balance;
    public long getBalance(){
        return balance;
    }
    public BankAccount(long balance){
        this.balance = balance;
    }
    protected void add(long amount){
        if(amount > MAX_ADD_LIMIT){
            throw new RuntimeException("Amount exceeds limit");
        }
        synchronized (lock){
            balance+=amount;
        }
    }
    protected void deduct(long amount){
        if(amount > MAX_DEDUCT_LIMIT){
            throw new RuntimeException("LIMIT exceeded");
        }
        if(amount > balance){
            throw new RuntimeException("Not enough balance");
        }
        synchronized (lock){
            balance-=amount;
        }
    }
}
