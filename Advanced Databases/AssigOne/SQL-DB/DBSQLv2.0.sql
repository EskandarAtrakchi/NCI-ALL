-- Create StudentDim table
CREATE TABLE StudentDim (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(255),
    StudentAge INT,
    StudentGender VARCHAR(255),
    StudentEmail VARCHAR(255)
);

-- Insert data into StudentDim table
INSERT INTO StudentDim (StudentID, StudentName, StudentAge, StudentGender, StudentEmail)
VALUES
    (1, 'John Doe', 20, 'Male', 'john.doe@example.com'),
    (2, 'Jane Smith', 22, 'Female', 'jane.smith@example.com');

-- Create TimeDim table
CREATE TABLE TimeDim (
    DateID INT PRIMARY KEY,
    DimMonth VARCHAR(20),
    Dayoff INT,
    TrainingDays INT,
    DimQuarter CHAR(2),
    DimYear INT
);

-- Insert data into TimeDim table
INSERT INTO TimeDim (DateID, DimMonth, Dayoff, TrainingDays, DimQuarter, DimYear)
VALUES
    (1, 'January', 1, 20, 'Q1', 2),
    (2, 'February', 2, 18, 'Q1', 2);

-- Create InstitutionDim table
CREATE TABLE InstitutionDim (
    InstitutionID INT PRIMARY KEY,
    InstitutionName VARCHAR(255),
    AmountOfStuff INT,
    OpenTime VARCHAR(255),
    CloseTime VARCHAR(255),
    Address VARCHAR(255),
    InstitutionEmail VARCHAR(255)
);

-- Insert data into InstitutionDim table
INSERT INTO InstitutionDim (InstitutionID, InstitutionName, AmountOfStuff, OpenTime, CloseTime, Address, InstitutionEmail)
VALUES
    (1, 'XYZ University', 500, '8:00 AM', '5:00 PM', '123 Main St', 'info@xyz.edu'),
    (2, 'ABC College', 300, '9:00 AM', '6:00 PM', '456 Oak St', 'info@abccollege.com');

-- Create ModuleDim table
CREATE TABLE ModuleDim (
    ModuleID INT PRIMARY KEY,
    ModuleName VARCHAR(255),
    ModuleDescription VARCHAR(1000),
    ModuleStartDate DATE,
    ModuleEndDate DATE
);

-- Insert data into ModuleDim table
INSERT INTO ModuleDim (ModuleID, ModuleName, ModuleDescription, ModuleStartDate, ModuleEndDate)
VALUES
    (1, 'Introduction to Programming', 'Learn the basics of programming', '2023-01-01', '2023-01-30'),
    (2, 'Database Management', 'Explore the world of databases', '2023-02-01', '2023-02-28');

-- Create TrainingFact table
CREATE TABLE TrainingFact (
    StudentID INT,
    InstitutionID INT,
    DateID INT,
    ModuleID INT,
    PerformaceScore INT,
    AttendaceScore INT,
    DropoutPercentage FLOAT,
    FOREIGN KEY (StudentID) REFERENCES StudentDim(StudentID),
    FOREIGN KEY (InstitutionID) REFERENCES InstitutionDim(InstitutionID),
    FOREIGN KEY (DateID) REFERENCES TimeDim(DateID),
    FOREIGN KEY (ModuleID) REFERENCES ModuleDim(ModuleID)
);

-- Insert data into TrainingFact table
INSERT INTO TrainingFact (StudentID, InstitutionID, DateID, ModuleID, PerformaceScore, AttendaceScore, DropoutPercentage)
VALUES
    (1, 1, 1, 1, 90, 95, 5.0),
    (2, 2, 2, 2, 85, 90, 3.0);