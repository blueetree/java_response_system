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
public class AirlinerDirectory {
    private ArrayList<Airliner> airlinerDirectory;
    
    public AirlinerDirectory(){
        this.airlinerDirectory = new ArrayList<>();
    }

    public ArrayList<Airliner> getAirlinerDirectory() {
        return airlinerDirectory;
    }

    public void setAirlinerDirectory(ArrayList<Airliner> airlinerDirectory) {
        this.airlinerDirectory = airlinerDirectory;
    }
    
    public Airliner addAirliner(){
        Airliner airliner = new Airliner();
        airlinerDirectory.add(airliner);
        return airliner;
    }
    
    public void deleteAccount(Airliner airliner){
        airlinerDirectory.remove(airliner);
    }
    
    public Airliner searchAccount(String airlinerID){
        for(Airliner airliner : airlinerDirectory){
            if(airliner.getAirlineID().equals(airlinerID)){
                return airliner;
            }
        }
        return null;
    }
}
