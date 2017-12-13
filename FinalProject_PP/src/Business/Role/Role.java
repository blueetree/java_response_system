/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Area.Area;
import Business.Country.Country;
import Business.District.District;
import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;


/**
 *
 * @author jiahuanli
 */
public abstract class Role {
    
    public enum RoleType{
        Donor("Donor"),
        Victim("Victim"),
        Command("Command"),
        FrontLine("Front Line"),
        Purchase("Purchase"),
        AdminCountry("Admin Country"),
        AdminSystem("Admin System");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account,
            Area area,
            District district,
            Country country,
            EcoSystem system);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}