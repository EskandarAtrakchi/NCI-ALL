import pandas as pd
import matplotlib.pyplot as plt
from sqlalchemy import create_engine
import mysql.connector


# Establish a MySQL connection
conn = mysql.connector.connect(
    host='127.0.0.1',
    user='root',
    password='0723524754Aa.',
    database='test'
)

# Create a SQLAlchemy engine using the MySQL connection
engine = create_engine('mysql+mysqlconnector://root:0723524754Aa.@127.0.0.1/test')

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

# Plot the data
plt.figure(figsize=(10, 6))
plt.bar(df['StudentName'], df['PerformaceScore'], color='skyblue')
plt.xlabel('Student Name')
plt.ylabel('Performance Score')
plt.title('Performance Scores for Students')
plt.show()