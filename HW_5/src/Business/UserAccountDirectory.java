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
public class UserAccountDirectory {
    private ArrayList<UserAccount> userAccountDirectory;
    private String userAccountDirectoryID;

    public String getUserAccountDirectoryID() {
        return userAccountDirectoryID;
    }

    public void setUserAccountDirectoryID(String userAccountDirectoryID) {
        this.userAccountDirectoryID = userAccountDirectoryID;
    }
    
    public UserAccountDirectory(){
        userAccountDirectory = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(ArrayList<UserAccount> userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }
    
    public UserAccount addUserAccount(){
        UserAccount userAccount = new UserAccount();
        userAccountDirectory.add(userAccount);
        return userAccount;
    }
    
    public UserAccount searchUserAccount(String userName){
        for(UserAccount userAccount:userAccountDirectory){
            if(userAccount.getUserName().equals(userName)){
                return userAccount;
            }
        }
        return null;
    }
}
