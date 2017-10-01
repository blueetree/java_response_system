/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jiahuanli
 */
public class TravelAgency {
    CustomerDirectory customerDirectory;
    MasterSchedule masterSchedule;
    Airliners airliners;
    
    public TravelAgency(){
        customerDirectory = new CustomerDirectory();
        masterSchedule = new MasterSchedule();
        airliners = new Airliners();
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public MasterSchedule getMasterSchedule() {
        return masterSchedule;
    }

    public void setMasterSchedule(MasterSchedule masterSchedule) {
        this.masterSchedule = masterSchedule;
    }

    public Airliners getAirliners() {
        return airliners;
    }

    public void setAirliners(Airliners airliners) {
        this.airliners = airliners;
    }
    
    
    
    
}
