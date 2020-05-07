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

        if (!customerExists(customerId)) {
            return false;
        }

        bankAccount = addBankAccount(balance, customerId);
        return true;
    }

    private BankAccount[] addBankAccount(double balance, final int customerId) {
        BankAccount toAdd = new BankAccount(nextBankAccountId(), balance, findCustomer(customerId));
        bankAccount = Arrays.copyOf(bankAccount, bankAccount.length + 1);
        bankAccount[bankAccount.length - 1] = toAdd;
        return bankAccount;
    }

    public BankAccount findBankAccountByBankAccountId(final int bankAccountId){
        BankAccount matchAccount =new BankAccount(0,0,null);
        if (!bankAccountIdExist(bankAccountId)) {
            return null;
        }
        for (int i = 0; i < bankAccount.length; i++) {
            if (bankAccountId == bankAccount[i].getAccountId()){
                matchAccount = bankAccount[i];
            }
        }
        return matchAccount;
    }

    public BankAccount[] findBankAccountByCustomerId(final int customerId){
        BankAccount[] matchAccounts = new BankAccount[0];
        for (int i = 0; i < bankAccount.length; i++) {
            if (customerId == bankAccount[i].getCustomer().getCustomerId()){
                matchAccounts = Arrays.copyOf(matchAccounts, matchAccounts.length + 1);
                matchAccounts[matchAccounts.length - 1] = bankAccount[i];
            }
        }
        return matchAccounts;
    }

    public boolean remove(final int bankAccountId){
        int index = getBankAccountIndex(bankAccountId);
        //you can't remove an account that doesn't exist
        if (index < 0){
            return false;
        }

        bankAccount = removeBankAccount(bankAccount, index);
        return true;
    }

    private int getBankAccountIndex(int bankAccountId) {
        int index = -1; // means it can't find the id
        for (int i = 0; i < bankAccount.length; i++) {
            if (bankAccountId == bankAccount[i].getAccountId());
                    index = i;
        }
        return index;
    }

    private BankAccount[] removeBankAccount(final BankAccount[] source, final int index) {
        BankAccount[] removed = Arrays.copyOf(source, source.length - 1);
        //before the index, copy source[0] to remove[0], [1] to [1] ...
        //if index = 3, then skip 3, after 3, copy source[4] to removed[3], [5] to [4] ... till source[length-1]
        for (int i = 0, j = 0; i < bankAccount.length; i++) {
            if (i == index)
                continue;
            removed[j] = source[i];
            j++;
        }
        return removed;
    }

    private boolean bankAccountIdExist(int bankAccountId) {
        boolean bankAccountIdExist = false;
        for (int i = 0; i < bankAccount.length; i++) {
            if (bankAccountId == bankAccount[i].getAccountId()){
                bankAccountIdExist = true;
            }
        }
        return bankAccountIdExist;
    }

    public void clear(){
        bankAccount = new BankAccount[0];
    }


}
