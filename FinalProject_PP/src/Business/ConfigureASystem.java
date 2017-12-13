package Business;

import Business.Person.Person;
import Business.Role.AdminSystemRole;
import Business.Role.DonorRole;
import Business.Role.VictimRole;
import Business.UserAccount.UserAccount;


/**
 *
 * @author jiahuanli
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        //Staff employee = system.getEmployeeDirectory().createEmployee("RRH");
        
        //UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new FrontLineRole());
        
        
        Person person1  = system.getPersonDirectory().createPerson("bill");
        UserAccount ua1 = system.getUserAccountDirectory().createUserAccount("System", "1", person1,new AdminSystemRole(), UserAccount.AccountType.Spot);
        Person person2 = system.getPersonDirectory().createPerson("donor");
        UserAccount ua2 = system.getUserAccountDirectory().createUserAccount("Donor", "1", person2,new DonorRole(), UserAccount.AccountType.Donor);
        //country: username:country password:1
        //district: username:district password:1
        //victim: username:victim1 password:1 ->area1
        //frontline: username: frontline1 password:1 ->area1
        return system;
    }
    
}
