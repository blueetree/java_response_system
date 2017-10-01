/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel;

/**
 *
 * @author jiahuanli
 */
public class Customer {
    private String customerID;
    private String name;
    private String seatID;
    private String filghtID;

    public String getFilghtID() {
        return filghtID;
    }

    public void setFilghtID(String filghtID) {
        this.filghtID = filghtID;
    }

    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatId) {
        this.seatID = seatID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
