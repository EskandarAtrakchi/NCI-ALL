
package bookingapp;

/**
 *
 * @author escan
 */
public class HotelRooms {
    
    private String roomNumber;
    private boolean breakFast;

    public HotelRooms() {
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
