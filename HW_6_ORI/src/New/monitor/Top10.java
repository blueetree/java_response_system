/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New.monitor;

/**
 *
 * @author jiahuanli
 */
public class Top10 {
    public String personID;
    public String personName;
    public int orderRevenue;
    public int missedRevenue;
    public Top10(String personID,String personName,int orderRevenue,int missedRevenue){
        this.personID = personID;
        this.personName = personName;
        this.orderRevenue = orderRevenue;
        this.missedRevenue = missedRevenue;
    }
}
