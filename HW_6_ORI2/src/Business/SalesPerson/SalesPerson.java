/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SalesPerson;

import Business.Admin.Person;
import Business.Admin.Role;
import Business.Admin.UserAccount;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jiahuanli
 */
public class SalesPerson {
    private String salesPersonID;
    UserAccount ua;
    private static int count =0;
    private String salesPersonName;
    private ArrayList<Order> orderCatalog;

    public SalesPerson(){
       orderCatalog = new ArrayList<Order>();
        count++;
        salesPersonID= String.valueOf(count);
        
    }
     

    public UserAccount getUa() {
        return ua;
    }

    public void setUa(UserAccount ua) {
        
        if(ua.getRole()==Role.Sales_Person)
        { this.ua = ua;
        salesPersonName=ua.getPerson().getFirstName();
        }
        else  JOptionPane.showMessageDialog(null, "SalesPerson Can not be set, this person is not a salesman!!", "Warning", JOptionPane.WARNING_MESSAGE);
    }
    
    public String getSalesPersonID() {
        return salesPersonID;
    }

    
    public String getSalesPersonName() {
        return salesPersonName;
    }

    public void setSalesPersonName(String salesPersonName) {
        this.salesPersonName = salesPersonName;
    }

    public ArrayList<Order> getOrderCatalog() {
        return orderCatalog;
    }
    
    
    public Order addOrder(Order o)
    {
       
        orderCatalog.add(o);
        return o;
    }

  /*  public OrderMapList getA() {
        return orderMapList;
    }

    public void setOrderMapList(OrderMapList orderMapList) {
        this.orderMapList = orderMapList;
    }*/
    
}
