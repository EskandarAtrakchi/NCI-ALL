/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inhiretance;

/**
 *
 * @author escan
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Child cl = new Child("This is Talent", "This is Name");
        
        System.out.println("get : " + cl.getName() + "\n" + cl.getTalent());
        
        cl.print("One Para");
        
        cl.print("First Para", "Second Para");
        
        System.out.println(cl.print("First Para", "Second Para"));
        
        ChildTwo c2 = new ChildTwo ("c2");
        
        System.out.println("get : " + c2.getName());
    }
}
