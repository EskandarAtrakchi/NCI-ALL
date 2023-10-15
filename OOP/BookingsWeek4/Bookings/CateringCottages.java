
package bookingapp;

import java.util.ArrayList;

/**
 *
 * @author escan
 */
public class CateringCottages extends Bookings {
    
    private String address;
    private char keyCollectionPoint;
    private double cottageCost;
    
    //we will need this array later in BookingApp class 
    static ArrayList<CateringCottages> cottageList = new ArrayList<CateringCottages>();

    public CateringCottages() {
    }

    //we will need this constructor in BookingApp class 
    //Note, be careful follow the same sequance of the parameter in the constructor 
    
    public CateringCottages(String address, char keyCollectionPoint, double cottageCost, String clientName, String bookingReference, String startDate, double nightDuration) {
        
        super(clientName, bookingReference, startDate, nightDuration);
        this.address = address;
        this.keyCollectionPoint = keyCollectionPoint;
        this.cottageCost = cottageCost;
        
    }
    
    public double getCottageCost() {
        return cottageCost;
    }

    public void setCottageCost(double cottageCost) {
        this.cottageCost = cottageCost;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public char getKeyCollectionPoint() {
        return keyCollectionPoint;
    }

    public void setKeyCollectionPoint(char keyCollectionPoint) {
        this.keyCollectionPoint = keyCollectionPoint;
    }
    
    
}
