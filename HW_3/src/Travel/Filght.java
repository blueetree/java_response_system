/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel;

import java.util.Date;

/**
 *
 * @author jiahuanli
 */
public class Filght {
    private String departureDate;
    private String arrivalDate;
    private String departureLocation;
    private String arriveLocation;
    private String filghtID;

    public String getFilghtID() {
        return filghtID;
    }

    public void setFilghtID(String filghtID) {
        this.filghtID = filghtID;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArriveLocation() {
        return arriveLocation;
    }

    public void setArriveLocation(String arriveLocation) {
        this.arriveLocation = arriveLocation;
    }

    
}
