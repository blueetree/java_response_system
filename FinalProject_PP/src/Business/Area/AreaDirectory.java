/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Area;

import Business.Area.Area.Type;
import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class AreaDirectory {
    
    private ArrayList<Area> areaList;
    private String totalMoney;

    public AreaDirectory() {
        areaList = new ArrayList<>();
    }

    public ArrayList<Area> getAreaList() {
        return areaList;
    }
    
    public Area createArea(String name,Type type,double Lx, double Ly){
        Area area = null;
        if (type.getValue().equals(Type.A.getValue())){
            area = new AreaA();
        }else if (type.getValue().equals(Type.B.getValue())){
            area = new AreaB();
        }
        area.setName(name);
        areaList.add(area);
        area.setLocation_x(Lx);
        area.setLocation_y(Ly);
        return area;
    }
    
    public void deleteArea(Area a) {
        areaList.remove(a);
        
    }
    
    
 
   public String totalMoney(){
       
       for(Area area:areaList){
         totalMoney+= area.getMoney();
       }
       return totalMoney;
   }
    
}