/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travel;

import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class Seats {
    private ArrayList<Seat> seats;
    
    public Seats(){
        seats = new ArrayList<>();
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
    
    public Seat addSeat(){
        Seat st = new Seat();
        seats.add(st);
        return st;
    }
    
}
