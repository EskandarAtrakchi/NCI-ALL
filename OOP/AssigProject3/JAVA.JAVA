// Parent class for User Profiles
class UserProfile {
    protected int patientId;
    protected String patientFirstName;
    protected String patientLastName;
    protected int patientAge;

    public testingDeleteLater() {
    }

    public testingDeleteLater(int patientId, String patientFirstName, String patientLastName, int patientAge) {

        this.patientId = patientId;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientAge = patientAge;

    }

    public int getPatientId() {

        return patientId;

    }

    public void setPatientId(int patientId) {

        this.patientId = patientId;

    }

    public String getPatientFirstName() {

        return patientFirstName;

    }

    public void setPatientFirstName(String patientFirstName) {

        this.patientFirstName = patientFirstName;

    }

    public String getPatientLastName() {

        return patientLastName;

    }

    public void setPatientLastName(String patientLastName) {

        this.patientLastName = patientLastName;

    }

    public int getPatientAge() {

        return patientAge;

    }

    public void setPatientAge(int patientAge) {

        this.patientAge = patientAge;

    }

    // Additional methods related to user profiles can be added here
}

// Child class for Electronic Health Records (EHR)
class ElectronicHealthRecord extends UserProfile {

    private String alergies;
    private String currentMedication;
    private String medicalHistory;

    public testingDeleteLater() {
    }

    public testingDeleteLater(String alergies, String currentMedication, String medicalHistory) {
    
        this.alergies = alergies;
        this.currentMedication = currentMedication;
        this.medicalHistory = medicalHistory;
    
    }

    public String getAlergies() {
    
        return alergies;
    
    }

    public void setAlergies(String alergies) {
    
        this.alergies = alergies;
    
    }

    public String getCurrentMedication() {
    
        return currentMedication;
    
    }

    public void setCurrentMedication(String currentMedication) {
    
        this.currentMedication = currentMedication;
    
    }

    public String getMedicalHistory() {
    
        return medicalHistory;
    
    }

    public void setMedicalHistory(String medicalHistory) {
    
        this.medicalHistory = medicalHistory;
    
    }

    // Additional methods related to EHR can be added here
}

// Child class for Appointment Scheduling System
class Appointment extends UserProfile {

    private String time;
    private String date;
    private String contactNumber;
    private String doctorName;

    public testingDeleteLater() {
    }

    public testingDeleteLater(String time, String date, String contactNumber, String doctorName) {

        this.time = time;
        this.date = date;
        this.contactNumber = contactNumber;
        this.doctorName = doctorName;

    }

    public String getTime() {

        return time;

    }

    public void setTime(String time) {

        this.time = time;

    }

    public String getDate() {

        return date;

    }

    public void setDate(String date) {

        this.date = date;

    }

    public String getContactNumber() {

        return contactNumber;

    }

    public void setContactNumber(String contactNumber) {

        this.contactNumber = contactNumber;

    }

    public String getDoctorName() {

        return doctorName;

    }

    public void setDoctorName(String doctorName) {

        this.doctorName = doctorName;

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

        
    }
}