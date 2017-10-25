/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Admin;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author liuch
 */
public class PersonDirectory {
     private List<Person> personDirecory;

    public PersonDirectory() {
     personDirecory = new ArrayList<Person>();
    }
    
    public List<Person> getPersonDirectory(){
        return personDirecory;
    }
    
    
    public Person addPerson(){
        Person p = new Person();
        personDirecory.add(p);
        return p;
    }
    
    public void removePerson(Person p){
        personDirecory.remove(p);
    }
    
    public Person searchProduct(int id){
        for (Person p : personDirecory) {
            if(p.getPersonID()==id){
                return p;
            }
        }
        return null;
    }
}
