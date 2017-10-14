/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class PersonDirectory {
    private ArrayList<Person> personDirectory;
    
    public PersonDirectory(){
        personDirectory = new ArrayList<>();
    }

    public ArrayList<Person> getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(ArrayList<Person> personDirectory) {
        this.personDirectory = personDirectory;
    }
    
    public Person addPerson(){
        Person person = new Person();
        personDirectory.add(person);
        return person;
    }
    
    public Person searchPerson(String personID){
        for(Person person:personDirectory){
            if(person.getPersonID().equals(personID)){
                return person;
            }
        }
        return null;
    }
    public ArrayList<Person> searchFirstName(String firstName){
        ArrayList<Person> personResult = new ArrayList<>();
        for(Person person:personDirectory){
            if(person.getFirstName().equals(firstName)){
                personResult.add(person);
            }
        }
            return personResult;
    }
    public ArrayList<Person> searchLastName(String lastName){
        ArrayList<Person> personResult = new ArrayList<>();
        for(Person person:personDirectory){
            if(person.getLastName().equals(lastName)){
                personResult.add(person);
            }
        }
            return personResult;
    }
    
}
