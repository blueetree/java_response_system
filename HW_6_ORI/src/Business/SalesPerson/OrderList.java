/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SalesPerson;

import Business.Market.MarketOffer;
import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class OrderList {
    private ArrayList<Order> orderList;
     public OrderList(){
         orderList = new ArrayList<>();
     }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
    
    public Order addOrder(){
        Order order = new Order();
        orderList.add(order);
        return order;
    }
    
    public void deleteOrder(Order order){
        orderList.remove(order);
    }
    
    public Order searchOrder(String offerID){
        for(Order order : orderList){
            if(order.getOrderID().equals(offerID)){
                return order;
            }
        }
        return null;
    }
}
