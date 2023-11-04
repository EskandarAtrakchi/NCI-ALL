-----------------------------------------------------------------------------------
--  1. Retrieve the names and ages of all students:
-----------------------------------------------------------------------------------

SELECT StudentName, StudentAge FROM StudentDim;

-----------------------------------------------------------------------------------
--  2. List all modules and their descriptions:
-----------------------------------------------------------------------------------

SELECT ModuleName, ModuleDescription FROM ModuleDim;

-----------------------------------------------------------------------------------
--  3. Find the instructors for each module:
-----------------------------------------------------------------------------------

SELECT ModuleName, ModuleInstructor FROM ModuleDim;

-----------------------------------------------------------------------------------
--  4. Get a list of students who attended training:
-----------------------------------------------------------------------------------

SELECT StudentName FROM StudentDim
WHERE StudentKey IN (SELECT StudentKey FROM TrainingAttendanceFact WHERE AttendanceStatus = true);

-----------------------------------------------------------------------------------
--  5. Find the total number of students in each location:
-----------------------------------------------------------------------------------

SELECT LocationName, COUNT(StudentKey) AS TotalStudents
FROM LocationDim
JOIN TrainingAttendanceFact ON LocationDim.LocationKey = TrainingAttendanceFact.LocationKey
GROUP BY LocationName;

-----------------------------------------------------------------------------------
--  6. Retrieve the modules with their start and end dates in the first quarter of 2023:
-----------------------------------------------------------------------------------

SELECT ModuleName, ModuleStartDate, ModuleEndDate
FROM ModuleDim
WHERE ModuleStartDate BETWEEN '2023-01-01' AND '2023-03-31';

-----------------------------------------------------------------------------------
--  7. Find the average performance score for all students:
-----------------------------------------------------------------------------------

SELECT AVG(PerformanceScore) AS AveragePerformanceScore FROM TrainingAttendanceFact;

-----------------------------------------------------------------------------------
--  8. List the instructors who have students attending training and their contact information:
-----------------------------------------------------------------------------------

SELECT DISTINCT i.InstructorName, i.InstructorEmail, i.InstructorPhone
FROM InstructorDim i
JOIN TrainingAttendanceFact t ON i.InstructorKey = t.InstructorKey;

-----------------------------------------------------------------------------------
--  9. Count the number of students who attended training for each module:
-----------------------------------------------------------------------------------

SELECT ModuleName, COUNT(StudentKey) AS AttendanceCount
FROM ModuleDim m
LEFT JOIN TrainingAttendanceFact t ON m.ModuleKey = t.ModuleKey
WHERE AttendanceStatus = true
GROUP BY ModuleName;

-----------------------------------------------------------------------------------
--  10. Retrieve the students who attended training on a specific date and their performance scores:
-----------------------------------------------------------------------------------

SELECT s.StudentName, t.PerformanceScore
FROM StudentDim s
JOIN TrainingAttendanceFact t ON s.StudentKey = t.StudentKey
JOIN TimeDim tm ON t.TimeKey = tm.TimeKey
WHERE tm.DimDate = '2023-03-10';