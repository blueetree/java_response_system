/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New.monitor;

import java.util.Comparator;

/**
 *
 * @author jiahuanli
 */
public class SortByRevenue implements Comparator{
    public int compare(Object top1,Object top2) {  
     Top10 t1 = (Top10)top1;
     Top10 t2 = (Top10)top2;
    if(t1.orderRevenue != t2.orderRevenue){  
     return t1.orderRevenue - t2.orderRevenue;  
    }else{
       return t1.missedRevenue-t2.missedRevenue;
    }
    }
}
