/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationDirectory;
    
    public OrganizationDirectory(){
        organizationDirectory = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(ArrayList<Organization> organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }
    
        public Organization addOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Clinic.getValue())){
            organization = new ClinicOrganization();
            organizationDirectory.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Provider.getValue())){
            organization = new ProviderOrganization();
            organizationDirectory.add(organization);
        }
        return organization;
    }
}
