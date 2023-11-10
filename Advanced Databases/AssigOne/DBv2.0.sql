-- Create InstructorDim table
CREATE TABLE InstructorDim (
    InstructorID INT PRIMARY KEY,
    InstructorName VARCHAR(255),
    InstructorEmail VARCHAR(255)
);

-- Insert sample values into InstructorDim
INSERT INTO InstructorDim (InstructorID, InstructorName, InstructorEmail)
VALUES
    (1, 'John Doe', 'john.doe@example.com'),
    (2, 'Jane Smith', 'jane.smith@example.com'),
    (3, 'Bob Johnson', 'bob.johnson@example.com');

-- Create LocationDim table
CREATE TABLE LocationDim (
    LocationID INT PRIMARY KEY,
    ZipCode VARCHAR(255),
    City VARCHAR(255),
    Country VARCHAR(255)
);

-- Insert sample values into LocationDim
INSERT INTO LocationDim (LocationID, ZipCode, City, Country)
VALUES
    (1, '12345', 'New York', 'USA'),
    (2, '54321', 'Los Angeles', 'USA'),
    (3, '98765', 'London', 'UK');

-- Create StudentDim table
CREATE TABLE StudentDim (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(255),
    StudentAge INT,
    StudentGender VARCHAR(255),
    StudentEmail VARCHAR(255)
);

-- Insert sample values into StudentDim
INSERT INTO StudentDim (StudentID, StudentName, StudentAge, StudentGender, StudentEmail)
VALUES
    (1, 'Alice Johnson', 20, 'Female', 'alice@example.com'),
    (2, 'Bob Smith', 25, 'Male', 'bob@example.com'),
    (3, 'Eve Davis', 22, 'Female', 'eve@example.com');

-- Create TrainingFact table
CREATE TABLE TrainingFact (
    TrainingFactID INT PRIMARY KEY,
    InstructorID INT,
    StudentID INT,
    InstitutionID INT,
    LocationID INT,
    DateID INT,
    ModuleID INT,
    AttendacePerformace INT,
    AttendanceScore INT,
    ModuleFees FLOAT
);

-- Insert sample values into TrainingFact
INSERT INTO TrainingFact (TrainingFactID, InstructorID, StudentID, InstitutionID, LocationID, DateID, ModuleID, AttendacePerformace, AttendanceScore, ModuleFees)
VALUES
    (1, 1, 1, 1, 1, 1, 1, 90, 95, 1500.00),
    (2, 2, 2, 2, 2, 2, 2, 85, 88, 1800.00),
    (3, 3, 3, 3, 3, 3, 3, 92, 96, 1600.00);

-- Create InstitutionDim table
CREATE TABLE InstitutionDim (
    InstitutionID INT PRIMARY KEY,
    InstitutionName VARCHAR(255),
    AmountOfStuff INT,
    OpenTime VARCHAR(255),
    CloseTime VARCHAR(255),
    InstitutionAddress VARCHAR(255),
    InstitutionEmail VARCHAR(255)
);

-- Insert sample values into InstitutionDim
INSERT INTO InstitutionDim (InstitutionID, InstitutionName, AmountOfStuff, OpenTime, CloseTime, InstitutionAddress, InstitutionEmail)
VALUES
    (1, 'ABC University', 100, '08:00 AM', '06:00 PM', '123 Main St, City', 'contact@abcuniversity.com'),
    (2, 'XYZ College', 50, '09:00 AM', '05:00 PM', '456 Elm St, Town', 'info@xyzcollege.edu');

-- Create TimeDim table
CREATE TABLE TimeDim (
    DateID INT PRIMARY KEY,
    DimMonth VARCHAR(20),
    Dayoff INT,
    TrainingDays INT,
    DimQuarter CHAR(2),
    DimYear CHAR(2)
);

-- Insert sample values into TimeDim
INSERT INTO TimeDim (DateID, DimMonth, Dayoff, TrainingDays, DimQuarter, DimYear)
VALUES
    (1, 'January', 0, 22, 'Q1', '22'),
    (2, 'February', 2, 20, 'Q1', '22'),
    (3, 'March', 0, 21, 'Q1', '22');

-- Create ModuleDim table
CREATE TABLE ModuleDim (
    ModuleID INT PRIMARY KEY,
    ModuleName VARCHAR(255),
    ModuleDescription VARCHAR(1000),
    ModuleStartDate DATE,
    ModuleEndDate DATE
    Country VARCHAR(255)
);

-- Insert sample values into ModuleDim
INSERT INTO ModuleDim (ModuleID, ModuleName, ModuleDescription, ModuleStartDate, ModuleEndDate)
VALUES
    (1, 'Introduction to Programming', 'Learn the basics of programming.', '2023-01-15', '2023-02-15'),
    (2, 'Database Management', 'Explore database concepts and SQL.', '2023-02-20', '2023-03-20'),
    (3, 'Web Development', 'Create dynamic web applications.', '2023-03-25', '2023-04-25');

