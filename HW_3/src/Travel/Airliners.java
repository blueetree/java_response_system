/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel;

import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class Airliners {
    private ArrayList<Fleet> airline;
    
    public Airliners(){
        airline = new ArrayList<>();
    }

    public ArrayList<Fleet> getAirline() {
        return airline;
    }

    public void setAirline(ArrayList<Fleet> airline) {
        this.airline = airline;
    }
    
    public Fleet addFleet(){
        Fleet ft = new Fleet();
        airline.add(ft);
        return ft;
    }
}
