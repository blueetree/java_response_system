/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author jiahuanli
 */
public class Airliner {
    private String airlineID;
    private String airlineUser;
    private String airlineName;
    private String airlineAddress;
    private int totalFlightPerDay;
    private FlightSchedule flightSchedule;
    
    public Airliner(){
        this.flightSchedule = new FlightSchedule();
    }

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public String getAirlineUser() {
        return airlineUser;
    }

    public void setAirlineUser(String airlineUser) {
        this.airlineUser = airlineUser;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineAddress() {
        return airlineAddress;
    }

    public void setAirlineAddress(String airlineAddress) {
        this.airlineAddress = airlineAddress;
    }

    public int getTotalFlightPerDay() {
        return totalFlightPerDay;
    }

    public void setTotalFlightPerDay(int totalFlightPerDay) {
        this.totalFlightPerDay = totalFlightPerDay;
    }

    public String getFlightSchedule() {
        
        return flightSchedule.getFlightScheduleID();
    }
    
    public void addFlightSchedule(String flightScheduleID){
        
        flightSchedule.setFlightScheduleID(flightScheduleID);
    }
    
    @Override
    public String toString(){
        return airlineID;
    }
}
