/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airport;

import java.util.ArrayList;
import Interface.ViewAirplaneJPanel;
import java.util.Date;
/**
 *
 * @author jiahuanli
 */
public class Airline {
    private ArrayList<Airplane> airline;
    private Date update;

    public Date getUpdate() {
        return update;
    }

    public void setUpdate() {
        update = new Date();
    }
  
    public Airline(){
        airline = new ArrayList<>();
    }
    
    public ArrayList<Airplane> getAirline() {
        return airline;
    }

    public void setAirline(ArrayList<Airplane> airline) {
        this.airline = airline;
    }
    
    public Airplane addAirplane(){
        Airplane ap = new Airplane();
        airline.add(ap);
        return ap;
    }

    
    public void deleteAirplane(Airplane ap){
        airline.remove(ap);
    }

    public Airplane updateAirplane(Airplane ap) {
        airline.remove(ap);
        airline.add(ap);
        return ap;
    }
    
    public Airplane minDepartureTime(){
        Airplane min = new Airplane();
        min = airline.get(0);
        for(int i=1;i<airline.size();i++){
            if(min.getDepartureHour() >= airline.get(i).getDepartureHour() & min.getDepartureMin() > airline.get(i).getDepartureMin()){
                min = airline.get(i);
            }     
        }
        return min;
    }
    
    public int availableNum(int nowHour,int nowMin){
        int count = 0;
        for(int i=1;i<airline.size();i++){
            if(nowHour <= (int)airline.get(i).getDepartureHour() & nowMin < airline.get(i).getDepartureMin()){
                    count = count+1;
            }     
        }
        return count;
    }
     
    
    
    
}
