/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.District;

import Business.Area.Area;
import Business.Area.AreaDirectory;


/**
 *
 * @author jiahuanli
 */
public abstract class District extends Area{
    
    private Type districtType;
    private AreaDirectory areaDirectory;
    

    public enum Type{
        Mudflow("Mudflow"),
        Earthquake("Earthquake");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString() {
            return value;
        }
    }
    
    public District(String name, Type type) {
        super(name);
        districtType = type;
        areaDirectory = new AreaDirectory();
    }

    public Type getDistrictType() {
        return districtType;
    }

    public void setDistrictType(Type districtType) {
        this.districtType = districtType;
    }

    public AreaDirectory getAreaDirectory() {
        return areaDirectory;
    }

    public void setAreaDirectory(AreaDirectory areaDirectory) {
        this.areaDirectory = areaDirectory;
    }

}
