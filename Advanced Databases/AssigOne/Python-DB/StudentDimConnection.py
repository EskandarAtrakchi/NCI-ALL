import pandas as pd
import mysql.connector

data_url = 'StudentDim.json'
df = pd.read_json(data_url)
print(df)

# Establish a MySQL connection
conn = mysql.connector.connect(
    host='127.0.0.1',
    user='root',
    password='0723524754Aa.',
    database='test'
)

# Create a cursor object
cursor = conn.cursor()

# Insert data into StudentDim table with handling duplicates
for index, row in df.iterrows():
    try:
        cursor.execute("""
            INSERT INTO StudentDim (StudentID, StudentName, StudentAge, StudentGender, StudentEmail)
            VALUES (%s, %s, %s, %s, %s)
        """, (row['StudentID'], row['StudentName'], row['StudentAge'], row['StudentGender'], row['StudentEmail']))
    except mysql.connector.IntegrityError as e:
        print(f"Skipping duplicate entry for StudentID {row['StudentID']}")

# Commit the changes
conn.commit()

# Close the cursor and connection
cursor.close()
conn.close()