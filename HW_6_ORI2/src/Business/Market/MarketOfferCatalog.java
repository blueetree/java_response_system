/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Market;

import Business.Supplier.Product;
import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class MarketOfferCatalog {
    private ArrayList<MarketOffer> marketOfferCatalog;
    
    public MarketOfferCatalog(){
        marketOfferCatalog = new ArrayList<>();
    }

    public ArrayList<MarketOffer> getMarketOfferCatalog() {
        return marketOfferCatalog;
    }

    public void setMarketOfferCatalog(ArrayList<MarketOffer> marketOfferCatalog) {
        this.marketOfferCatalog = marketOfferCatalog;
    }
    
    public MarketOffer addMarketOffer(){
        MarketOffer marketOffer = new MarketOffer();
        marketOfferCatalog.add(marketOffer);
        return marketOffer;
    }
    
    public void deleteMarketOffer(MarketOffer marketOffer){
        marketOfferCatalog.remove(marketOffer);
    }
    
    public MarketOffer searchMarketOffer(String marketOfferID){
        for(MarketOffer marketOffer : marketOfferCatalog){
            if(marketOffer.getMarketOfferID().equals(marketOfferID)){
                return marketOffer;
            }
        }
        return null;
    }
    public MarketOffer getMarketOfferWithProduct(Product product,Market market)
    {
        for(MarketOffer marketOffer:marketOfferCatalog)
        {
          if((marketOffer.getProduct()==product)&&(marketOffer.getMarket()==market))
          {
              return marketOffer;
          }
        }
        return null;
    }
}
