CREATE TABLE UserProfile (
    patientId INT PRIMARY KEY,
    patientFirstName VARCHAR(255),
    patientLastName VARCHAR(255),
    patientAddress VARCHAR(255),
    patientAge INT,
    patientPassword VARCHAR(255)
);

-------------------------------

-- Insert data into UserProfile table
INSERT INTO UserProfile (patientId, patientFirstName, patientLastName, patientAddress, patientAge, patientPassword)
VALUES
(1, 'John', 'Doe', '123 Main Street', 30, 'password123'),
(2, 'Jane', 'Smith', '456 Oak Avenue', 25, 'securepass'),
(3, 'Bob', 'Johnson', '789 Pine Road', 40, 'pass123');


-------------------------------

CREATE TABLE ElectricalHealthcareRecord (
    patientId INT PRIMARY KEY,
    alergies VARCHAR(255),
    currentMedication VARCHAR(255),
    medicalHistory VARCHAR(255),
    FOREIGN KEY (patientId) REFERENCES UserProfile(patientId)
);

-------------------------------

-- Insert data into ElectricalHealthcareRecord table
INSERT INTO ElectricalHealthcareRecord (patientId, alergies, currentMedication, medicalHistory)
VALUES
(1, 'None', 'Aspirin', 'No significant history'),
(2, 'Pollen', 'Antihistamines', 'Asthma'),
(3, 'Penicillin', 'None', 'High blood pressure');

-------------------------------

CREATE TABLE Appointment (
    appointmentId INT PRIMARY KEY,
    patientId INT,
    date VARCHAR(255),
    contactNumber VARCHAR(255),
    doctorName VARCHAR(255),
    FOREIGN KEY (patientId) REFERENCES UserProfile(patientId)
);

-------------------------------

-- Insert data into Appointment table
INSERT INTO Appointment (appointmentId, patientId, date, contactNumber, doctorName)
VALUES
(1, 1, '2023-01-15', '555-1234', 'Dr. Smith'),
(2, 2, '2023-02-20', '555-5678', 'Dr. Jones'),
(3, 1, '2023-03-10', '555-4321', 'Dr. Johnson');