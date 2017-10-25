/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Market;

import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class MarketList {
    private ArrayList<Market> marketList;

    public MarketList() {
        marketList = new ArrayList<>();
    }

    public ArrayList<Market> getMarketList() {
        return marketList;
    }

    public void setMarketList(ArrayList<Market> marketList) {
        this.marketList = marketList;
    }
    
    
    public Market addMarket(){
        Market market = new Market();
        marketList.add(market);
        return market;
    }
    
    public void deleteMarket(Market market){
        marketList.remove(market);
    }
    
    public Market searchMarket(String marketID){
        for(Market market : marketList){
            if(market.getMarketID().equals(marketID)){
                return market;
            }
        }
        return null;
    }
    public Market MarketCustomerBelong(Customer customer)
    {
        
        for(Market market:marketList)
        {
            System.out.println("MarketName"+market.getMarketName());
            for(Customer c:market.getCustomerList())
            {
                System.out.println("                Customer tName"+c.getCustomerName());
                if(c==customer)
                {
                    System.out.println("Market nAME"+market.getMarketName());
                    return market;
                }
            }
           
        }
         return null;
        
    }
    public Customer searchCustomer(String customerName)
    {
        for(Market market:marketList)
        {
            for(Customer c:market.getCustomerList())
            {
                if(c.getCustomerName().equals(customerName))
                {
                    return c;
                }
            }
           
        }
         return null;
    }
        public boolean hasCustomerWithSameName(String name)
    {
        boolean has = false;
        for(Market m: marketList)
        {
        for(Customer customer:m.getCustomerList())
        {
            if(name.equals(customer.getCustomerName()))
            {
                has = true ;
                break;
            }
        }
        }
        return has;
    }
    
}
