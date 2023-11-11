import pandas as pd
import mysql.connector

# Retrieve data from a CSV file
data_url = 'data.json'
df = pd.read_csv(data_url)

# Establish a MySQL connection
conn = mysql.connector.connect(
    host='127.0.0.1',
    user='root',
    password='0723524754Aa.',
    database='test'
)

# Create a cursor object
cursor = conn.cursor()

# Insert data into LocationDim table
for index, row in df.iterrows():
    cursor.execute("""
        INSERT INTO LocationDim (LocationID, ZipCode, City, Country)
        VALUES (%s, %s, %s, %s)
    """% (row['LocationID'], row['ZipCode'], row['City'], row['Country']))

# Commit the changes
conn.commit()

# Close the cursor and connection
cursor.close()
conn.close()



