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
public class Fleet {
    private ArrayList<Airplane> fleet;
    
    public Fleet(){
        fleet = new ArrayList<>();
    }

    public ArrayList<Airplane> getFleet() {
        return fleet;
    }

    public void setFleet(ArrayList<Airplane> fleet) {
        this.fleet = fleet;
    }
    
    public Airplane addAirplane(){
        Airplane ap = new Airplane();
        fleet.add(ap);
        return ap;
    }
}
