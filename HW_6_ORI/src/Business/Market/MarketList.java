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
    
}
