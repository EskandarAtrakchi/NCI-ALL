#Import numpy as np
import numpy as np
#----------------------------------------------------------------
def LinearSearch(data, query):
    index = 0 #index of the item in the array to search 
    found = False # True if the query is a linear search
    for item in data: # search for the item
        if (item == query): # if the item is found
            print('found at position ' , index)
            found = True # set found to true
            break #break the loop
        index+=1# index of the item to search
        
    if (found == False): # 
        print('not found')

def BinarySearch(data, query):
    lowerBound = 0
    upperBound = len(data)
    
    notFound = True# True if the query is not found
    foundIndex = -1 # index
    
    while (notFound and lowerBound <= upperBound):
        mid = (upperBound - lowerBound)//2 + lowerBound
        if (data[mid] == query): # if the item is found
            notFound = False # set notFound to false
            foundIndex = mid # set the found index to the mid value
            
        elif (data[mid] > query): # if the item is greater than the query
            upperBound = mid - 1 # set the upper bound to the mid value
                
        else: 
            lowerBound = mid + 1 # set the lower bound to the mid value
            
    print('found at position ', foundIndex)
        
myRandoms = np.random.randint(1000, size=100) # create an array of random integers
myRandoms[50] = 500 # set the item at index 50 to be 500
sorted_randoms = np.sort(myRandoms) # sort the array
print(sorted_randoms)
BinarySearch(sorted_randoms, query=500) # run the binary search