--  indexes to enhance the preformance of the DB query

CREATE INDEX idx_TrainingFact_ModuleID ON TrainingFact (ModuleID);

CREATE INDEX idx_TrainingFact_DateID ON TrainingFact (DateID);

CREATE INDEX idx_TimeDim_DimMonth ON TimeDim (DimMonth);