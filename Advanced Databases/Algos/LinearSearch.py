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

myRandoms = np.random.randint(1000, size=100)

print (myRandoms)

myRandoms[50] = 500

LinearSearch(myRandoms, 500)


#sort_randoms = np.sort(myRandoms)

#print (sort_randoms)