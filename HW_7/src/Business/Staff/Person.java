/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Staff;

/**
 *
 * @author jiahuanli
 */
public class Person {
    private int ID;
    private String personName;
    private static int count = 1;

    public Person() {
        ID = count;
        count++;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    @Override
    public String toString() {
        return personName;
    }
}
