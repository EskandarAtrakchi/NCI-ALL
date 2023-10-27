// Parent class for User Profiles
class UserProfile {
    private String username;
    private String password;
    private String fullName;

    public UserProfile(String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    // Getters and setters for user profile attributes
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    // Additional methods related to user profiles can be added here
}

// Child class for Electronic Health Records (EHR)
class ElectronicHealthRecord extends UserProfile {
    private String medicalHistory;
    private String currentMedications;

    public ElectronicHealthRecord(String username, String password, String fullName, String medicalHistory, String currentMedications) {
        super(username, password, fullName);
        this.medicalHistory = medicalHistory;
        this.currentMedications = currentMedications;
    }

    // Getters and setters for EHR attributes
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public String getCurrentMedications() {
        return currentMedications;
    }

    // Additional methods related to EHR can be added here
}

// Child class for Appointment Scheduling System
class Appointment extends UserProfile {
    private String doctorUsername;
    private String dateAndTime;

    public Appointment(String username, String doctorUsername, String dateAndTime) {
        super(username, "", ""); // Password and full name can be empty or null for appointments.
        this.doctorUsername = doctorUsername;
        this.dateAndTime = dateAndTime;
    }

    // Getters and setters for appointment attributes
    public String getDoctorUsername() {
        return doctorUsername;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    // Additional methods related to appointment scheduling can be added here
}

public class Main {
    public static void main(String[] args) {
        // Example usage of the classes

        // Create a user profile
        UserProfile user1 = new UserProfile("john_doe", "password123", "John Doe");

        // Create an electronic health record for the user
        ElectronicHealthRecord ehr1 = new ElectronicHealthRecord("john_doe", "password123", "John Doe", "No major illnesses", "Aspirin, 81mg daily");

        // Create an appointment
        Appointment appointment1 = new Appointment("john_doe", "dr_smith", "2023-10-30 10:00 AM");

        // You can perform various operations with these objects as needed.
    }
}
