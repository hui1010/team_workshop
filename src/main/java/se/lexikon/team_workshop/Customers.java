package se.lexikon.team_workshop;
import java.util.Arrays;

import static se.lexikon.team_workshop.CustomerSequencer.nextCustomerId;

public class Customers {
    private static Customer[] customer = new Customer[0];

    public Customers() {

    }

    public static Customer[] getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer[] customer) {
        Customers.customer = customer;
    }

    public boolean emailIsUnique(final String email){
        boolean emailIsUnique = true;
        for (int i = 0; i < customer.length; i++) {
            if (email.equalsIgnoreCase(customer[i].getCustomerEmail())){
                emailIsUnique = false;
                break;
            }
        }
        return emailIsUnique;
    }

    public static boolean customerExists(final int customerId){
        boolean exist = false;
        for (int i = 0; i < customer.length; i++) {
            if (customerId == customer[i].getCustomerId()){
                exist = true;
                break;
            }
        }
        return exist;
    }

    public boolean add(final String firstName, final String lastName, final String email){
        if (!emailIsUnique(email)){
            return false;
        }

        if (firstName == null || lastName == null || email == null){
            return false;
        }

        customer = addCustomer(customer, firstName, lastName, email);
        return true;
    }

    private Customer[] addCustomer(Customer[] customer, final String firstName, final String lastName, final String email){

        Customer toAdd = new Customer(firstName, lastName, nextCustomerId(), email);
        customer = Arrays.copyOf(customer, customer.length + 1);
        customer[customer.length - 1] = toAdd;

        return customer;
    }

    public static Customer findCustomer(final String email){
        Customer matchCustomer = new Customer(null, null, 0, null);
        for (int i = 0; i < customer.length; i++) {
            if (email.equalsIgnoreCase(customer[i].getCustomerEmail())){
                matchCustomer = customer[i];
                break;
            }
        }
        return matchCustomer;
    }

    public static Customer findCustomer(final int customerId){
        Customer matchCustomer = new Customer(null, null, 0, null);
        for (int i = 0; i < customer.length; i++) {
            if (customerId == customer[i].getCustomerId()){
                matchCustomer = customer[i];
                break;
            }
        }
        return matchCustomer;
    }

    public boolean remove(final String email){
        int index = getEmailIndex(customer,email);
        if (index < 0){
            return false;
        }
        customer = removeByEmailIndex(customer, index);
        return true;
    }

    private Customer[] removeByEmailIndex( final Customer[] customer, int index) {
        Customer[] first = Arrays.copyOfRange(customer, 0, index);
        Customer[] last = Arrays.copyOfRange(customer, index + 1, customer.length);
        Customer[] combined = Arrays.copyOf(first, first.length + last.length);
        for(int i = first.length, j = 0; j < last.length; i++, j++){
            combined[i] = last[j];
        }
        return combined;
    }

    private int getEmailIndex(final Customer[] customer, String email) {
        int index = -1;
        for (int i = 0; i < customer.length; i++) {
            if (email.equalsIgnoreCase(customer[i].getCustomerEmail())){
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean remove(final int customerId){
        int index = getIdIndex(customer, customerId);
        if (index < 0) {
            return false;
        }
        customer = removeByIdIndex(customer, index);
        return true;
    }

    private Customer[] removeByIdIndex(Customer[] customer, int index) {
        Customer[] first = Arrays.copyOfRange(customer, 0, index);
        Customer[] last = Arrays.copyOfRange(customer, index + 1, customer.length);
        Customer[] combined = Arrays.copyOf(first, first.length + last.length);
        for (int i = first.length, j = 0; j < last.length; i++, j++) {
            combined[i] = last[j];
        }
        return combined;
    }

    private int getIdIndex(final Customer[] customer, int customerId) {
        int index= -1;
        for (int i = 0; i < customer.length; i++) {
            if (customerId == customer[i].getCustomerId()){
                index = i;
                break;
            }
        }
        return index;
    }

    public void clear(){
        customer = new Customer[0];
    }


}
