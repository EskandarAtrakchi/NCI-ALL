-- Create the StudentDim dimension table
CREATE TABLE StudentDim (
    StudentKey INT PRIMARY KEY,
    StudentID VARCHAR(10),
    StudentName VARCHAR(255),
    StudentAge INT,
    StudentGender CHAR(1),
    StudentContact VARCHAR(255)
);

-- Create the ModuleDim dimension table
CREATE TABLE ModuleDim (
    ModuleKey INT PRIMARY KEY,
    ModuleID VARCHAR(10),
    ModuleName VARCHAR(255),
    ModuleDescription VARCHAR(1000),
    ModuleLocation VARCHAR(255),
    ModuleInstructor VARCHAR(255),
    ModuleStartDate DATE,
    ModuleEndDate DATE
);

-- Create the TimeDim dimension table
CREATE TABLE TimeDim (
    TimeKey INT PRIMARY KEY,
    Date DATE,
    Day VARCHAR(20),
    Month VARCHAR(20),
    Quarter CHAR(2),
    Year INT
);

-- Create the LocationDim dimension table
CREATE TABLE LocationDim (
    LocationKey INT PRIMARY KEY,
    LocationID VARCHAR(10),
    LocationName VARCHAR(255),
    Address VARCHAR(1000),
    City VARCHAR(255),
    State VARCHAR(255),
    Country VARCHAR(255)
);

-- Create the InstructorDim dimension table
CREATE TABLE InstructorDim (
    InstructorKey INT PRIMARY KEY,
    InstructorID VARCHAR(10),
    InstructorName VARCHAR(255),
    InstructorEmail VARCHAR(255),
    InstructorPhone VARCHAR(20)
);

-- Create the TrainingAttendanceFact fact table
CREATE TABLE TrainingAttendanceFact (
    StudentKey INT,
    ModuleKey INT,
    TimeKey INT,
    LocationKey INT,
    InstructorKey INT,
    AttendanceStatus VARCHAR(20),
    PerformanceScore DECIMAL(5, 2) -- Assuming 5 digits, 2 decimal places
);
