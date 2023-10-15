
package bookingapp;

import java.util.ArrayList;

/**
 *
 * @author escan
 */
public class HotelRooms extends Bookings {
    
    private String roomNumber;
    private boolean breakFast;
    private double hotelRoomCost;
    
    //we will need this array later in BookingApp class 
    static ArrayList<HotelRooms> roomsList = new ArrayList<HotelRooms>();

    public HotelRooms() {
    }

    //we will need this constructor in BookingApp class 
    //Note, be careful follow the same sequance of the parameter in the constructor 
    public HotelRooms(String roomNumber, boolean breakFast, double hotelRoomCost, String clientName, String bookingReference, String startDate, double nightDuration) {
        
        super(clientName, bookingReference, startDate, nightDuration);
        this.roomNumber = roomNumber;
        this.breakFast = breakFast;
        this.hotelRoomCost = hotelRoomCost;
        
    }

    public double getHotelRoomCost() {
        return hotelRoomCost;
    }

    public void setHotelRoomCost(double hotelRoomCost) {
        this.hotelRoomCost = hotelRoomCost;
    }
    
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isBreakFast() {
        return breakFast;
    }

    public void setBreakFast(boolean breakFast) {
        this.breakFast = breakFast;
    }
}
