/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package healthconnect;

/**
 *
 * @author joshuatupas
 */
// Medication has inheritance from MentalHealth
public class Medication extends MentalHealth {
    // Declare variables
    private String medicine;
    private String dosage;

    // Constructor for Medication with calling constructor from MentalHealth parent class 
    public Medication(int patientId, String currentMood, String symptom, String severity, String medicine, String dosage) {
        super(patientId, currentMood, symptom, severity);
        this.medicine = medicine;
        this.dosage = dosage;
    }

    // Getter and Setter methods for medicine and dosage variables
    public String getMedicine() {
        return medicine;
    }
    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    //override the toString method and return the values
    @Override
    public String toString() {
        return "Medication - \n" + "Patient ID: " + getPatientId() +",     Current Mood: " + getCurrentMood() +",       Symptom: " + getSymptom() +",       Severity: " + getSeverity() +
               ",       Medicine: " + medicine +",      Dosage: " + dosage;
    }
}
