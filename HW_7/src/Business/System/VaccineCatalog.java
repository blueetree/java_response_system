/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.System;

import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class VaccineCatalog {
    private ArrayList<Vaccine> vaccineCatalog;
    VaccineCatalog(){
        vaccineCatalog = new ArrayList<>();
    }
    public Vaccine addVaccine(){
        Vaccine vaccine = new Vaccine();
        vaccineCatalog.add(vaccine);
        return vaccine;
    }
    
    public ArrayList<Vaccine> getVaccineCatalog() {
        return vaccineCatalog;
    }

    public void setVaccineCatalog(ArrayList<Vaccine> vaccineCatalog) {
        this.vaccineCatalog = vaccineCatalog;
    }
}
