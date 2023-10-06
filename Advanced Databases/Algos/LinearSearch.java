import java.util.Scanner;

import javax.swing.JOptionPane;
public class LinearSearch {
    public static void main(String args[]){
        int [] data = new int[100];// random value array
        for(int i=0; i<data.length; i++){
            data[i] = (int)(Math.random() * 1000); 
        }

        int query = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a value to search for within the array"));
        
        data[76] = query; 

        int counter = 0;
        for(int indexNum = 0; indexNum < data.length; indexNum++){
            if(data[indexNum] == query){
                System.out.println("Found at position: " + indexNum);
                indexNum = data.length;
            }
            counter++;
        }

        System.out.println("This took " + counter + " many steps");

    }
}
