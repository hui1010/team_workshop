package se.lexikon.team_workshop;

import java.util.Arrays;

import static se.lexikon.team_workshop.BankAccountSequencer.nextBankAccountId;
import static se.lexikon.team_workshop.Customers.customerExists;
import static se.lexikon.team_workshop.Customers.findCustomer;

public class BankAccounts {
    private static BankAccount[] bankAccount = new BankAccount[0];

    public BankAccounts() {
    }

    public static BankAccount[] getBankAccount() {
        return bankAccount;
    }

    public static void setBankAccount(BankAccount[] bankAccount) {
        BankAccounts.bankAccount = bankAccount;
    }

    public boolean add(double balance, int customerId){
        if (balance < 0) {
            return false; // can't create an account with minus money
        }
        if (!customerExists(customerId)){ //check if the customer exist, otherwise can't create a bankaccount
            return false;
        }
        bankAccount = addBankAccount(balance, customerId);
        return true;
    }

    private BankAccount[] addBankAccount(double balance, int customerId) {
        BankAccount toAdd = new BankAccount(nextBankAccountId(), 0, findCustomer(customerId));
        bankAccount = Arrays.copyOf(bankAccount, bankAccount.length + 1);
        bankAccount[bankAccount.length - 1] = toAdd;
        return bankAccount;
    }
}
