/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class WorkQueue {
    private ArrayList<WorkRequest> workQueue;
    
    public WorkQueue() {
        workQueue = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(ArrayList<WorkRequest> workQueue) {
        this.workQueue = workQueue;
    }
    
}
