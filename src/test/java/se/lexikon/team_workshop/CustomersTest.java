package se.lexikon.team_workshop;

import static org.junit.Assert.*;
import static se.lexikon.team_workshop.CustomerSequencer.resetCustomerId;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomersTest {
    Customers testCustomers = new Customers();

    @Before
    public void setUp() throws Exception {
        testCustomers.add("Tom", "Cruise", "tom.cruise@123.com");
        testCustomers.add("Tom", "Hanks", "tom.hanks@123.com");
    }

    @Test
    public void two_customers_successfully_added_and_try_to_find_them_by_ID_or_email() {
        //if they are successfully added then the arrays length should be 2 now
        assertEquals(2, testCustomers.getCustomer().length);
        //the first added one should get the Id 1
        assertEquals(1, testCustomers.findCustomer(1).getCustomerId());
        //the customer whose ID is 2 should be the Tom Hanks and his email should be the same as written above
        assertEquals("tom.hanks@123.com", testCustomers.findCustomer(2).getCustomerEmail());
        //when search for an email address, should be able to find the right person
        assertEquals(1, testCustomers.findCustomer("tom.cruise@123.com").getCustomerId());
    }

    @Test
    public void return_false_when_add_same_email() {
        assertFalse(testCustomers.emailIsUnique("tom.cruise@123.com"));
        assertFalse(testCustomers.add("Niklas", "Svensson", "tom.hanks@123.com"));
        //if it is not added, the length should still be 2
        assertEquals(2,testCustomers.getCustomer().length);
    }

    @Test
    public void remove_one_customer_length_should_become_1() {

        testCustomers.remove(1);
        assertEquals(1, testCustomers.getCustomer().length);
        //the first one should be removed, so the last name should be null
        assertNull(testCustomers.findCustomer(1).getLastName());
    }

    //todo test remove by email~

    @After
    public void tearDown() throws Exception {
        resetCustomerId();
    }
}
