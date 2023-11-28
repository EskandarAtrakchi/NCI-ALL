/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeeapp;

/**
 *
 * @author escan
 */
public class Cleaner extends Employee {
    
    private double hourlyRate;
    private double hours;

    public Cleaner() {
    }
    
    @Override
    public String details() {
        
        return super.details() 
                
                + "\n" + 
                "Hourly Rate: " + hourlyRate 
                + "\n" +
               "Hours Worked: " + hours 
                + "\n";
        
    }

    
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
    
    
}
