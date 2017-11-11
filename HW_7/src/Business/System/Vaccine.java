/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.System;

/**
 *
 * @author jiahuanli
 */
public class Vaccine {
    private String vaccineID;
    private String vaccineName;
    private Disease targetDisease;
    private String status;

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public Disease getTargetDisease() {
        return targetDisease;
    }

    public void setTargetDisease(Disease targetDisease) {
        this.targetDisease = targetDisease;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString(){
        return vaccineID;
    }
}
