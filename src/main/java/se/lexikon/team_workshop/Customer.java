package se.lexikon.team_workshop;

import static se.lexikon.team_workshop.CustomerSequencer.nextCustomerId;

public class Customer {
    private String firstName;
    private String lastName;
    private final int customerId;
    private String customerEmail;


    public Customer() {
        this.customerId = getCustomerId();
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerId = nextCustomerId();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

}
