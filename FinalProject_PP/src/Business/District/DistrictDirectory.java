/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.District;

import Business.Area.Area;
import Business.District.District.Type;
import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class DistrictDirectory {
    
    private ArrayList<District> districtList;

    public DistrictDirectory() {
        districtList = new ArrayList<>();
    }

    public ArrayList<District> getDistrictList() {
        return districtList;
    }
    
    public District createDistrict(String name,District.Type type){
        District district = null;
        if (type.getValue().equals(Type.Earthquake.getValue())){
            district = new EarthquakeDistrict(name);  
        }else if(type.getValue().equals(Type.Mudflow.getValue())){
            district = new MudflowDistrict(name);  
        }
        districtList.add(district);
        return district;
    }
}