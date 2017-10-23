/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Admin;

import Business.Supplier.Supplier;

/**
 *
 * @author liuch
 */
public class UserAccount {
    private Person person;
    private Supplier supplier;
    private String userName;
    private String passWord;
    private Role role;
    private boolean accountStatus;
    private int userAccountID;
    private static int count=0;
    public UserAccount()
    {
      count++;
       userAccountID= count;
       accountStatus=true;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getUserAccountID() {
        return userAccountID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        person.setAccountList(this);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean AccountStatus) {
        this.accountStatus = AccountStatus;
    }
    @Override
    public String toString()
    {
        return  userName;
    }
    
}
