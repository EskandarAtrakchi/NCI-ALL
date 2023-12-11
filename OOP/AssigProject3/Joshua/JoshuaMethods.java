/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package healthconnect;

/**
 *
 * @author joshuatupas
 */

import static healthconnect.JoshuaConnectUI.idTF;
import static healthconnect.JoshuaConnectUI.moodTF;
import static healthconnect.JoshuaConnectUI.symptomTF;
import static healthconnect.JoshuaConnectUI.severityCB;
import static healthconnect.JoshuaConnectUI.medicRB;
import static healthconnect.JoshuaConnectUI.therapyRB;
import static healthconnect.JoshuaConnectUI.medicineCB;
import static healthconnect.JoshuaConnectUI.typeCB;
import static healthconnect.JoshuaConnectUI.dosageCB;
import static healthconnect.JoshuaConnectUI.durationCB;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import static healthconnect.JoshuaConnectUI.displayTextArea;


public class JoshuaMethods {
    ArrayList<MentalHealth> mh = new ArrayList<>();

    //this method 
    void add(){
        int patientId = Integer.parseInt(idTF.getText());
        for (MentalHealth m : mh) {
            if (m.getPatientId() == patientId) {
                JOptionPane.showMessageDialog(null, "ID already exists.");
                return;
            }
        }
        String currentMood = moodTF.getText();
        String symptom = symptomTF.getText();
        String severity = (String) severityCB.getSelectedItem();
        String category = (String) typeCB.getSelectedItem();
        String duration = (String) durationCB.getSelectedItem();
        String medicine = (String) medicineCB.getSelectedItem();
        String dosage = (String) dosageCB.getSelectedItem();
        if (therapyRB.isSelected()) {
            Therapy therapy = new Therapy(patientId, currentMood, symptom, severity, category, duration);
            mh.add(therapy);
            displayTextArea.append(therapy.toString() + "\n");
        } else if (medicRB.isSelected()) {
            Medication medication = new Medication(patientId, currentMood, symptom, severity, medicine, dosage);
            mh.add(medication);
            displayTextArea.append(medication.toString() + "\n");
        }
                        JOptionPane.showMessageDialog(null, "Information Added.");
    }  
    void delete(){
        int patientId = Integer.parseInt(idTF.getText());
        for (MentalHealth m : mh) {
            if (m.getPatientId() == patientId) {
                mh.remove(m);
                JOptionPane.showMessageDialog(null, "Record removed.");
                String text = displayTextArea.getText();
                String removedRecord = m.toString() + "\n";
                text = text.replace(removedRecord, "");
                displayTextArea.setText(text);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No record found with the given patient ID.");
    }
    void display(){
        if (!displayTextArea.getText().isEmpty()) {
            displayTextArea.setText("");
        } else {
            for (MentalHealth m : mh){
                displayTextArea.append(m.toString() + "\n");
            }
        }
    }
    
    void search(){
        int patientId = Integer.parseInt(idTF.getText());
        for (MentalHealth m : mh){
            if (m.getPatientId() == patientId) {
                moodTF.setText(m.getCurrentMood());
                symptomTF.setText(m.getSymptom());
                severityCB.setSelectedItem(m.getSeverity());
                
                if (m instanceof Medication) {
                    Medication med = (Medication) m;
                    medicineCB.setSelectedItem(med.getMedicine());
                    dosageCB.setSelectedItem(med.getDosage());
                } else if (m instanceof Therapy) {
                    Therapy therapy = (Therapy) m;
                    typeCB.setSelectedItem(therapy.getCategory());
                    durationCB.setSelectedItem(therapy.getDuration());
                }
                JOptionPane.showMessageDialog(null, "ID found");
                break;
            } else {
                    JOptionPane.showMessageDialog(null, "ID not found");break;
            }
        }
    }

    void clear(){
        idTF.setText("");
        moodTF.setText("");
        symptomTF.setText("");
    }
    
    void fileWriter(){
        try {
            FileWriter writer = new FileWriter("Health.txt");
            for (MentalHealth health : mh) {
                writer.write(health.toString() + "\n");
            }
            writer.close();
                JOptionPane.showMessageDialog(null, "Patient Mental Health records printed to file!");
        } catch (IOException e) {
            System.out.println("Error coding to file.");
        }
    }
    
    void fileReader(){
        try {
            FileReader reader = new FileReader("Health.txt");
            BufferedReader br = new BufferedReader(reader);
            StringBuilder fileContents = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                fileContents.append(line).append("\n");
            }
            reader.close();

            JOptionPane.showMessageDialog(null, "Mental Health Records:\n" + fileContents.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading from file: " + e.getMessage());
        }
    }
     
}