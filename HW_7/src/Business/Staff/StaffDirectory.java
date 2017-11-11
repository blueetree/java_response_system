/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Staff;

import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class StaffDirectory {
    private ArrayList<Person> staffDirectory;
    
    public StaffDirectory() {
        staffDirectory = new ArrayList<>();
    }

    public ArrayList<Person> getStaffDirectory() {
        return staffDirectory;
    }

    public void setStaffDirectory(ArrayList<Person> staffDirectory) {
        this.staffDirectory = staffDirectory;
    }
    
    public Person addStaff(String personName){
        Person person = new Person();
        person.setPersonName(personName);
        staffDirectory.add(person);
        return person;
    }
}
