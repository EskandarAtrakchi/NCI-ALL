/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeeapp;

/**
 *
 * @author escan
 */
public class Employee {
    
    protected String name;
    protected int id;
    protected String dob;

    public Employee() {
        
        name = "";
        id = 0;
        dob = "";
        
    }

    public Employee (String name, int id, String dob) {
        
        this.name = name;
        this.id = id;
        this.dob = dob;
        
    }
    
    public String details () {
        
        return "Employee name: " + name + ", id: " + id;
        
    }
    
    public boolean canHireEmployee (Employee e) {
        
        if (e instanceof Manager) {
            
            return true;
            
        }
        
        else {
            
            return false;
            
        }
        
    }
    
    public void modifyForSalary (Employee e, double Salary) {
            
        if (e instanceof Manager) {

            Manager m = (Manager) e;
            m.setSalary(Salary);
            
            System.out.println("The updated salary is " + Salary);
            
        }
        
        //return e instance of Manager 
        //more efficient way of putting the above statement

    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
