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
public class ProductCatalog {
    private ArrayList<Product> productCatalog;
    
    public ProductCatalog(){
        productCatalog = new ArrayList<>();
    }

    public ArrayList<Product> getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ArrayList<Product> productCatalog) {
        this.productCatalog = productCatalog;
    }
    
    public Product addProduct(){
        Product product = new Product();
        productCatalog.add(product);
        return product;
    }
    
    public void deleteProduct(Product product){
        productCatalog.remove(product);
    }
    
    public Product searchProduct(String productID){
        for(Product product : productCatalog){
            if(product.getProductID().equals(productID)){
                return product;
            }
        }
        return null;
    }
      
    public Product searchProductWithName(String productName){
        for(Product product : productCatalog){
            if(product.getProductName().equals(productName)){
                return product;
            }
        }
        return null;
    }
    
    
}
