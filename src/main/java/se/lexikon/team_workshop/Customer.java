package se.lexikon.team_workshop;

import static se.lexikon.team_workshop.CustomerSequencer.nextCustomerId;

public class Customer {
    private String firstName;
    private String lastName;
    private final int customerId;
    private final String customerEmail;


    public Customer(String firstName, String lastName, final int customerId, final String customerEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerId = customerId;
        this.customerEmail = customerEmail;
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


}
