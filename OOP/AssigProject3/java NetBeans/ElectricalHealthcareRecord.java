package healthconnect;

/**
 *
 * @author Eskandar Atrakchi
 */
public class ElectricalHealthcareRecord extends UserProfile {
    
    private String alergies;
    private String currentMedication;
    private String medicalHistory;

    public ElectricalHealthcareRecord() {
    }
    
    public ElectricalHealthcareRecord(String alergies, String currentMedication, String medicalHistory, int patientId, String patientFirstName, String patientLastName, String patientAddress, int patientAge, String patientPassword) {
        super(patientId, patientFirstName, patientLastName, patientAddress, patientAge, patientPassword);
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

    @Override
    public String toString() {
        return "ElectricalHealthcareRecord { " + "alergies=" + alergies + ", currentMedication=" + currentMedication + ", medicalHistory=" + medicalHistory + '}';
    }
}
