/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author jiahuanli
 */
public class TravelAgency {
    private String agencyName;
    private AirlinerDirectory airlinerDirectory;
    private CustomerDirectory customerDirectory;
    private MasterFlightSchedule masterFlightSchedule;

    public TravelAgency(){
        airlinerDirectory = new AirlinerDirectory();
        customerDirectory = new CustomerDirectory();
        masterFlightSchedule = new MasterFlightSchedule();
    }
    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public AirlinerDirectory getAirlinerDirectory() {
        return airlinerDirectory;
    }

    public void setAirlinerDirectory(AirlinerDirectory airlinerDirectory) {
        this.airlinerDirectory = airlinerDirectory;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public MasterFlightSchedule getMasterFlightSchedule() {
        return masterFlightSchedule;
    }

    public void setMasterFlightSchedule(MasterFlightSchedule masterFlightSchedule) {
        this.masterFlightSchedule = masterFlightSchedule;
    }
}
