package se.lexikon.team_workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static se.lexikon.team_workshop.BankAccountSequencer.resetBankAccountId;
import static se.lexikon.team_workshop.CustomerSequencer.resetCustomerId;

public class BankAccountsTest {
    BankAccounts testAccounts = new BankAccounts();
    Customers testCustomer = new Customers();


    @Before
    public void setUp() throws Exception {
        testCustomer.add("Anna","Bengtsson", "anna@123.com");
        testCustomer.add("Bengt", "Carlsson", "bengt@123.com");
        testCustomer.add("Carl", "Nilsson", "carl@123.com");
        testAccounts.add(1000, 1);
        testAccounts.add(2000, 2);
        testAccounts.add(3000, 3);
    }

    @Test
    public void length_should_be_3_if_they_are_successfully_added() {
        assertEquals(3, testAccounts.getBankAccount().length);
    }

    @Test
    public void return_the_correct_balance_amount_when_search_with_bankAccountId() {
        assertEquals(1000, testAccounts.findBankAccountByBankAccountId(1).getBalance(), 0);
        assertEquals(3000, testAccounts.findBankAccountByBankAccountId(3).getBalance(), 0);
    }

    @Test
    public void if_can_add_several_bank_accounts_for_one_customer_and_find_them_by_customerId() {
        testAccounts.add(4000, 3);
        testAccounts.add(5000, 3);
        //so there should be five bank account
        assertEquals(5, testAccounts.getBankAccount().length);
        //customer 3 should have 3 accounts now
        assertEquals(3, testAccounts.findBankAccountByCustomerId(3).length);
        //the second account of customer 3 should have balance 4000
        assertEquals(4000, testAccounts.findBankAccountByCustomerId(3)[1].getBalance(), 0);
    }

    @Test
    //try to add an account to a customer that doesn't exist
    public void try_to_add_an_account_for_customerId_4_should_return_false() {
        assertFalse(testAccounts.add(6000, 4));
    }

    @Test
    public void remove_bankAccount_3_length_should_become_2 () {
        testAccounts.remove(3);
        assertEquals(2,testAccounts.getBankAccount().length);
        //customer 3 should therefore have 0 bank account
        assertEquals(0, testAccounts.findBankAccountByCustomerId(3).length);
    }

    @After
    public void tearDown() throws Exception {
        testAccounts.clear();
        resetCustomerId();
        resetBankAccountId();
    }
}
