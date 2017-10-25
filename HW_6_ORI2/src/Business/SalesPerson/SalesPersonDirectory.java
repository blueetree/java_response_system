/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SalesPerson;

import Business.Admin.UserAccount;
import Business.Market.Customer;
import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class SalesPersonDirectory {
    private ArrayList<SalesPerson> salesPersonDirectory;
    private ArrayList<Order> totalOrder;

    public SalesPersonDirectory(){
        salesPersonDirectory = new ArrayList<>();
        
    }
    
    public ArrayList<SalesPerson> getSalesPersonDirectory() {
        return salesPersonDirectory;
    }

    public void setSalesPersonDirectory(ArrayList<SalesPerson> salesPersonDirectory) {
        this.salesPersonDirectory = salesPersonDirectory;
    }
    
    public SalesPerson addSalesPerson(){
        SalesPerson salesPerson = new SalesPerson();
        salesPersonDirectory.add(salesPerson);
        return salesPerson;
    }
    
    public void deleteSalesman(SalesPerson salesPerson){
        salesPersonDirectory.remove(salesPerson);
    }
    
    public SalesPerson searchSalesman(UserAccount ua){
        for(SalesPerson salesPerson : salesPersonDirectory){
            if(salesPerson.getUa()==ua){
                return salesPerson;
            }
        }
        return null;
    }
    public ArrayList<Order> getOrderFromAllSm()
    {
        for(SalesPerson sp:salesPersonDirectory)
        {
            totalOrder= new ArrayList<>();
            ArrayList<Order> allOrderPerPerson = sp.getOrderCatalog();
            totalOrder.addAll(allOrderPerPerson) ;
        }
        return totalOrder;
    }
    public ArrayList<Order> orderFromACustomer(Customer cm)
    {
       ArrayList<Order> OfromC= new ArrayList<Order>();
       ArrayList<Order> all=getOrderFromAllSm();
       for(Order order:all)
       {
           if(order.getCustomer()==cm)
           {
               OfromC.add(order);
         System.out.println("I am in salesmanDirectory"+order.getOrderListID());
   
    
           }
       }
       return OfromC;
    }
}
