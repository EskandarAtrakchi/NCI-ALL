/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package healthconnect;
import java.io.Serializable;
/**
 *
 * @author joshuatupas
 */

public class MentalHealth implements Serializable{
    protected int patientId;
    protected String currentMood;
    protected String symptom;
    protected String severity;

    public MentalHealth() {
    }

    public MentalHealth(int patientId, String currentMood, String symptom, String severity) {
        this.patientId = patientId;
        this.currentMood = currentMood;
        this.symptom = symptom;
        this.severity = severity;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getCurrentMood() {
        return currentMood;
    }

    public void setCurrentMood(String currentMood) {
        this.currentMood = currentMood;
    }

    public String getSymptom() {
        return symptom;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }


    public void setSeverity(String severity) {
        this.severity = severity;
    }

}


