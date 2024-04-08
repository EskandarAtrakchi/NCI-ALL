package linearsearch;

import java.util.ArrayList;

/**
 *
 * @author Eskandar Atrakchi
 * @param <E>
 */
public class LinearSearchClass <E> extends ArrayList <E> {
    
    public int nonSequentialSearch (E key) {
        for (int i = 0; i < size(); i ++) {
            if (((Comparable) get(i)).compareTo ((Comparable) key) == 0 ) {
                return i;
            } 
        }
        return -1;//do this without else so we can go to the end of the list 
    }
    
    public int orderSequentialSearch (E key) {
        
        int i = 0;
        
        while ( ((Comparable) get(i)).compareTo ((Comparable) key) < 0  && i < size ()) {
            i ++;
            
        }
        if (((Comparable) get(i)).compareTo ((Comparable) key) == 0) {
            return i;
        } 
        return -1;
     }
}
