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
public class DiseaseCatalog {
    private ArrayList<Disease> diseaseCatalog;
    
    DiseaseCatalog(){
        diseaseCatalog = new ArrayList<>();
    }
    
    public Disease addDisease(){
        Disease disease = new Disease();
        diseaseCatalog.add(disease);
        return disease;
    }

    public ArrayList<Disease> getDiseaseCatalog() {
        return diseaseCatalog;
    }

    public void setDiseaseCatalog(ArrayList<Disease> diseaseCatalog) {
        this.diseaseCatalog = diseaseCatalog;
    }
}
