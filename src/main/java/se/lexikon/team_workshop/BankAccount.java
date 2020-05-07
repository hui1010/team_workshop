package se.lexikon.team_workshop;

public class BankAccount {
    private final int accountId;
    private double balance;
    private final Customer customer;


    public BankAccount(int accountId, double balance, Customer customer) {
        this.accountId = accountId;
        this.balance = balance;
        this.customer = customer;
    }

    public int getAccountId() {
        return accountId;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }



    public double withdraw(double amount){
        //have to make sure withdraw amount is valid, that means not bigger than balance, not negative
        if (validWithdraw(amount)){
            //remove that much from balance
            this.balance -= amount;
            return amount;
        }else{
            return -1;
        }
    }

    private boolean validWithdraw(double amount) { // to see if the amount input is valid
        if(amount < 0){
            return false;
        }
        if(this.balance < amount) {
            return false;
        }
        return true;
    }

    public void deposit(double amount){
        if (amount > 0){ // otherwise makes no sense
            //update the new balance
            this.balance += amount;
        }
    }


}
