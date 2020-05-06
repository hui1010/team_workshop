package se.lexikon.team_workshop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static se.lexikon.team_workshop.BankAccountSequencer.nextBankAccountId;

public class BankAccountTest {
    private BankAccount testAccount = new BankAccount(nextBankAccountId(), 1000, null);

    @Test
    public void withdraw_400_balance_become_600() {
        testAccount.withdraw(400);
        assertEquals(600, testAccount.getBalance(),0);
    }

    @Test
    public void deposit_500_balance_become_1500(){
        testAccount.deposit(500);
        assertEquals(1500, testAccount.getBalance(),0);
    }

    @Test
    public void withdraw_1100_should_not_execute_and_balance_remains_1000() {
        assertEquals(-1, testAccount.withdraw(1100), 0);
        assertEquals(1000, testAccount.getBalance(),0);
    }


}
