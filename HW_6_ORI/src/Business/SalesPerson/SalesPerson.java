/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SalesPerson;

/**
 *
 * @author jiahuanli
 */
public class SalesPerson {
    private String salesPersonID;
    private String salesPersonName;
    private OrderList orderList;

    public SalesPerson(){
        orderList = new OrderList();
    }
    public String getSalesPersonID() {
        return salesPersonID;
    }

    public void setSalesPersonID(String salesPersonID) {
        this.salesPersonID = salesPersonID;
    }
    
    public String getSalesPersonName() {
        return salesPersonName;
    }

    public void setSalesPersonName(String salesPersonName) {
        this.salesPersonName = salesPersonName;
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public void setOrderList(OrderList orderList) {
        this.orderList = orderList;
    }
    @Override
    public String toString(){
        return salesPersonID;
    }
}
