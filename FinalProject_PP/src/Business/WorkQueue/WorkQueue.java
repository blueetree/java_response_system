/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
///////
    public WorkRequest addWorkRequest(){
    WorkRequest wRequest=new WorkRequest();
    workRequestList.add(wRequest);
    return wRequest;
    }
    /////////////
     public void deleteWorkRequest(WorkRequest wr) {
        workRequestList.remove(wr);
        
    }
    
}