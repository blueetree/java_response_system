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
public class MasterSchedule {
    private ArrayList<FilghtSchedule> masterSchedule;
    
    public MasterSchedule(){
        masterSchedule = new ArrayList<>();
    }

    public ArrayList<FilghtSchedule> getMasterSchedule() {
        return masterSchedule;
    }

    public void setMasterSchedule(ArrayList<FilghtSchedule> masterSchedule) {
        this.masterSchedule = masterSchedule;
    }
    
    public FilghtSchedule addFilghtSchedule(){
        FilghtSchedule fs = new FilghtSchedule();
        masterSchedule.add(fs);
        return fs;
    }
}
