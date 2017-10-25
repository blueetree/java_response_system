/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Market;

/**
 *
 * @author jiahuanli
 */
public class Customer {
    private String customerID;
    private String customerName;
    private static int count;
    private String address;
    public Customer() {
      count++;
      customerID=String.valueOf(count);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerID() {
        return customerID;
    }

}
