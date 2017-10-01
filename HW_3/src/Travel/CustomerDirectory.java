/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel;
import java.util.ArrayList;
/**
 *
 * @author jiahuanli
 */
public class CustomerDirectory {
    private ArrayList<Customer> customers;
    
    public CustomerDirectory(){
        customers = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
    
    public Customer addCustomer(){
        Customer cd = new Customer();
        customers.add(cd);
        return cd;
    }
}
