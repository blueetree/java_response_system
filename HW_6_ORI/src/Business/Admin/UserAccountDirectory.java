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
public class UserAccountDirectory {
      private List<UserAccount> userAccountDirectory;

    public UserAccountDirectory() {
     userAccountDirectory = new ArrayList<UserAccount>();
    }
    
    public List<UserAccount> getUserAccountDirectory(){
        return  userAccountDirectory;
    }
    
    
    public UserAccount addUserAccount(){
       UserAccount us = new UserAccount();
        userAccountDirectory.add(us);
        return us;
    }
    
        public void removeUserAccount(UserAccount us){
        userAccountDirectory.remove(us);
    }
    
    public UserAccount searchUserAccount(String userName){
        for (UserAccount ua : userAccountDirectory) {
            if(ua.getUserName().equalsIgnoreCase(userName)){
                return ua;
            }
        }
      System.out.println("didn't find anyything");
        return null;
    }
}
