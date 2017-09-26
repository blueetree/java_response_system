/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airport;

/**
 *
 * @author jiahuanli
 */
public class Airplane {
    private int departureHour;
    private int departureMin;
    private String company;
    private int productYear;
    private int seatsNum;
    private String serialNum;//key
    private String modelNum;
    private int certYear;
    private int certMon;
    //private boolean avaState;

    public int getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(int departureHour) {
        this.departureHour = departureHour;
    }

    public int getDepartureMin() {
        return departureMin;
    }

    public void setDepartureMin(int departureMin) {
        this.departureMin = departureMin;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getProductYear() {
        return productYear;
    }

    public void setProductYear(int productYear) {
        this.productYear = productYear;
    }

    public int getSeatsNum() {
        return seatsNum;
    }

    public void setSeatsNum(int seatsNum) {
        this.seatsNum = seatsNum;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public int getCertYear() {
        return certYear;
    }

    public void setCertYear(int certYear) {
        this.certYear = certYear;
    }

    public int getCertMon() {
        return certMon;
    }

    public void setCertMon(int certMon) {
        this.certMon = certMon;
    }

    @Override
    public String toString(){
        return this.serialNum;
    }
}
