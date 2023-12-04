// Parent class for User Profiles
class UserProfile {
    protected int patientId;
    protected String patientFirstName;
    protected String patientLastName;
    protected int patientAge;

    public UserProfile() {
    }

    public UserProfile(int patientId, String patientFirstName, String patientLastName, int patientAge) {

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

    public ElectronicHealthRecord() {
    }

    public ElectronicHealthRecord(String alergies, String currentMedication, String medicalHistory) {
    
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

    public Appointment() {
    }

    public Appointment(String time, String date, String contactNumber, String doctorName) {

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

import java.util.ArrayList;

public class HealthConnectorUI {

    private ArrayList<UserProfile> userProfiles; // Store user profiles.
    private UserProfile currentUser; // Store the currently logged-in user.

    UserProfile u = new UserProfile();
    ElectronicHealthRecord e = nwe ElectronicHealthRecord();
    Appointment a = new Appointment();

    public HealthConnectorUI() {
        userProfiles = new ArrayList<>();
    }

    // User Registration
    public void register() {
        // Implement user registration logic here.
    }

    // User Login
    public void login() {
        // Implement user login logic here.
    }

    // User Search
    public void search() {
        // Implement user search logic here.
    }

    // User Deletion
    public void delete() {
        // Implement user deletion logic here.
    }

    // Booking an Appointment
    public void bookAppointment() {
        // Implement appointment booking logic here.
    }

    // Searching for Appointments
    public void searchForAppointment() {
        // Implement appointment search logic here.
    }

    // Deleting an Appointment
    public void deleteAppointment() {
        // Implement appointment deletion logic here.
    }

    // Adding an Electrical Healthcare Record (EHR)
    public void addEHR() {
        // Implement EHR addition logic here.
    }

    // Searching for EHRs
    public void searchEHR() {
        // Implement EHR search logic here.
    }

    // Deleting an EHR
    public void deleteEHR() {
        // Implement EHR deletion logic here.
    }
}
public class main {
    public static void main(String[] args) {
        HealthConnectorUI health = new HealthConnectorUI();
        //the required method to be called here
    }
}