/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Country;

import Business.Area.Area;
import Business.District.DistrictDirectory;

/**
 *
 * @author jiahuanli
 */
public class Country extends Area{
    
    //private Type countryType;
    private DistrictDirectory districtDirectory;

        
    public Country(String name) {
        super(name);
        districtDirectory = new DistrictDirectory();
    }
    

    public DistrictDirectory getDistrictDirectory() {
        return districtDirectory;
    }

    public void setDistrictDirectory(DistrictDirectory districtDirectory) {
        this.districtDirectory = districtDirectory;
    }
    
   
}
