--  Table number ONE StudentDim
--  Create the StudentDim dimension table

CREATE TABLE StudentDim (
    StudentKey INT PRIMARY KEY,
    StudentID VARCHAR(10),
    StudentName VARCHAR(255),
    StudentAge INT,
    StudentGender CHAR(1),
    StudentContact VARCHAR(255)
);

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

-- Inserting values into StudentDim:


INSERT INTO StudentDim (StudentKey, StudentID, StudentName, StudentAge, StudentGender, StudentContact)
VALUES
(1, '1001', 'John Doe', 25, 'M', 'john@example.com'),
(2, '1002', 'Jane Smith', 22, 'F', 'jane@example.com'),
(3, '1003', 'Tom Brown', 28, 'M', 'tom@example.com');

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

--  Table number TWO ModuleDim
--  Create the ModuleDim dimension table

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

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

-- Inserting values into ModuleDim:


INSERT INTO ModuleDim (ModuleKey, ModuleID, ModuleName, ModuleDescription, ModuleLocation, ModuleInstructor, ModuleStartDate, ModuleEndDate)
VALUES
(101, '10001', 'ModuleA', 'DescriptionA', 'LocationA', 'InstructorA', '2023-01-15', '2023-02-15'),
(102, '10002', 'ModuleB', 'DescriptionB', 'LocationB', 'InstructorB', '2023-02-20', '2023-03-20'),
(103, '10003', 'ModuleC', 'DescriptionC', 'LocationC', 'InstructorC', '2023-03-01', '2023-03-31');

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

--  Table number THREE TimeDim
--  Create the TimeDim dimension table

CREATE TABLE TimeDim (
    TimeKey INT PRIMARY KEY,
    DimDate DATE,
    DimDay VARCHAR(20),
    DimMonth VARCHAR(20),
    Quarter CHAR(2),
    DimYear INT
);

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

-- Inserting values into TimeDim:


INSERT INTO TimeDim (TimeKey, DimDate, DimDay, DimMonth, Quarter, DimYear)
VALUES
(501, '2023-01-16', 'Monday', 'January', 'Q1', 2023),
(502, '2023-02-22', 'Wednesday', 'February', 'Q1', 2023),
(503, '2023-03-10', 'Friday', 'March', 'Q1', 2023);

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

--  Table number FOUR LocationDim
--  Create the LocationDim dimension table

CREATE TABLE LocationDim (
    LocationKey INT PRIMARY KEY,
    LocationID VARCHAR(10),
    LocationName VARCHAR(255),
    City VARCHAR(255),
    Country VARCHAR(255)
);

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

-- Inserting values into LocationDim:


INSERT INTO LocationDim (LocationKey, LocationID, LocationName, City, Country)
VALUES
(1001, 1, 'LocationA', 'CityA', 'CountryA'),
(1002, 2, 'LocationB', 'CityB', 'CountryB'),
(1003, 3, 'LocationC', 'CityC', 'CountryC');

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

--  Table number FIVE InstructorDim
--  Create the InstructorDim dimension table

CREATE TABLE InstructorDim (
    InstructorKey INT PRIMARY KEY,
    InstructorID VARCHAR(10),
    InstructorName VARCHAR(255),
    InstructorEmail VARCHAR(255),
    InstructorPhone VARCHAR(20)
);

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

-- Inserting values into InstructorDim:


INSERT INTO InstructorDim (InstructorKey, InstructorID, InstructorName, InstructorEmail, InstructorPhone)
VALUES
(201, 'I001', 'InstructorA', 'instructA@example.com', '+1234567890'),
(202, 'I002', 'InstructorB', 'instructB@example.com', '+9876543210'),
(203, 'I003', 'InstructorC', 'instructC@example.com', '+5555555555');

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

--  Table number SIX TrainingAttendanceFact 
--  Create the TrainingAttendanceFact fact table

CREATE TABLE TrainingAttendanceFact (
    StudentKey INT,
    ModuleKey INT,
    TimeKey INT,
    LocationKey INT,
    InstructorKey INT,
    AttendanceStatus BOOLEAN COMMENT 'true: attended, false: absent',
    PerformanceScore DECIMAL(5, 2) --  Assuming 5 digits, 2 decimal places
);

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

-- Inserting values into TrainingAttendanceFact:


INSERT INTO TrainingAttendanceFact (StudentKey, ModuleKey, TimeKey, LocationKey, InstructorKey, AttendanceStatus, PerformanceScore)
VALUES
(1, 101, 501, 1001, 201, true, 90),
(2, 102, 502, 1002, 202, false, 75),
(3, 103, 503, 1003, 203, true, 88);

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -