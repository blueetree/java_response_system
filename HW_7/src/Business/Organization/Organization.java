/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Staff.StaffDirectory;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkArea.WorkAreaDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public abstract class Organization {
    private int organizationID;
    private String organizaitonName;
    private static int counter;
    private String responsibility;
    private WorkQueue workQueue;
    private StaffDirectory staffDirectory;
    private WorkAreaDirectory workAreaDirectory;
    private UserAccountDirectory userAccountDirectory;
    
    public enum Type{
        Provider("Provider Organization"), Clinic("Clinic Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        organizaitonName = name;
        workQueue = new WorkQueue();
        staffDirectory = new StaffDirectory();
        workAreaDirectory = new WorkAreaDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    public String getOrganizaitonName() {
        return organizaitonName;
    }

    public void setOrganizaitonName(String organizaitonName) {
        this.organizaitonName = organizaitonName;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public StaffDirectory getStaffDirectory() {
        return staffDirectory;
    }

    public void setStaffDirectory(StaffDirectory staffDirectory) {
        this.staffDirectory = staffDirectory;
    }

    public WorkAreaDirectory getWorkAreaDirectory() {
        return workAreaDirectory;
    }

    public void setWorkAreaDirectory(WorkAreaDirectory workAreaDirectory) {
        this.workAreaDirectory = workAreaDirectory;
    }



    @Override
    public String toString() {
        return organizaitonName;
    }
    
}
