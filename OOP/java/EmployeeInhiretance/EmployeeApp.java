/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package employeeapp;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author escan
 */

public class EmployeeApp {
    static Scanner sc = new Scanner (System.in);
    
    
    /**
     * @param args the command line arguments
     */
    
    public static void main (String[] args) {
        
        //Manager instance here 
        
        Manager M = new Manager ();
        M.setDept("Education");
        M.setDob("17/11/1996");
        M.setId(101);
        M.setName("Eskandar Atrakchi");
        M.setSalary(100000.0);
        
        //cleaner instance here 
        
        Cleaner C = new Cleaner ();
        C.setDob("17/Nov/1996");
        C.setHourlyRate(12.0);
        C.setHours(40.0);
        C.setId(10);
        C.setName("Joshua Yonus");
        
        //Employee instance here 
        
        Employee E = new Employee ();
        E.setDob("10/10/1990");
        E.setId(1);
        E.setName("Josh Alex");
        
        ////////////////////////////////////////////////
        //Start to add here from today's lecture 
        
        //C.details();//Remeber the method returns so print it out 
        
        System.out.println(C.details());
        
        ////////////////////////////////////////////////
        
        Employee e = new Manager ();
        
        //e.canHireEmployee(e);//Remeber the method returns so print it out 
        
        System.out.println("Can hire? " + e.canHireEmployee(e));
        
        Employee e1 = new Cleaner();
        
        System.out.println("Can hire? " + e1.canHireEmployee(e1) );
        
        M.modifyForSalary(e, 12321.0);
        
        //the end of what we added from today's lecture
        
        System.out.println("Click one to display the manager and two to display the cleaner or number three for basic");
        
        int scChoice = sc.nextInt() ;
        
        boolean X = false;
        
        while(X != true){//keep looping as long as it is true
            
            if (scChoice == 1) {

                System.out.println("This is the manager section display and below are the details:");
                System.out.println("The department is:" + M.getDept());
                System.out.println("The date of birth is: " + M.getDob());
                System.out.println("The ID is: " + M.getId());
                System.out.println("The name of the manager is: " + M.getName());
                System.out.println("The salary of the manager is: " + M.getSalary());
                
                break;
                
            }

            else if (scChoice == 2) {

                System.out.println("This is the Cleaner section display and below are the details:");
                System.out.println("The date of birth of the cleaner is: " + C.getDob());
                System.out.println("The HourlyRate of the cleaer is: " + 12 + " Euros per hour.");
                System.out.println("This is the worked hours: " + 40 + " hours.");
                System.out.println("This is the claener ID: " + C.getId());
                System.out.println("This is the cleaner's name: " + C.getName());
                
                break;
                
            }
            
            else if (scChoice == 3) {

                System.out.println("This is the basic section displayed and below are the details:");
                System.out.println("this is the date of birth of the person added to basic section:" + E.getDob());
                System.out.println("this is the ID of the person added to basic section:" + E.getId());
                System.out.println("this is the name of the person added to basic section:" + E.getName());
                
                break;//Stop the loop 
                
            }
            
            else {
                
                System.out.println("Opps, wrong choice!!");
                
                break;
                
            }
        }
        
    }
    
}
