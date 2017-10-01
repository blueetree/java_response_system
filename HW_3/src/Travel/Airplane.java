/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel;

/**
 *
 * @author jiahuanli
 */
public class Airplane {
    private String serialNum;
    private String company;
    private int seatsNum;
    private int baseCost;
    Seats seats;
    private String filghtScheduleId; 
    
    public Airplane(){
        seats = new Seats();
    }

    public String getFilghtScheduleId() {
        return filghtScheduleId;
    }

    public void setFilghtScheduleId(String filghtScheduleId) {
        this.filghtScheduleId = filghtScheduleId;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSeatsNum() {
        return seatsNum;
    }

    public void setSeatsNum(int seatsNum) {
        this.seatsNum = seatsNum;
    }

    public int getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(int baseCost) {
        this.baseCost = baseCost;
    }

    public Seats getSeats() {
        return seats;
    }

    public void setSeats(Seats seats) {
        this.seats = seats;
    }

    

    

    
}
