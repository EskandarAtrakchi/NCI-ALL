package linearsearch;

/**
 *
 * @author Eskandar Arakchi
 */
public class LinearSearchApp {

    public static void main(String[] args) {
        
        
        
        LinearSearchClass <Integer> lsc1 = new LinearSearchClass <> ();
                
        LinearSearchClass <Integer> lsc2 = new LinearSearchClass <> ();
        
        lsc1.add(32);
        lsc1.add(2);
        lsc1.add(5);
        lsc1.add(6);
        lsc1.add(1);
        lsc1.add(23);
        lsc1.add(76);
        
        lsc2.add(1);
        lsc2.add(2);
        lsc2.add(4);
        lsc2.add(9);
        lsc2.add(10);
        lsc2.add(20);
        lsc2.add(24);
        
        System.out.println("list1 before: " + lsc1.toString());
        
        int key = 1;
        
        System.out.println("results1 after:" + lsc1.nonSequentialSearch (key));
        
        System.out.println();
        
        System.out.println("list2 before: " + lsc2.toString());
        
        key = 24;
        System.out.println("key2 = " + key);
        
        System.out.println("result2 after " + lsc2.orderSequentialSearch (key));
        
    }
    
}
