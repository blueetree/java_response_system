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
import Interface.Donor.DonorWorkAreaJPanel;
import javax.swing.JPanel;


/**
 *
 * @author jiahuanli
 */
public class DonorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Area area, District district,Country country, EcoSystem system) {
        return new DonorWorkAreaJPanel(userProcessContainer,account,area,district,system);//To change body of generated methods, choose Tools | Templates.
    }
    
}
