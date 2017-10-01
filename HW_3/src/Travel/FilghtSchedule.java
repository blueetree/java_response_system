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
public class FilghtSchedule {
    ArrayList<Filght> filghts;
    private String filghtScheduleId;

    public String getFilghtScheduleId() {
        return filghtScheduleId;
    }

    public void setFilghtScheduleId(String filghtScheduleId) {
        this.filghtScheduleId = filghtScheduleId;
    }
    
    public FilghtSchedule(){
        filghts = new ArrayList<>();
    }

    public ArrayList<Filght> getFilghts() {
        return filghts;
    }

    public void setFilghts(ArrayList<Filght> filghts) {
        this.filghts = filghts;
    }
    
    public Filght addFilght(){
        Filght ft = new Filght();
        filghts.add(ft);
        return ft;
    }
}
