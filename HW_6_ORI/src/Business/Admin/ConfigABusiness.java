/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Admin;

import java.util.Random;
import java.io.UnsupportedEncodingException;    
import javax.xml.bind.DatatypeConverter;
/**
 *
 * @author liuch
 */
public class ConfigABusiness {
    public static void getConfig(UserAccountDirectory ud, PersonDirectory pd)
    {
       for(int k =0;k<100;k++)
       {
           Person p = pd.addPerson();
           p.setFirstName(getName());
           p.setLastName(getName());
           UserAccount ua =ud.addUserAccount();
           String userName = getName();
           ua.setUserName(userName);
           System.out.print("user name: "+userName+"        ");
           String password =getPassWord();
            String encoded =DatatypeConverter.printBase64Binary(password.getBytes());
       //    int savedWord=password.hashCode();
          ua.setPassWord(encoded);
            System.out.print("   password: "+password);
           ua.setPerson(p);
           System.out.print(" Person name "+ p.getFirstName()+"   " );
          if(k%2==0)
          { ua.setRole(Role.HR_dmin);
            //System.out.println("Role is HR"+ud.getUserAccountDirectory().size()+"length of Person"+pd.getPersonDirectory().size());
            System.out.println("Role is HR");
            System.out.println("          ");
            
          }
          else
          {ua.setRole(Role.System_admin);
           System.out.println("Role is Admin");
            System.out.println("          ");
          }
         
       }
       
      
   }
    public static String getName()
    {
        
       char cha[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
       char chb[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
       char ch[] =new char[6];
       int index0=(int)(Math.random()*(cha.length));
       ch[0]=cha[index0];
       for(int i=1;i<ch.length;i++)
      {
         int index;
         index=(int)(Math.random()*(chb.length));
         ch[i]=chb[index];
      }
       String s = new String(ch);
        return s;
    }
     public static String getPassWord()
    {
        
       char cha[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9','0'};
       char ch[] =new char[5];
       for(int i=0;i<ch.length;i++)
      {
         int index;
         index=(int)(Math.random()*(cha.length));
         ch[i]=cha[index];
      }
       String s = new String(ch);
        return s;
    }
}