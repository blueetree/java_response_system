/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SalesPerson;

import Business.Market.Customer;
import Business.Market.MarketOffer;
import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class OrderItem {
    private String orderID;
    private static int count;
    private MarketOffer marketOffer;
    private double actualPrice;
    private int quantity;
    

    public OrderItem() {
        count++;
         orderID=String.valueOf(count);
    }
   
  
    public String getOrderID() {
        return orderID;
    }

 

    public void setMarketOffer(MarketOffer marketOffer) {
        this.marketOffer = marketOffer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

  
    public MarketOffer getMarketOffer() {
        return marketOffer;
    }

  
    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
       this.actualPrice=actualPrice;   
    }
    @Override
    public String toString()
    {
        return marketOffer.getProduct().getProductID();
    }
    
}
