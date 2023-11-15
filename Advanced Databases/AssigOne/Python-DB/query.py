import pandas as pd
import mysql.connector
from sqlalchemy import create_engine
#pip install sqlalchemy

# Establish a MySQL connection
conn = mysql.connector.connect(
    host='127.0.0.1',
    user='root',
    password='0723524754Aa.',
    database='Assig'
)

# Create a SQLAlchemy engine using the MySQL connection
engine = create_engine('mysql+mysqlconnector://root:0723524754Aa.@127.0.0.1/Assig')

# Execute the SQL query and load the result into a Pandas DataFrame
query = """
    SELECT
        StudentName,
        PerformaceScore
    FROM
        StudentDim s
    JOIN
        TrainingFact t ON s.StudentID = t.StudentID;
"""
df = pd.read_sql_query(query, engine)

# Close the MySQL connection
conn.close()

# Plot the data
plt.figure(figsize=(10, 6))
plt.bar(df['StudentName'], df['PerformaceScore'], color='skyblue')
plt.xlabel('Student Name')
plt.ylabel('Performance Score')
plt.title('Performance Scores for Students')
plt.xticks(rotation=45, ha='right')  # there is code in Stackoverflow which shows the rotation for better readablility 
plt.show()
