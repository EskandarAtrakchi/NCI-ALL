/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shapeinheritance;

/**
 *
 * @author escan
 */
public class ShapeApp {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Circle c = new Circle();
        c.setName("Circle");
        
        System.out.println("Get method in action From parent: " + c.getName () );
        
    }
}
