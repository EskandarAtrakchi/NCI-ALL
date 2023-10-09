import java.util.Scanner;

import javax.swing.JOptionPane;// import the JOptionPane class
public class LinearSearch {
    public static void main(String args[]){
        int [] data = new int[100];// random value array
        for(int i=0; i<data.length; i++){// for loop to generate random values
            data[i] = (int)(Math.random() * 1000); // generate random value
        }

        int query = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a value to search for within the array"));
        
        data[76] = query; // set the value to be searched

        int counter = 0;// count the number of times the value was found
        for(int indexNum = 0; indexNum < data.length; indexNum++){// for loop to search for the value
            if(data[indexNum] == query){// if the value was found, print the position
                System.out.println("Found at position: " + indexNum);
                indexNum = data.length;// reset the indexNum to the end of the array
            }
            counter++;// increment the counter
        }

        System.out.println("This took " + counter + " many steps");// print the number of times the

    }
}
