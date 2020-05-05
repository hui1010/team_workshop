package se.lexikon.team_workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static se.lexikon.team_workshop.CustomerSequencer.resetCustomerId;

public class CustomerTest {
    public static final String FIRST_NAME = "Tom";
    public static final String LAST_NAME = "Cruise";
    public static final String EMAIL = "tom.cruise@123.com";
    private Customer testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new Customer(FIRST_NAME, LAST_NAME);
    }

    @Test
    public void test_if_customer_successfully_created() {
        assertEquals("Tom", testObject.getFirstName());
        assertEquals("Cruise", testObject.getLastName());
        assertEquals(1,testObject.getCustomerId());
    }

    @Test
    public void given_email_should_update() {
        testObject.setCustomerEmail(EMAIL);
        assertEquals(EMAIL, testObject.getCustomerEmail());

    }

    @Test
    public void change_lastName_should_update() {
        testObject.setLastName("Hanks");
        assertEquals("Hanks", testObject.getLastName());
    }

    @Test
    public void change_firstName_should_update() {
        testObject.setFirstName("Nikki");
        assertEquals("Nikki", testObject.getFirstName());
    }

    @After
    public void tearDown() throws Exception {
        resetCustomerId();
    }
}
