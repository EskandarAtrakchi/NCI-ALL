import mysql.connector
import time

# Establish a MySQL connection
conn = mysql.connector.connect(
    host='127.0.0.1',
    user='root',
    password='0723524754Aa.',
    database='Eskandar'
)

cursor = conn.cursor()

sql_code = """
    SELECT
        StudentName,
        PerformaceScore
    FROM
        StudentDim s
    JOIN
        TrainingFact t ON s.StudentID = t.StudentID;
"""

# Measure execution time
start_time = time.time()

# Execute the SQL code
cursor.execute(sql_code)

# Fetch the results if needed
result = cursor.fetchall()

# Commit the changes if there are any changes
conn.commit()

# Calculate the execution time
end_time = time.time()
execution_time = end_time - start_time

print(f"Execution time: {execution_time} seconds")

# Close the connection
conn.close()

