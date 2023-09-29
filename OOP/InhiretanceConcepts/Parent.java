/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inhiretance;

/**
 *
 * @author escan
 */
public class Parent {
    
    protected String name;//can be accessed by oher classes in the same package 

    public Parent() {
        System.out.println("This is Parent constrcture ");
    }

    public Parent(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
