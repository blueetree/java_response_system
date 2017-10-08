/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class FlightSchedule {
    private String flightScheduleID;
    private ArrayList<Flight> flightSchedule;

    FlightSchedule(){
        flightSchedule = new ArrayList<>();
    }
    public String getFlightScheduleID() {
        return flightScheduleID;
    }

    public void setFlightScheduleID(String flightScheduleID) {
        this.flightScheduleID = flightScheduleID;
    }

    public ArrayList<Flight> getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(ArrayList<Flight> flightSchedule) {
        this.flightSchedule = flightSchedule;
    }
    
    public Flight addFlight(){
        Flight flight = new Flight();
        flightSchedule.add(flight);
        return flight;
    }
    
    public void deletedFlight(Flight flight){
        flightSchedule.remove(flight);
    }
    
    public Flight searchFlight(String flightID){
        for(Flight flight : flightSchedule){
            if(flight.getFlightID().equals(flightID)){
                return flight;
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        return flightScheduleID;
    }
    
}
