/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Market;

import Business.Supplier.Product;

/**
 *
 * @author jiahuanli
 */
public class MarketOffer {
    private String marketOfferID;
    private Market market;
    private Product product;
    private String cellingPrice;
    private String floorPrice;
    private String targetPrice;

    public MarketOffer(){
        market = new Market();
        product = new Product();
    }

    public String getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(String targetPrice) {
        this.targetPrice = targetPrice;
    }
    
    public String getMarketOfferID() {
        return marketOfferID;
    }

    public void setMarketOfferID(String marketOfferID) {
        this.marketOfferID = marketOfferID;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCellingPrice() {
        return cellingPrice;
    }

    public void setCellingPrice(String cellingPrice) {
        this.cellingPrice = cellingPrice;
    }

    public String getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(String floorPrice) {
        this.floorPrice = floorPrice;
    }  
}
