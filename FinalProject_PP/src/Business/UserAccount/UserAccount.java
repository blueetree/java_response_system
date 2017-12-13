/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Person.Person;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author raunak
 */
public abstract class UserAccount {
    
    private String username;
    private String password;
    private Person person;
    private Role role;
    private WorkQueue workQueue;

    public enum AccountType{
        Donor("Donor"),
        Spot("Spot");
        private String value;
        
        private AccountType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public UserAccount() {
        person = new Person(); 
        workQueue = new WorkQueue();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}