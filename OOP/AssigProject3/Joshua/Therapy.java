/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package healthconnect;

/**
 *
 * @author joshuatupas
 */
public class Therapy extends MentalHealth {
    private String category;
    private String duration;

    public Therapy() {
    }

    public Therapy(int patientId, String currentMood, String symptom, String severity, String category, String duration) {
        super(patientId, currentMood, symptom, severity);
        this.category = category;
        this.duration = duration;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Therapy - \n" + "Patient ID: " + getPatientId() + ",    Current Mood: " + getCurrentMood() + ",     Symptom: " + getSymptom() + 
                ",      Severity: " + getSeverity() + ",     Category: " + category + ",     Duration: " + duration;
    }
}