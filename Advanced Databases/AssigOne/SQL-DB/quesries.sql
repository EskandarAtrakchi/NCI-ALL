SELECT
    StudentName,
    PerformaceScore
FROM
    StudentDim s
JOIN
    TrainingFact t ON s.StudentID = t.StudentID;
