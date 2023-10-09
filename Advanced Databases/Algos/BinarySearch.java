import java.util.Scanner;

public class BinarySearch {
    public static void main(String args[]){
     int [] data = {10, 9, 101, 50, 99, 66, 12, -5};// 

        Scanner sc = new Scanner(System.in);
        int query = sc.nextInt();// taking input from user

        sortData(data);// sorting the data
        //printData(data);
        

        int lowerIndex = 0;// lower index
        int upperIndex = data.length-1;// upper index
        boolean found = false;// flag to check if data is found

        while(!found && upperIndex >= lowerIndex){// while loop to check if data is found
            int midPoint = ((upperIndex - lowerIndex)/2) + lowerIndex;// calculating the mid point
            
            if(data[midPoint] == query){// checking if the data is found
                found = true;// flag to check if data is found
                System.out.println("Data is found at: " + midPoint);
            }
            else if(data[midPoint] > query){// checking if the data is greater than the query
                upperIndex = midPoint-1;// decrementing the upper index
            }
            else{
                lowerIndex = midPoint+1;// decrementing the lower index
            }
        }
        
        if(!found){// if the data is not found
            System.out.println("Data is not in the array");
        }
    }

    static void printData(int data[]){// printing the data
        for(int d : data){// printing the data
            System.out.print(d + ", ");// printing the data
        }
    }

    static void sortData(int data[]){// sorting the data
        // sorting : bubblesort
        for(int i=0; i<data.length; i++){// for loop to sort the data
            for(int j=0; j<data.length; j++){// for loop to sort the data
                if(data[i] < data[j]){// checking if the data is greater than the query
                    int temp= data[i];// assigning the data to temp
                    data[i] = data[j];// assigning the data to the query
                    data[j] = temp;// assigning the data to the query
                }
            }
        }
    }
}
