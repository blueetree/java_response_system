/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Area;


import Business.MaterialList.ItemDirectory;
import Business.Person.PersonDirectory;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author jiahuanli
 */
public abstract class Area {
    
    private String name;
    private double location_x;
    private double location_y;
    private WorkQueue workQueue;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;
    /////////
//    private RequestList requestList;
    private ItemDirectory itemDirectory;
    //////////
    private Double money;
    private int id;
    private static int count = 1;
    
    public enum Type{
        A("A"),
        B("B");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    public Area(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        personDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
//        requestList = new RequestList();
        itemDirectory = new ItemDirectory();
        id = count;
        count++;
    }

    public double getLocation_x() {
        return location_x;
    }

    public void setLocation_x(double location_x) {
        this.location_x = location_x;
    }

    public double getLocation_y() {
        return location_y;
    }

    public void setLocation_y(double location_y) {
        this.location_y = location_y;
    }

   

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

   


    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public ItemDirectory getItemDirectory() {
        return itemDirectory;
    }

    public void setItemDirectory(ItemDirectory itemDirectory) {
        this.itemDirectory = itemDirectory;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

   



    @Override
    public String toString() {
        return name;
    }
    
    
} 