
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
        System.out.println("Please enter number 3 to add data to the system.");
        int X = input.nextInt();//just to control the if statements through this input
        while (true) {
            
            if (X == 1) {
                
                //setters here 
                
                cc.setAddress("Camden Street Upper");
                cc.setKeyCollectionPoint('D');
                cc.setCottageCost(110.0);

                //getting them via getters 

                System.out.println("this is the address of the hotel: " + cc.getAddress());
                System.out.println("This is the collection point: " + cc.getKeyCollectionPoint());
                System.out.println("This is the total cost of the cottage: " + cc.getCottageCost() + "$");
            
                break;//stopping the loop
                
            }
            
            else if (X == 2) {
               
                ////setting the variable in HotelRooms class 
                System.out.println("is breakfast included? \nnumber 1 for yes\nnumber 2 for no");
                int breakfastCheck = input.nextInt();//taking user input to control the if statemetns 
                
                if (breakfastCheck == 9) {
                    
                    hr.setBreakFast(true);
                
                } else if (breakfastCheck == 8) {
                    
                    hr.setBreakFast(false);
                    
                } 
                
                hr.setRoomNumber("4");
                hr.setHotelRoomCost(130.0);

                //getting them via getters 

                if (hr.isBreakFast() == true) {
                    
                    String BreakfastIncluded = "The breakfast is included.";
                    System.out.println(BreakfastIncluded);
                    double hotelCostWithBreakFast = hr.getHotelRoomCost() + 10.0;
                    System.out.println("The cost of the room with the breakfast is: " + hotelCostWithBreakFast + "$");
                    
                }
                
                else if (hr.isBreakFast() == false) {
                    
                    String BreakfastIsNotIncluded = "The breakfast is not included.";
                    System.out.println(BreakfastIsNotIncluded);
                    System.out.println("The cost of the hotel room is only: " + hr.getHotelRoomCost() + "$");
                    
                }

                System.out.println("The room number is: " + hr.getRoomNumber());
                
                break;
                
            }
            
            else if (X == 3) {
                
                System.out.println("Please select number 1 to add cottages and number 2 to add rooms");
                int add = input.nextInt();
                if (add == 1) {
                    
                    //I am here creating variables to take user input 
                    System.out.println("Please enter the client name: ");
                    String clientName = input.next();
                    System.out.println("Please enter the booking reference: ");
                    String bookingReference = input.next();
                    System.out.println("Please enter the start date: ");
                    String startDate = input.next();
                    System.out.println("Please enter the night duration: ");
                    double nightDuration = input.nextByte();
                    System.out.println("Please enter the address: ");
                    String address = input.next();
                    System.out.println("Please enter the key collection point: ");
                    char keyCollectionPoint = input.next().charAt(0);
                    System.out.println("Please enter the cottage cost: ");
                    double cottageCost = input.nextDouble();
                    
                    //communicating with the constructor in the CateringCottages class
                    CateringCottages cottageInstance = new CateringCottages (address, keyCollectionPoint, cottageCost, clientName, bookingReference, startDate, nightDuration);
                    CateringCottages.cottageList.add(cottageInstance);//adding the object by object array
                    System.out.println("Data added successfully.");
                    break;//stop the loop 
                    
                } else if (add == 2) {
                    
                    //the same concept above 
                    System.out.println("Please enter the client name: ");
                    String clientName = input.next();
                    System.out.println("Please enter the booking reference: ");
                    String bookingReference = input.next();
                    System.out.println("Please enter the start date: ");
                    String startDate = input.next();
                    System.out.println("Please enter the night duration: ");
                    double nightDuration = input.nextDouble();
                    System.out.println("Please enter the room number: ");
                    String roomNumber = input.next();
                    System.out.println("Please enter number 1 if the breakfast is included and number 2 if it is not: ");
                    int userBreakfast = input.nextInt();
                    boolean breakFast;
                    if (userBreakfast == 1) {
                        
                        breakFast = true;
                        
                    } else {
                        
                        breakFast = false;
                        
                    }
                    
                    System.out.println("Please enter the hotel room cost: ");
                    double hotelRoomCost = input.nextDouble();
                    
                    HotelRooms hotelRooms = new HotelRooms(roomNumber, breakFast, hotelRoomCost, clientName, bookingReference, startDate, nightDuration);
                    HotelRooms.roomsList.add(hotelRooms);
                    System.out.println("Data added successfully.");
                    break;
                    
                }
            }
            
            else {
                
                System.out.println("Opps,Wrong choice!");
                break;
                
            }
        }
    }
}
 