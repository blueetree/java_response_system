/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SalesPerson;

import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class SalesPersonDirectory {
    private ArrayList<SalesPerson> salesPersonDirectory;

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
    
    public void deleteOrder(SalesPerson salesPerson){
        salesPersonDirectory.remove(salesPerson);
    }
    
    public SalesPerson searchOrder(String salesPersonID){
        for(SalesPerson salesPerson : salesPersonDirectory){
            if(salesPerson.getSalesPersonID().equals(salesPersonID)){
                return salesPerson;
            }
        }
        return null;
    }
    
}
