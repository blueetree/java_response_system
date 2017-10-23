/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Admin;

/**
 *
 * @author jiahuanli
 */
public class Top10 {
    public String personID;
    public String personName;
    public double orderRevenue;
    public double missedRevenue;
    public Top10(String personID,String personName,double orderRevenue,double missedRevenue){
        this.personID = personID;
        this.personName = personName;
        this.orderRevenue = orderRevenue;
        this.missedRevenue = missedRevenue;
    }
}
