/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inhiretance;

/**
 *
 * @author escan
 */
public class Child extends Parent {

    private String talent;
    
    public Child() {
        System.out.println("Inside ChildOne constrocture");
    }

    public Child(String talent, String name) {
        super(name);
        this.talent = talent;
    }

    public String getTalent() {
        return talent;
    }
    
    public String print (String name, String talent) {
        
        return "name : " + name + ", talent: " + talent;
        
    }
    
    public String print (String name) { 
        
        return "name: " + name;
        
    }
    
}
