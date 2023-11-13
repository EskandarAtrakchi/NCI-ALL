-- Create an index on StudentID in the StudentDim table
CREATE INDEX idx_StudentDim_StudentID ON StudentDim (StudentID);

-- Create an index on StudentID in the TrainingFact table
CREATE INDEX idx_TrainingFact_StudentID ON TrainingFact (StudentID);