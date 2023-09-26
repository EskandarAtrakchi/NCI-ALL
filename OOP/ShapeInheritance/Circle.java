/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapeinheritance;

/**
 *
 * @author escan
 */
public class Circle extends Shape {
    private double radius;

    public Circle() {
    }

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }
    public double ComputeArea () {
        area = 3.14 * radius * radius;
        return area;
    } 

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
}
