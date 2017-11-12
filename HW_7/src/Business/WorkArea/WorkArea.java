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
    
    @Override
    public String toString() {
        return workAreaName;
    }
}
