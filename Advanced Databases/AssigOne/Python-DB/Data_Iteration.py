import pandas as pd
import mysql.connector
#pip install pandas, mysql-connector

# All the files are JSON files
time_df = pd.read_json('TimeDim.json')
institution_df = pd.read_json('InstitutionDim.json')
module_df = pd.read_json('ModuleDim.json')
student_df = pd.read_json('StudentDim.json')
training_fact_df = pd.read_json('TrainingFact.json')

# Establish a MySQL connection
conn = mysql.connector.connect(
    host='127.0.0.1',
    user='root',
    password='0723524754Aa.',
    database='Assig'
)

# Create a cursor object
cursor = conn.cursor()

#Running five for loops to enter the data to each table in MySQL database

# Insert data into TimeDim table with handling duplicates
for index, row in time_df.iterrows():
    try:
        cursor.execute("""
            INSERT INTO TimeDim (DateID, DimMonth, Dayoff, TrainingDays, DimQuarter, DimYear)
            VALUES (%s, %s, %s, %s, %s, %s)
        """, (row['DateID'], row['DimMonth'], row['Dayoff'], row['TrainingDays'], row['DimQuarter'], row['DimYear']))
    except mysql.connector.IntegrityError as e:
        print(f"Skipping duplicate entry for DateID {row['DateID']}")

# Insert data into InstitutionDim table with handling duplicates
for index, row in institution_df.iterrows():
    try:
        cursor.execute("""
            INSERT INTO InstitutionDim (InstitutionID, InstitutionName, AmountOfStuff, OpenTime, CloseTime, Address, InstitutionEmail)
            VALUES (%s, %s, %s, %s, %s, %s, %s)
        """, (row['InstitutionID'], row['InstitutionName'], row['AmountOfStuff'], row['OpenTime'], row['CloseTime'], row['Address'], row['InstitutionEmail']))
    except mysql.connector.IntegrityError as e:
        print(f"Skipping duplicate entry for InstitutionID {row['InstitutionID']}")

# Insert data into ModuleDim table with handling duplicates
for index, row in module_df.iterrows():
    try:
        cursor.execute("""
            INSERT INTO ModuleDim (ModuleID, ModuleName, ModuleDescription, ModuleStartDate, ModuleEndDate)
            VALUES (%s, %s, %s, %s, %s)
        """, (row['ModuleID'], row['ModuleName'], row['ModuleDescription'], row['ModuleStartDate'], row['ModuleEndDate']))
    except mysql.connector.IntegrityError as e:
        print(f"Skipping duplicate entry for ModuleID {row['ModuleID']}")

# Insert data into StudentDim table with handling duplicates
for index, row in student_df.iterrows():
    try:
        cursor.execute("""
            INSERT INTO StudentDim (StudentID, StudentName, StudentAge, StudentGender, StudentEmail)
            VALUES (%s, %s, %s, %s, %s)
        """, (row['StudentID'], row['StudentName'], row['StudentAge'], row['StudentGender'], row['StudentEmail']))
    except mysql.connector.IntegrityError as e:
        print(f"Skipping duplicate entry for StudentID {row['StudentID']}")

# Insert data into TrainingFact table with handling duplicates
for index, row in training_fact_df.iterrows():
    try:
        cursor.execute("""
            INSERT INTO TrainingFact (StudentID, InstitutionID, DateID, ModuleID, PerformaceScore, AttendaceScore, DropoutPercentage)
            VALUES (%s, %s, %s, %s, %s, %s, %s)
        """, (row['StudentID'], row['InstitutionID'], row['DateID'], row['ModuleID'], row['PerformaceScore'], row['AttendaceScore'], row['DropoutPercentage']))
    except mysql.connector.IntegrityError as e:
        print(f"Skipping duplicate entry for StudentID {row['StudentID']}, DateID {row['DateID']}, ModuleID {row['ModuleID']}")

# Commit the changes
conn.commit()

# Close the cursor and connection
cursor.close()
conn.close()