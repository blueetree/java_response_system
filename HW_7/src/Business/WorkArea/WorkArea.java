/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkArea;

/**
 *
 * @author jiahuanli
 */
public class WorkArea {
    private int workAreaID;
    private String workAreaName;
    private String workAreaLocation;
    private static int counter;
    
    public WorkArea(String name) {
        workAreaName = name;
        workAreaID = counter;
        ++counter;
    }

    public int getWorkAreaID() {
        return workAreaID;
    }

    public void setWorkAreaID(int workAreaID) {
        this.workAreaID = workAreaID;
    }

    public String getWorkAreaName() {
        return workAreaName;
    }

    public void setWorkAreaName(String workAreaName) {
        this.workAreaName = workAreaName;
    }

    public String getWorkAreaLocation() {
        return workAreaLocation;
    }

    public void setWorkAreaLocation(String workAreaLocation) {
        this.workAreaLocation = workAreaLocation;
    }
    
    @Override
    public String toString() {
        return workAreaName;
    }
}
