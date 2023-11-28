/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapeinheritance;

/**
 *
 * @author escan
 */
public class Shape {
    protected String name;
    protected double area;

    public Shape() {}

    public Shape(String name) {
        this.name = name;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }
}
