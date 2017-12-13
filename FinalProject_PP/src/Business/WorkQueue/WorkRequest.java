/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Area.Area;
import Business.MaterialList.Item;
import Business.MaterialList.ItemDirectory;
import Business.MaterialList.RequestItem;
import Business.Person.Person;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jiahuanli
 */
public class WorkRequest {

    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    /////////
    private int id;
    private static int count = 1;
    private Item item;
    /////////
    private Double money;
    /////////
    private int frontLineQuantity;
    private int purchaseQuantity;
    private int commandQuantity;
    private String destination;
    
    
    private Area area;////////////////////////////


    public WorkRequest() {
        requestDate = new Date();
        item = new RequestItem();


        ////////////
        id = count;
        count++;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
    

    public int getFrontLineQuantity() {
        return frontLineQuantity;
    }

    public void setFrontLineQuantity(int frontLineQuantity) {
        this.frontLineQuantity = frontLineQuantity;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public int getCommandQuantity() {
        return commandQuantity;
    }

    public void setCommandQuantity(int commandQuantity) {
        this.commandQuantity = commandQuantity;
    }
   
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString(){
        return item.getName();
    }

}