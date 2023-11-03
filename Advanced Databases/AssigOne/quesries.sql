Certainly, here are ten example queries that you can run on the provided tables:

--**Query 1:** Retrieve a list of students who attended Module A in January 2023, including their names, attendance status, and performance scores.

SELECT s.StudentName, f.AttendanceStatus, f.PerformanceScore
FROM TrainingAttendanceFact f
JOIN StudentDim s ON f.StudentKey = s.StudentKey
JOIN ModuleDim m ON f.ModuleKey = m.ModuleKey
JOIN TimeDim t ON f.TimeKey = t.TimeKey
WHERE m.ModuleName = 'Module A' AND t.Month = 'January' AND t.Year = 2023;


--**Query 2:** Calculate the average performance score for Module B across all time periods.

SELECT m.ModuleName, AVG(f.PerformanceScore) AS AveragePerformanceScore
FROM TrainingAttendanceFact f
JOIN ModuleDim m ON f.ModuleKey = m.ModuleKey
GROUP BY m.ModuleName
HAVING m.ModuleName = 'Module B';


--**Query 3:** List instructors and their email addresses who had the highest attendance rates in the year 2023.

SELECT i.InstructorName, i.InstructorEmail
FROM TrainingAttendanceFact f
JOIN InstructorDim i ON f.InstructorKey = i.InstructorKey
JOIN TimeDim t ON f.TimeKey = t.TimeKey
WHERE t.Year = 2023
GROUP BY i.InstructorName, i.InstructorEmail
HAVING COUNT(*) = (SELECT MAX(AttendanceCount) FROM (SELECT COUNT(*) AS AttendanceCount FROM TrainingAttendanceFact GROUP BY InstructorKey) AS T);


--**Query 4:** Find the location with the lowest utilization in terms of the number of training sessions held.

SELECT l.LocationName, COUNT(*) AS TrainingSessionCount
FROM TrainingAttendanceFact f
JOIN LocationDim l ON f.LocationKey = l.LocationKey
GROUP BY l.LocationName
ORDER BY TrainingSessionCount ASC
LIMIT 1;


--**Query 5:** Retrieve a list of students who have not attended any training sessions.

SELECT s.StudentName
FROM StudentDim s
LEFT JOIN TrainingAttendanceFact f ON s.StudentKey = f.StudentKey
WHERE f.StudentKey IS NULL;


--**Query 6:** Find the modules with the highest average performance scores.

SELECT m.ModuleName, AVG(f.PerformanceScore) AS AveragePerformanceScore
FROM TrainingAttendanceFact f
JOIN ModuleDim m ON f.ModuleKey = m.ModuleKey
GROUP BY m.ModuleName
ORDER BY AveragePerformanceScore DESC;


--**Query 7:** List instructors and their average performance scores.

SELECT i.InstructorName, AVG(f.PerformanceScore) AS AveragePerformanceScore
FROM TrainingAttendanceFact f
JOIN InstructorDim i ON f.InstructorKey = i.InstructorKey
GROUP BY i.InstructorName;


--**Query 8:** Identify students with the best and worst overall performance scores.

SELECT s.StudentName, MAX(f.PerformanceScore) AS MaxPerformanceScore, MIN(f.PerformanceScore) AS MinPerformanceScore
FROM TrainingAttendanceFact f
JOIN StudentDim s ON f.StudentKey = s.StudentKey
GROUP BY s.StudentName;


--**Query 9:** Find the most popular training location (the location with the highest attendance).

SELECT l.LocationName, COUNT(*) AS AttendanceCount
FROM TrainingAttendanceFact f
JOIN LocationDim l ON f.LocationKey = l.LocationKey
GROUP BY l.LocationName
ORDER BY AttendanceCount DESC
LIMIT 1;


--**Query 10:** Retrieve a list of modules along with the names of the students who achieved a perfect score (100) in those modules.

SELECT m.ModuleName, s.StudentName
FROM TrainingAttendanceFact f
JOIN ModuleDim m ON f.ModuleKey = m.ModuleKey
JOIN StudentDim s ON f.StudentKey = s.StudentKey
WHERE f.PerformanceScore = 100;
