/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Admin;

import java.util.ArrayList;

/**
 *
 * @author liuch
 */
public class Person {
    private String firstName;
    private String lastName;
    private int personID;
    private static int count =0;
    private ArrayList<UserAccount> userAccounts;
    public Person() {
    count++;
    personID= count;
    userAccounts = new ArrayList<UserAccount>();
    }

 public void setAccountList(UserAccount userAccount)
 {
     userAccounts.add(userAccount);
    // System.out.println("in person"+this.firstName+"added user accout"+userAccount+"number in total"+userAccounts.size());
 }
 public ArrayList<UserAccount> getuserAccounts()
 {
     return userAccounts;
 }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPersonID() {
        return personID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
@Override
public String toString()
{
    return firstName;
}
  
}
