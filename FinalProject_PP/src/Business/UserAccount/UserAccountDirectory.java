/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Person.Person;
import Business.Role.Role;
import Business.UserAccount.UserAccount.AccountType;
import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
           if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
               System.out.println("find an account:"+ username);
                return ua;
           }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Person person, Role role,AccountType accountType){
        UserAccount userAccount= null;
        if (accountType.getValue().equals(AccountType.Donor.getValue())){
            userAccount = new DonorAccount();
            
        }else if(accountType.getValue().equals(AccountType.Spot.getValue())){
            userAccount = new SpotAccount();
            
        }
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setPerson(person);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
    
    public void deleteUserAccount(UserAccount ua) {
        userAccountList.remove(ua);
        
    }
}
