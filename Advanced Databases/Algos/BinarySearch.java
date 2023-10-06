import java.util.Scanner;

public class BinarySearch {
    public static void main(String args[]){
     int [] data = {10, 9, 101, 50, 99, 66, 12, -5};

        Scanner sc = new Scanner(System.in);
        int query = sc.nextInt();

        sortData(data);
        //printData(data);
        

        int lowerIndex = 0;
        int upperIndex = data.length-1;
        boolean found = false;

        while(!found && upperIndex >= lowerIndex){
            int midPoint = ((upperIndex - lowerIndex)/2) + lowerIndex;
            
            if(data[midPoint] == query){
                found = true;
                System.out.println("Data is found at: " + midPoint);
            }
            else if(data[midPoint] > query){
                upperIndex = midPoint-1;
            }
            else{
                lowerIndex = midPoint+1;
            }
        }
        
        if(!found){
            System.out.println("Data is not in the array");
        }
    }

    static void printData(int data[]){
        for(int d : data){
            System.out.print(d + ", ");
        }
    }

    static void sortData(int data[]){
        // sorting : bubblesort
        for(int i=0; i<data.length; i++){
            for(int j=0; j<data.length; j++){
                if(data[i] < data[j]){
                    int temp= data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
}
