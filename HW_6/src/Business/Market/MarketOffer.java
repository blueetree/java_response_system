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
    private static int count;
    private Market market;
    private Product product;
    private double cellingPrice;
    private double floorPrice;
    private double targetPrice;
    private int availible;

    public MarketOffer(){
        market = new Market();
        product = new Product();
        count++;
        marketOfferID=String.valueOf(count);
    }

    public int getAvailible() {
        return availible;
    }

    public void setAvailible(int availible) {
        this.availible = availible;
    }



    public double getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(double targetPrice) {
        this.targetPrice = targetPrice;
    }
    
    public String getMarketOfferID() {
        return marketOfferID;
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

    public double getCellingPrice() {
        return cellingPrice;
    }

    public void setCellingPrice(double cellingPrice) {
        this.cellingPrice = cellingPrice;
    }

    public double getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(double floorPrice) {
        this.floorPrice = floorPrice;
    }  
@Override
public String toString()
{
    return String.valueOf(targetPrice);
}
  
}
