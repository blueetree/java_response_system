/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Market;

import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class Market {
    private static int count;
    private String marketID;
    private String marketName;
    private ArrayList<Customer> customerList;
    
    public Market(){
        customerList = new ArrayList<>();
        count++;
        marketID=String.valueOf(count);
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getMarketID() {
        return marketID;
    }


    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
    
    public Customer addCustomer(){
        Customer customer = new Customer();
        customerList.add(customer);
        return customer;
    }
    
    public void deleteCustomer(Customer customer){
        customerList.remove(customer);
    }
    
    public Customer searchCustomer(String customerID){
        for(Customer customer : customerList){
            if(customer.getCustomerID().equals(customerID)){
                return customer;
            }
        }
        return null;
    }

    
    @Override
    public String toString(){
        return marketName;
    }
    
}
