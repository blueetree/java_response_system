/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.*;
import static java.util.Objects.hash;

/**
 *
 * @author jiahuanli
 */
public class ConfigureABuessiness {
    private PersonDirectory personDirectory;
    private UserAccountDirectory HRuserAccountDirectory;
    private UserAccountDirectory SystemuserAccountDirectory;
    public ConfigureABuessiness(){
        personDirectory = new PersonDirectory();
        HRuserAccountDirectory = new UserAccountDirectory();
        SystemuserAccountDirectory = new UserAccountDirectory();
      
    }
    public PersonDirectory init(){
         //System Admin
       Person Systemperson = personDirectory.addPerson();
       Systemperson.setPersonID("1");
       Systemperson.setFirstName("Jack");
       Systemperson.setLastName("Ma");
       
       UserAccount userAccount = SystemuserAccountDirectory.addUserAccount();
       userAccount.setUserName("1");
       userAccount.setPassword(String.valueOf(hash("1")));
       userAccount.setStatus(true);
       userAccount.setUserRole("System Admin");
       
       Systemperson.setUserAccountDirectory(SystemuserAccountDirectory);
       
       //HR Admin
       Person HRperson = personDirectory.addPerson();
       HRperson.setPersonID("2");
       HRperson.setFirstName("Amy");
       HRperson.setLastName("Ros");
       
       UserAccount HRuserAccount = HRuserAccountDirectory.addUserAccount();
       HRuserAccount.setUserName("2");
       HRuserAccount.setPassword(String.valueOf(hash("2")));
       HRuserAccount.setStatus(true);
       HRuserAccount.setUserRole("HR Admin");
       
       HRperson.setUserAccountDirectory(HRuserAccountDirectory);
       System.out.println(personDirectory.getPersonDirectory());
       return personDirectory;
    }
}
