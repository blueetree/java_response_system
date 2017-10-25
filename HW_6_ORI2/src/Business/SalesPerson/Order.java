/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SalesPerson;

import Business.Market.Customer;
import Business.Market.MarketOffer;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jiahuanli
 */
public class Order {
    private ArrayList<OrderItem> orderItemList;
    private String orderListID;
    private static int count;
    private Customer customer;
    private String salesmanName;
    private Date orderDate;
     public Order(){
         count++;
         orderListID=String.valueOf(count);
         orderItemList = new ArrayList<>();
     }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Order.count = count;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
     

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }
      
    public String getOrderListID() {
        return orderListID;
    }

    public void setOrderList(ArrayList<OrderItem> orderList) {
        this.orderItemList = orderList;
    }
    
    public OrderItem addOrderItem(MarketOffer mk, int q, double actualPrice){
        OrderItem order = new OrderItem();
        order.setActualPrice(actualPrice);
        order.setMarketOffer(mk);
        order.setQuantity(q);
        orderItemList.add(order);
        return order;
    }
    
    public void RemoveOrderItem(OrderItem order){
        orderItemList.remove(order);
    }
    @Override
    public String toString()
    {
        return orderListID;
    }
 /*   public OrderItem searchOrder(String offerID){
        for(OrderItem order : orderList){
            if(order.getOrderID().equals(offerID)){
                return order;
            }
        }
        return null;
    }*/
}
