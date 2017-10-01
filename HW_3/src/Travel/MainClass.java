/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jiahuanli
 */
public class MainClass {
    public static void main(String args[]){   
        TravelAgency ta = new TravelAgency();
        //CustomerDirectory
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/CustomerDirectory")); 
            System.out.println("CustomerDirectory");
            //reader.readLine();  
            String line = null;    
            
            while((line=reader.readLine())!=null){ 
               System.out.println(line);
               String item[] = line.split(",");
               Customer customer = ta.getCustomerDirectory().addCustomer();
               customer.setCustomerID(item[0]);
               customer.setName(item[1]);
               customer.setSeatID(item[2]);
               customer.setFilghtID(item[3]);
            }  
        } catch (Exception e) {    
            e.printStackTrace();    
        }
  
        //MasterSchedule
        //1
        MasterSchedule masterSchedule = ta.getMasterSchedule();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/FilghtSchedule1")); 
            System.out.println();
            System.out.println("MasterSchedule");
            System.out.println("FilghtSchedule1");
            //reader.readLine();  
            String line = null;    
            
            while((line=reader.readLine())!=null){  
               System.out.println(line);
               String item[] = line.split(",");
               FilghtSchedule filghtSchedule1 = masterSchedule.addFilghtSchedule();
               Filght filght1 = filghtSchedule1.addFilght();
               filght1.setArrivalDate(item[0]);
               filght1.setArriveLocation(item[1]);
               filght1.setDepartureDate(item[2]);
               filght1.setDepartureLocation(item[3]);
               filghtSchedule1.setFilghtScheduleId(item[4]);
               filght1.setFilghtID(item[5]);
               
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }
        //2

        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/FilghtSchedule2")); 
            //reader.readLine();  
            String line = null;    
            System.out.println("FilghtSchedule2");
            while((line=reader.readLine())!=null){  
               System.out.println(line);
               String item[] = line.split(",");
               FilghtSchedule filghtSchedule2 = masterSchedule.addFilghtSchedule();
               Filght filght2 = filghtSchedule2.addFilght();
               filght2.setArrivalDate(item[0]);
               filght2.setArriveLocation(item[1]);
               filght2.setDepartureDate(item[2]);
               filght2.setDepartureLocation(item[3]);
               filghtSchedule2.setFilghtScheduleId(item[4]);
               filght2.setFilghtID(item[5]);
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }
        
        //3
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/FilghtSchedule3")); 
            //reader.readLine();  
            String line = null;    
            System.out.println("FilghtSchedule3");
            while((line=reader.readLine())!=null){  
                System.out.println(line);
               String item[] = line.split(",");
               FilghtSchedule filghtSchedule3 = masterSchedule.addFilghtSchedule();
               Filght filght3 = filghtSchedule3.addFilght();
               filght3.setArrivalDate(item[0]);
               filght3.setArriveLocation(item[1]);
               filght3.setDepartureDate(item[2]);
               filght3.setDepartureLocation(item[3]);
               filghtSchedule3.setFilghtScheduleId(item[4]);
               filght3.setFilghtID(item[5]);
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }
        
        //4
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/FilghtSchedule4")); 
            //reader.readLine();  
            String line = null;    
            System.out.println("FilghtSchedule4");
            while((line=reader.readLine())!=null){  
               System.out.println(line);
               String item[] = line.split(",");
               FilghtSchedule filghtSchedule4 = masterSchedule.addFilghtSchedule();
               Filght filght4 = filghtSchedule4.addFilght();
               filght4.setArrivalDate(item[0]);
               filght4.setArriveLocation(item[1]);
               filght4.setDepartureDate(item[2]);
               filght4.setDepartureLocation(item[3]);
               filghtSchedule4.setFilghtScheduleId(item[4]);
               filght4.setFilghtID(item[5]);
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }
        
        
        //Airliners1
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/Fleet1")); 
            System.out.println();
            System.out.println("Airliners");
            System.out.println("Fleet1");
            String line = null; 
            String lineSeat = null;
            int i =1;
            Fleet fleet1 = ta.getAirliners().addFleet();
            while((line=reader.readLine())!=null){ 
               System.out.println(line);
               String item[] = line.split(",");
               Airplane airplane = fleet1.addAirplane();
               airplane.setBaseCost(Integer.parseInt(item[0]));
               airplane.setCompany(item[1]);
               airplane.setSeatsNum(Integer.parseInt(item[2]));
               airplane.setSerialNum(item[3]);
               airplane.setFilghtScheduleId(item[4]);
               BufferedReader readerSeats = new BufferedReader(new FileReader("data/Seats"+i));
               System.out.println("Seats"+i);
               while((lineSeat=readerSeats.readLine())!=null){
               System.out.println(lineSeat);
               String itemSeats[] = lineSeat.split(",");
               Seat seat = airplane.getSeats().addSeat();
               seat.setSeatID(itemSeats[0]);
               seat.setAvailable(Boolean.parseBoolean(itemSeats[1]));
               seat.setLeftRight(itemSeats[2]);
               seat.setPrice(Integer.parseInt(itemSeats[3]));
               seat.setRow(Integer.parseInt(itemSeats[4]));
               seat.setView(itemSeats[5]);
               }
               i = i+1;

            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/Fleet2")); 
            String line = null; 
            String lineSeat = null;
            System.out.println("Fleet2");
            int i =3;
            Fleet fleet2 = ta.getAirliners().addFleet();
            while((line=reader.readLine())!=null){ 
                System.out.println(line);
               String item[] = line.split(",");
               Airplane airplane = fleet2.addAirplane();
               airplane.setBaseCost(Integer.parseInt(item[0]));
               airplane.setCompany(item[1]);
               airplane.setSeatsNum(Integer.parseInt(item[2]));
               airplane.setSerialNum(item[3]);
               airplane.setFilghtScheduleId(item[4]);
               BufferedReader readerSeats = new BufferedReader(new FileReader("data/Seats"+i)); 
               System.out.println("Seats"+i);
               while((lineSeat=readerSeats.readLine())!=null){
               System.out.println(lineSeat);
               String itemSeats[] = lineSeat.split(",");
               Seat seat = airplane.getSeats().addSeat();
               seat.setSeatID(itemSeats[0]);
               seat.setAvailable(Boolean.parseBoolean(itemSeats[1]));
               seat.setLeftRight(itemSeats[2]);
               seat.setPrice(Integer.parseInt(itemSeats[3]));
               seat.setRow(Integer.parseInt(itemSeats[4]));
               seat.setView(itemSeats[5]);
               }
               i = i+1;

            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }
        
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println("Result:");
        System.out.println("1:total revenues / per flight");
        System.out.println("2:total revenues / per airliner");
        System.out.println("3:total revenues for all flights by all airlines");
        System.out.println("-----------------------------------------------------");    
        System.out.println("1:total revenues / per flight");
                String filghtID;
                int sizeFilght = ta.getMasterSchedule().getMasterSchedule().get(0).getFilghts().size();
                //System.out.println("sizeFilght:"+sizeFilght);
                String filghtPro[][]= new String[8][2];
                filghtID = ta.getCustomerDirectory().getCustomers().get(0).getFilghtID();
                int sizeCustomer = ta.getCustomerDirectory().getCustomers().size();
                int seatPrice = ta.getAirliners().getAirline().get(0).getFleet().get(0).getSeats().getSeats().get(0).getPrice();
                int count = 0;
                int lastCount = 0;
                //System.out.println("getFilghtID:"+ta.getCustomerDirectory().getCustomers().get(27).getFilghtID());
                //System.out.println(ta.getCustomerDirectory().getCustomers().get(27).getFilghtID());
                //System.out.println(sizeCustomer);
                for (int i = 1; i< sizeCustomer; i++){
                    if (!filghtID.equals(ta.getCustomerDirectory().getCustomers().get(i).getFilghtID())){
                        int first = Integer.parseInt(filghtID)-1;
                        System.out.println("filght:"+filghtID);
                        filghtPro[first][0]=filghtID;
                        filghtID = ta.getCustomerDirectory().getCustomers().get(i).getFilghtID();
                        int profit = (count+1)*seatPrice-ta.getAirliners().getAirline().get(0).getFleet().get(0).getBaseCost();
                        System.out.println("profit:"+profit);
                        filghtPro[first][1]=String.valueOf(profit);
                        count=count-lastCount;
                        //no 28
                    }
                    else{
                        count = count+1;
                        
                    }     
                        lastCount = count;
                  }
            System.out.println("-----------------------------------------------------");
            System.out.println("2:total revenues / per airliner"); 
            ArrayList allAirliner = new ArrayList<>();
            int sizeAirline = ta.getAirliners().getAirline().size();
            ArrayList eachAirliner = new ArrayList<>();
            for(int i = 0; i<sizeAirline;i++){
                System.out.println("airliner:"+(i+1));
                int sizeFleet = ta.getAirliners().getAirline().get(i).getFleet().size();
                //System.out.println("sizeFleet:"+sizeFleet);
               for(int j=i*4;j<4*(i+1);j++){
                       int sizefilght = ta.getMasterSchedule().getMasterSchedule().get(j).getFilghts().size();
                           String filghtSameID = ta.getMasterSchedule().getMasterSchedule().get(j).getFilghts().get(0).getFilghtID();
                           
                           for(int a=0;a<8;a++){
                               if(filghtPro[a][0].equals(filghtSameID)){
                                   eachAirliner.add(filghtPro[a][1]);
                                  // System.out.println("filghtPro[1]:"+filghtPro[a][1]); 
                               }
                    
                           }   
           
               }
            int sizeProfit = eachAirliner.size();
            //System.out.println(sizeProfit);
             int profit=0;
             for(int zp=0; zp<sizeProfit;zp++){
             profit = profit + Integer.parseInt((String)eachAirliner.get(zp));
               } 
             eachAirliner.clear();
             System.out.println("profit:"+profit);
             allAirliner.add(profit);
            
            } 
            
            System.out.println("-----------------------------------------------------");
            System.out.println("3:total revenues / all airliners"); 
            int sizeAllAirliners = allAirliner.size();
            //System.out.println(sizeAllAirliners);
            int profit=0;
            for(int aa=0;aa<sizeAllAirliners;aa++){
                //System.out.println("profit"+profit);
             profit = profit + (Integer)allAirliner.get(aa);
               } 
            System.out.println("profit:"+profit);
        }
        
       
    
    
}
