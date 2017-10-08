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
public class MasterFlightSchedule {
    private ArrayList<FlightSchedule> masterFlightSchedule;
    
    public MasterFlightSchedule(){
        masterFlightSchedule = new ArrayList<>();
    }

    public ArrayList<FlightSchedule> getMasterFlightSchedule() {
        return masterFlightSchedule;
    }

    public void setMasterFlightSchedule(ArrayList<FlightSchedule> masterFlightSchedule) {
        this.masterFlightSchedule = masterFlightSchedule;
    }
    
    public FlightSchedule addFlightSchedule(){
        FlightSchedule flightSchedule = new FlightSchedule();
        masterFlightSchedule.add(flightSchedule);
        return flightSchedule;
    }
    
    public FlightSchedule searchFlightSchedule(String flightScheduleID){
        for(FlightSchedule flightSchedule : masterFlightSchedule){
            if(flightSchedule.getFlightScheduleID().equals(flightScheduleID)){
                return flightSchedule;
            }
        }
        return null;
    }
}
