/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier;

import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class SupplierDirectory {
    private ArrayList<Supplier> supplierDirectory;

    public SupplierDirectory() {
        supplierDirectory = new ArrayList<>();
    }

    public ArrayList<Supplier> getSupplierDirectory() {
        return supplierDirectory;
    }

    public void setSupplierDirectory(ArrayList<Supplier> supplierDirectory) {
        this.supplierDirectory = supplierDirectory;
    }
    
    public Supplier addSupplier(){
        Supplier supplier = new Supplier();
        supplierDirectory.add(supplier);
        return supplier;
    }
    
    public void deleteSupplier(Supplier supplier){
        supplierDirectory.remove(supplier);
    }
    
    public Supplier searchSupplier(String supplierID){
        for(Supplier supplier : supplierDirectory){
            if(supplier.getSupplierID().equals(supplierID)){
                return supplier;
            }
        }
        return null;
    }
    

}
