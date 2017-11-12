/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkArea;

import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class WorkAreaDirectory {
    private ArrayList<WorkArea> workAreaDirectory;
    public WorkAreaDirectory(){
        workAreaDirectory = new ArrayList<>();
    }

    public ArrayList<WorkArea> getWorkAreaDirectory() {
        return workAreaDirectory;
    }

    public void setWorkAreaDirectory(ArrayList<WorkArea> workAreaDirectory) {
        this.workAreaDirectory = workAreaDirectory;
    }
    public WorkArea addWorkArea(String name){
        WorkArea workArea = new WorkArea(name);
        workAreaDirectory.add(workArea);
        return workArea;
    }
}
