/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

/**
 *
 * @author jiahuanli
 */
public abstract class Role {
    public enum RoleType{
        Provider("Provider"),
        Clinic("Clinic");
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
    
    /*public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);*/
    
    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
