
package bookingapp;

import java.util.Scanner;

/**
 *
 * @author escan
 */
public class BookingApp {

    /**
     * @param args the command line arguments
     */
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        //instance for the bookings class will be used if it is needed 
        
        Bookings booking = new Bookings ();
        
        //instance for the CateringCottages class
        
        CateringCottages cc = new CateringCottages();
        
        //instance for the HotelRomms class
        
        HotelRooms hr = new HotelRooms ();
        
        //setting the variable in CateringCottages class 
        
        System.out.println("Please choose number one for the CateringCottages and number two for HotelRooms:");
        int X = input.nextInt();
        int Y = 1;
        while (Y == 1) {
            
            if (X == 1) {

                cc.setAddress("Camden Street Upper");
                cc.setKeyCollectionPoint('D');

                //getting them via getters 

                System.out.println("this is the address of the hotel: " + cc.getAddress());
                System.out.println("This is the collection point: " + cc.getKeyCollectionPoint());
            
                break;
                
            }
            
            else if (X == 2) {
               
                ////setting the variable in HotelRooms class 

                hr.setBreakFast(true);
                hr.setRoomNumber("4");

                //getting them via getters 

                if (hr.isBreakFast() == true) {
                    String BreakfastIncluded = "The breakfast is included.";
                    System.out.println(BreakfastIncluded);
                }
                else if (hr.isBreakFast() == false){
                    String BreakfastIsNotIncluded = "The breakfast is not included.";
                    System.out.println(BreakfastIsNotIncluded);
                }

                System.out.println("The room number is: " + hr.getRoomNumber());
                
                break;
                
            }
            
            else {
                
                System.out.println("Opps,Wrong choice!");
                break;
                
            }
        }
    }
    
}
