-- Indexes for other tables as needed based on query patterns
-- put comments here later 
SELECT
    M.ModuleName,
    T.DimMonth,
    T.DimYear,
    AVG(TF.AttendacePerformace) AS AveragePerformance,
    AVG(TF.AttendanceScore) AS AverageAttendance,
    COUNT(TF.TrainingFactID) AS TotalSessions
FROM
    TrainingFact AS TF
    JOIN ModuleDim AS M ON TF.ModuleID = M.ModuleID
    JOIN TimeDim AS T ON TF.DateID = T.DateID
GROUP BY
    M.ModuleName,
    T.DimMonth,
    T.DimYear
ORDER BY
    T.DimYear, T.DimMonth, M.ModuleName;