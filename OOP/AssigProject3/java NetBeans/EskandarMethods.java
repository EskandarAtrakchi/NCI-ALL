package healthconnect;

import static healthconnect.EskandarConnectUI.EHRalergyTF;
import static healthconnect.EskandarConnectUI.EHRcurrentmedicationTF;
import static healthconnect.EskandarConnectUI.EHRidTF;
import static healthconnect.EskandarConnectUI.EHRmedicalhistoryTF;
import static healthconnect.EskandarConnectUI.appointmentidTF;
import static healthconnect.EskandarConnectUI.idTF;
import static healthconnect.EskandarConnectUI.noteidTF;
import static healthconnect.EskandarConnectUI.notesTA;
import static healthconnect.EskandarConnectUI.notesfromfileTA;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Eskandar Atrakchi
 */
public class EskandarMethods {
    //get connection by a static block to run first 
    //myConn will be the instance and will be used in all the methods to connect to mysql
    static Connection myConn = ConnectDB.getConnection();
    
    //ArrayList to save user data temporarly 
    //1. declaring the arraylist and then creating it as the brief says 
    //this arraylist will be responsible to store the data from mysql 
    private final ArrayList<UserProfile> userDataList;
    //this arraylist will be respinsible on only for patient notes, no connection with mysql
    private final ArrayList<DataNotes> textInfoList;
    //this arraylist will be resonsible for saving what should be written and read to a file 
    private ArrayList<DataNotes> alFile;
    
    public EskandarMethods () {//constructor
        //2. creating the arraylist 
        this.userDataList = new ArrayList<>();
        this.textInfoList = new ArrayList<>();
        this.alFile = new ArrayList<>();
    }
    
    //First notes arraylist 
    // Method number one to add text info to the ArrayList
    void addTextInfo(String text, int numberReference) {
        // Check if the numberReference is already in use
        //Checks if any existing DataNotes object in textInfoList has the same numberReference as the specified numberReference variable.
        //anyMatch() It's part of the Stream API and is used to check if any elements in a stream satisfy a given condition. //source stackoverflow
        boolean isDuplicate = textInfoList.stream().anyMatch(info -> info.getNumberReference() == numberReference);

        if (isDuplicate == true) {
            JOptionPane.showMessageDialog(null, "Duplicate numberReference. Cannot add text info.");
        } else {
            // If not a duplicate, add the new DataNotes object
            DataNotes newTextInfo = new DataNotes(text, numberReference);
            textInfoList.add(newTextInfo);
            JOptionPane.showMessageDialog(null, "Text info added: " + newTextInfo.toString());
        }
    }
    // Method number two to remove text info from the ArrayList based on number reference
    public void removeTextInfoByNumberReference(int numberReference) {
        DataNotes textInfoToRemove = null;
        for (DataNotes textInfo : textInfoList) {//for-each
            if (textInfo.getNumberReference() == numberReference) {
                textInfoToRemove = textInfo;
                break;//stoppp
            }
        }

        if (textInfoToRemove != null) {//if and else to determine 
            textInfoList.remove(textInfoToRemove);
            JOptionPane.showMessageDialog(null, "Text info removed: " + textInfoToRemove.toString());
        } else {//otherwise 
            JOptionPane.showMessageDialog(null, "Text info with number reference " + numberReference + " not found.");
        }
    }
    // Method number three to search for text info in the ArrayList based on number reference
    public void searchTextInfoByNumberReference(int numberReference) {
        for (DataNotes textInfo : textInfoList) {
            if (textInfo.getNumberReference() == numberReference) {
                JOptionPane.showMessageDialog(null, "Text info found: " + textInfo.toString());
                //because I want only one match
                return; // Stop searching after finding the first match
            }
        }
        //for any other reasons
        JOptionPane.showMessageDialog(null, "Text info with number reference " + numberReference + " not found.");
    }
    // Method number four to display all text info in the ArrayList
    public void displayAllTextInfo() {
        for (DataNotes textInfo : textInfoList) {
            JOptionPane.showMessageDialog(null,textInfo.toString());
        }
    }
    //method number five to store data to a file that ends in .dat
    //Frances Sheridan videos // source https://github.com/EskandarAtrakchi/NCI-YEAR-2-FIRST/tree/main/OOP/java/File%20i/o
    void notesToFile() {
        // file
        File f;
        // file writer
        FileOutputStream fs;
        // buffered writer
        ObjectOutputStream os;
        try {
            f = new File("log.dat");
            fs = new FileOutputStream(f);
            os = new ObjectOutputStream(fs);

            // Extract text from JTextArea
            String text = notesTA.getText();
            int numberReference = Integer.parseInt(noteidTF.getText());
            // Create a DataNotes object with the extracted text
            DataNotes dataNotes = new DataNotes(text, numberReference); //Emer said it is ok to pass them through the constructor

            // Add the DataNotes object to the list
            alFile.add(dataNotes);

            // Write the ArrayList to the file
            os.writeObject(alFile);
            os.close();

            notesTA.setText(null);
            notesfromfileTA.setText(null);
            notesTA.append("Saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e);
        }
    }
    //method number six to read from file that exists to textarea // source https://github.com/EskandarAtrakchi/NCI-YEAR-2-FIRST/tree/main/OOP/java/File%20i/o
    void readNotesFromFile() {
        // file
        File f;
        // file reader
        FileInputStream fis;
        // object input stream
        ObjectInputStream ois;
        try {
            f = new File("log.dat");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            alFile = (ArrayList<DataNotes>) ois.readObject();
            ois.close();
            notesTA.setText(null);
            notesTA.append("Read successfully.");

            // Show the content of the file in a text area 
            if (alFile.isEmpty()) {
            JOptionPane.showMessageDialog(null, "File is empty.", "File Content", JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder stringsIWantToAttach = new StringBuilder();
                for (DataNotes dataNotes : alFile) {
                    stringsIWantToAttach.append(dataNotes.toString()).append("\n");
                }
                // Append content to the JTextArea named notesfromfileTA
                notesfromfileTA.setText(stringsIWantToAttach.toString());
                notesfromfileTA.append("Read successfully.");
                noteidTF.setText(null);
                notesTA.setText(null);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading from file: " + e);
            // Show an error message if reading fails
            JOptionPane.showMessageDialog(null, "Error reading from file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //this method number five is to save logged in user data temporarly from mysql in the userDataList arraylist 
    void dataList () {
        try {
            // Get user profile from the database based on enteredPatientId
            int enteredPatientId = Integer.parseInt(idTF.getText());
            //The LEFT JOIN statement for both tables is to connect them all by patientid. // source stackoverflow https://stackoverflow.com/questions/42599450/left-join-sql-query
            //note to myself, come back to this query if the code does not work 
            String query = "SELECT UserProfile.*, Appointment.appointmentId, Appointment.date, " +
               "Appointment.contactNumber, Appointment.doctorName, " +
               "ElectricalHealthcareRecord.alergies, " +
               "ElectricalHealthcareRecord.currentMedication, " +
               "ElectricalHealthcareRecord.medicalHistory " +
               "FROM UserProfile " +
               "LEFT JOIN Appointment ON UserProfile.patientId = Appointment.patientId " +
               "LEFT JOIN ElectricalHealthcareRecord ON UserProfile.patientId = ElectricalHealthcareRecord.patientId " +
               "WHERE UserProfile.patientId = ?";

            try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
                preparedStatement.setInt(1, enteredPatientId);

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                // Check if there is a matching user profile
                if (resultSet.next()) {
                    // Map ResultSet to UserProfile object 
                    //the mapResultSetToUserProfile(resultSet) method is called and assiged to userProfile
                    UserProfile userProfile = mapResultSetToUserProfile(resultSet);

                    //Fetch additional data for Appointment from the database mysql
                    int appointmentId = resultSet.getInt("appointmentId");
                    String appointmentDate = resultSet.getString("date");
                    String contactNumber = resultSet.getString("contactNumber");
                    String doctorName = resultSet.getString("doctorName");

                    //Fetch additional data for ElectricalHealthcareRecord from the database 
                    String allergies = resultSet.getString("alergies");
                    String currentMedication = resultSet.getString("currentMedication");
                    String medicalHistory = resultSet.getString("medicalHistory");

                    // Create an instance of Appointment using the retrieved data
                    Appointment appointment = new Appointment(appointmentId, appointmentDate, contactNumber, doctorName,
                            userProfile.getPatientId(), userProfile.getPatientFirstName(), userProfile.getPatientLastName(),
                            userProfile.getPatientAddress(), userProfile.getPatientAge(), userProfile.getPatientPassword());

                    // Create an instance of ElectricalHealthcareRecord using the retrieved data
                    ElectricalHealthcareRecord electricalRecord = new ElectricalHealthcareRecord(allergies, currentMedication, medicalHistory,
                            userProfile.getPatientId(), userProfile.getPatientFirstName(), userProfile.getPatientLastName(),
                            userProfile.getPatientAddress(), userProfile.getPatientAge(), userProfile.getPatientPassword());

                    //add the records to the array list 
                    userDataList.add (userProfile);
                    userDataList.add (appointment);
                    userDataList.add (electricalRecord);
                    //now to display what is in the arraylist based on the patientid
                    for (Object obj : userDataList) {
                        //Object obj : userDataList, The keyword Object is a reference type in Java that is the root class of all other classes
                        if (obj instanceof UserProfile == true) {
                            UserProfile userProfileObj = (UserProfile) obj;
                            if (userProfileObj.getPatientId() == enteredPatientId) {
                                // Display UserProfile data
                                //because I am overriding the toString method in Appointment and EHR classes then it should retrieve everything 
                                JOptionPane.showMessageDialog(null, "This retrieval is from Arraylist to temporary store data for credentials and security purposes.\n" + userProfileObj.toString());
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No matching user profile found.");
                }
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    //start tab one login tab
    //method Number one  login user   metod 
    boolean loginUser(int enteredPatientId, String enteredPassword) {
        try {
            // Check if the connection is successful // source: https://stackoverflow.com/questions/7764671/java-jdbc-connection-status
            if (myConn != null && !myConn.isClosed()) {
                System.out.println("Connected to the database!");
                try {
                    // Retrieve user profile based on entered patientId
                    //the get user profile is returning  mapResultSetToUserProfile(ResultSet resultSet) and this will return the user data from mysql
                    UserProfile userProfile = getUserProfile(enteredPatientId);//database-related code is encapsulated within the getUserProfile method.
                    
                    if (userProfile != null && userProfile.getPatientPassword().equals(enteredPassword)) {
                        // User credentials are valid
                        JOptionPane.showMessageDialog(null, "Login successful!");
                        JOptionPane.showMessageDialog(null, "For credentials & security purposes, the user's details was stored in an ArrayList temporary!");
                        
                        //Manipulate the buttons
                        EskandarConnectUI.appointmentidTF.setText(String.valueOf(userProfile.getPatientId()));
                        EskandarConnectUI.EHRidTF.setText(String.valueOf(userProfile.getPatientId()));
                        
                        manipulateAfterLogIn ();// calling the method
                        return true;
                    } else {
                        // No matching user found or invalid password
                        JOptionPane.showMessageDialog(null , "invalid password");
                        return false;
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    return false;
                }
            } else {
                System.out.println("Failed to connect to the database.");
                JOptionPane.showMessageDialog(null , "Database connection server error! make sure your MySQL server connected.\nHow to solve this problem?\nMake sure you MySQL server is running and enter the correct data when you run the App.\nPlease colse the App now and try again when MySQL server is working.");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EskandarMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    // the loginUser method Number two now calls a new method getUserProfile, which retrieves the user profile from the database based on the entered patientId
    //this method will be used in the tabs buttons
    //the jobof this method is to retrieve the  mapResultSetToUserProfile(ResultSet resultSet) method which it returns the user data 
    UserProfile getUserProfile(int enteredPatientId) throws SQLException {
        String query = "SELECT * FROM UserProfile WHERE patientId = ?";
        try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
            preparedStatement.setInt(1, enteredPatientId);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if there is a matching user
            if (resultSet.next()) {
                // Map ResultSet to UserProfile object
                return mapResultSetToUserProfile(resultSet);
            } else {
                return null; // No matching user found
            }
        }
    }
    //mapResultSetToUserProfile method is responsible for converting a ResultSet into a UserProfile object to achieve encapsulation of OOP 
    //this method Number three will be used in the tabs buttons
    //the job of this method is to return an object of the users data that exist in mysql 
    UserProfile mapResultSetToUserProfile(ResultSet resultSet) throws SQLException {// source stackoverflow https://stackoverflow.com/questions/13970978/sql-resultset-in-java
        
        int patientId = resultSet.getInt("patientId");
        String patientFirstName = resultSet.getString("patientFirstName");
        String patientLastName = resultSet.getString("patientLastName");
        String patientAddress = resultSet.getString("patientAddress");
        int patientAge = resultSet.getInt("patientAge");
        String patientPassword = resultSet.getString("patientPassword");

        return new UserProfile(patientId, patientFirstName, patientLastName, patientAddress, patientAge, patientPassword);
    }
    //end method user  log in
    //start method Number four Display user 
    public void displayUserData(int patientId) {
        try {
            // Retrieve user profile based on entered patientId
            //userProfile returns mapResultSetToUserProfile(ResultSet resultSet) and this method returns user data from mysql
            UserProfile userProfile = getUserProfile(patientId);

            if (userProfile != null) {
                //Display user data using the UserProfile object
                System.out.println("User Information:");
                EskandarConnectUI.fnameTF.setText(userProfile.getPatientFirstName());
                EskandarConnectUI.lnameTF.setText(userProfile.getPatientLastName());
                EskandarConnectUI.addressTF.setText(userProfile.getPatientAddress());
                EskandarConnectUI.ageTF.setText(String.valueOf(userProfile.getPatientAge()));

                JOptionPane.showMessageDialog(null, "The data is populated successfully");
            } else {
                // No matching user found
                JOptionPane.showMessageDialog(null, "User not found. Please check your patientId.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//end display user  method 
    //method number five deleteUser
    boolean deleteUser(int patientId) throws SQLException {
        // Retrieve user profile based on entered patientId
        UserProfile userProfile = getUserProfile(patientId);

        if (userProfile != null) {
            // User found, proceed with deletion
            //confirm dialog is needed to confirm that the EHR will be deleted and the appointment will be deleted also
            int X = JOptionPane.showConfirmDialog(null, "If you have any Electrical Health Record with us will be deleted.\nIf you have any Appointment with us will be deleted.\nPlease confirm...", "User Confirmation Required Before Deletion!", JOptionPane.YES_NO_OPTION);
            
            if (X == 0) {
                //The error fixed here, was to delete the children first and then delete the parent.
                deleteAppointments(patientId);//child number one 
                deleteElectricalHealthcareRecord(patientId);//child number two 
                manipulateAfterLogOut ();
                JOptionPane.showMessageDialog(null, "the deletetion is successful");
            }
            // Create a prepared statement to execute the delete query for UserProfile
            String query = "DELETE FROM UserProfile WHERE patientId = ?";
            try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
                preparedStatement.setInt(1, patientId);

                // Execute the delete query for UserProfile
                int rowsAffected = preparedStatement.executeUpdate();
                
                //the number of rows that are effected should be more than zero which means true
                return rowsAffected > 0;//bigger than zero means true and in else statement should be false
            } //because the method is boolean, if I add a catch block a return statement will be required and that's not a good practice. // source CHATgpt
        } else {
            JOptionPane.showMessageDialog(null, "No matching user found");
            // No matching user found
            return false;
        }
    }
    //I need to delete the children first then delete the parent 
    //child one appointment method number six
    void deleteAppointments(int patientId) throws SQLException {
        // Create a prepared statement to execute the delete query for Appointments
        String appointmentQuery = "DELETE FROM Appointment WHERE patientId = ?";
        try (PreparedStatement appointmentStatement = myConn.prepareStatement(appointmentQuery)) {
            appointmentStatement.setInt(1, patientId);
            // Execute the delete query for Appointments
            appointmentStatement.executeUpdate();
        }
    }
    //child two EHR method number seven 
    void deleteElectricalHealthcareRecord(int patientId) throws SQLException {
        // Create a prepared statement to execute the delete query for Appointments
        String EHRQuery = "DELETE FROM ElectricalHealthcareRecord WHERE patientId = ?";
        try (PreparedStatement EHRStatement = myConn.prepareStatement(EHRQuery)) {
            EHRStatement.setInt(1, patientId);
            // Execute the delete query for ElectricalHealthcareRecord
            EHRStatement.executeUpdate();
        }
    }
    //method number eight update user info
    void updateUser(UserProfile updatedUserProfile) {
        try {
            // Create a prepared statement to execute the update query
            String query = "UPDATE UserProfile SET patientFirstName = ?, patientLastName = ?, patientAddress = ?, patientAge = ? WHERE patientId = ?";
            try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
                preparedStatement.setString(1, updatedUserProfile.getPatientFirstName());
                preparedStatement.setString(2, updatedUserProfile.getPatientLastName());
                preparedStatement.setString(3, updatedUserProfile.getPatientAddress());
                preparedStatement.setInt(4, updatedUserProfile.getPatientAge());
                preparedStatement.setInt(5, updatedUserProfile.getPatientId());

                // Execute the update query
                int rowsAffected = preparedStatement.executeUpdate();
                //rwo bigger than zero means true //source stackoverflow
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "User with patientId " + updatedUserProfile.getPatientId() + " updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "No user found with patientId " + updatedUserProfile.getPatientId() + ". Update failed.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//end method update user method 
    //start registeration  methods here method number nine 
    //I should run if statement that if the user exists or not in the first place before I register them 
    //I am trying to preven possible of duplicated IDs because that is a potential of system collaps 
    boolean userExists(int patientId) {
        // Check if a user with the same patientId already exists
        //The count word refers to the number of rows in the UserProfile table with a specific patientId in the database.
        String query = "SELECT COUNT(*) FROM UserProfile WHERE patientId = ?";
        try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
            preparedStatement.setInt(1, patientId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;//If the count is greater than 0, it means the user exists, and the method returns true; otherwise, it returns false
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error checking user existence: " + e.getMessage());
        }
        return false;
    }
    //I will call the method above and run f statement to make sure if the user exists or not before I register them 
    //method number 10 registerUser
    void registerUser(int patientId, String patientFirstName, String patientLastName, String patientAddress, int patientAge, String patientPassword) {try {
        //all the parameters are passed by the fields that the user enters when they want to register
        // Check if the connection is successful // source: https://stackoverflow.com/questions/7764671/java-jdbc-connection-status
        if (myConn != null && !myConn.isClosed()) {
            System.out.println("Connected to the database!");
            try {
                // Check if the chosen patientId already exists
                if (userExists(patientId) == true) {//call the method and pass value through the parameter
                    JOptionPane.showMessageDialog(null, "User with the chosen patientId already exists. Registration failed.");
                    return;
                }

                // Create a new UserProfile object and set the attributes
                UserProfile userProfile = new UserProfile();
                userProfile.setPatientId(patientId);
                userProfile.setPatientFirstName(patientFirstName);
                userProfile.setPatientLastName(patientLastName);
                userProfile.setPatientAddress(patientAddress);
                userProfile.setPatientAge(patientAge);
                userProfile.setPatientPassword(patientPassword);

                // Create a prepared statement to execute the insert query
                String query = "INSERT INTO UserProfile (patientId, patientFirstName, patientLastName, patientAddress, patientAge, patientPassword) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
                    preparedStatement.setInt(1, userProfile.getPatientId());
                    preparedStatement.setString(2, userProfile.getPatientFirstName());
                    preparedStatement.setString(3, userProfile.getPatientLastName());
                    preparedStatement.setString(4, userProfile.getPatientAddress());
                    preparedStatement.setInt(5, userProfile.getPatientAge());
                    preparedStatement.setString(6, userProfile.getPatientPassword());

                    // Execute the insert query
                    int rowsAffected = preparedStatement.executeUpdate();
                    
                    if (rowsAffected > 0) {//bigger than zero means true, 
                        JOptionPane.showMessageDialog(null, "User registered successfully with patientId: " + userProfile.getPatientId());
                        JOptionPane.showMessageDialog(null, "You are logged in as: " + userProfile.getPatientFirstName() + " " + userProfile.getPatientLastName());

                        manipulatingAfterNewRegisteration ();
                    } else {
                        JOptionPane.showMessageDialog(null, "User registration failed.");
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error registering user: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null , "Database connection server error! make sure your MySQL server connected.\nHow to solve this problem?\nMake sure you MySQL server is running and enter the correct data when you run the App.\nPlease colse the App now and try again when MySQL server is working.");
        }
        } catch (SQLException ex) {
            Logger.getLogger(EskandarMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //method number 11 clear FTs
    void clearLoginTab() {
        EskandarConnectUI.lnameTF.setText(null);
        EskandarConnectUI.fnameTF.setText(null);
        EskandarConnectUI.addressTF.setText(null);
        EskandarConnectUI.ageTF.setText(null);
    }
    //start tab 2 APPOITMENT tab
    //start method number one delete appointment 
    void deleteAppointment(int appointmentId) {
        try {
            // Create a prepared statement to execute the delete query
            String query = "DELETE FROM Appointment WHERE appointmentId = ?";
            try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
                preparedStatement.setInt(1, appointmentId);

                // Execute the delete query
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {//bigger than zero means true, exists 
                    JOptionPane.showMessageDialog(null ,"Appointment with appointmentId " + EskandarConnectUI.appointmentidTF1.getText() + " deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(null ,"No appointment found with appointmentId " + EskandarConnectUI.appointmentidTF1.getText() + ". Deletion failed.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null , "Error deleting appointment with appointmentId " + EskandarConnectUI.appointmentidTF1.getText() + " that's because: " + e.getMessage());
        }
    }
    //start method number two update appointment 
    void updateAppointment(Appointment updatedAppointment) {
        try {
            // Create a prepared statement to execute the update query
            String query = "UPDATE Appointment SET date = ?, contactNumber = ?, doctorName = ? WHERE appointmentId = ?";
            try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
                preparedStatement.setString(1, updatedAppointment.getDate());
                preparedStatement.setString(2, updatedAppointment.getContactNumber());
                preparedStatement.setString(3, updatedAppointment.getDoctorName());
                preparedStatement.setInt(4, updatedAppointment.getAppointmentId());

                // Execute the update query
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Appointment with appointmentId " + updatedAppointment.getAppointmentId() + " updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "No appointment found with appointmentId " + updatedAppointment.getAppointmentId() + ". Update failed.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating appointment with appointmentId " + updatedAppointment.getAppointmentId() + ": " + e.getMessage());
        }
    }//end method 2 update appointment
    //display appointment method number three
    void displayAppointmentsForPatient(int patientId) {
        UserProfile up = new UserProfile();//instance of the parent class 
        try {
            // Create a prepared statement to execute the query
            //join statement to display accordingly // source https://www.w3schools.com/sql/sql_join.asp
            String query = "SELECT a.*, u.patientFirstName, u.patientLastName " +
                           "FROM Appointment a " +
                           "JOIN UserProfile u ON a.patientId = u.patientId " +
                           "WHERE a.patientId = ?";
            try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
                preparedStatement.setInt(1, patientId);

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                // Check if there are matching appointments
                if (resultSet.next() == true) {
                    // Fetch patient details from the first row
                    up.setPatientFirstName(resultSet.getString("patientFirstName"));
                    up.setPatientLastName(resultSet.getString("patientLastName"));

                    // Display all appointments for the patient
                    StringBuilder details = new StringBuilder("Appointments for " + up.getPatientFirstName() +
                            " " + up.getPatientLastName() + " with patient ID " + patientId + ":\n");

                    //the relationship is one to many so a do while loop is a good practice here
                    do {Appointment appointment = new Appointment(
                                resultSet.getInt("appointmentId"),
                                resultSet.getString("date"),
                                resultSet.getString("contactNumber"),
                                resultSet.getString("doctorName"),
                                up.getPatientId(), 
                                up.getPatientFirstName(),
                                up.getPatientLastName(),
                                up.getPatientAddress(),
                                up.getPatientAge(),
                                up.getPatientPassword()
                        );
                        
                        details.append(appointment.toString()).append("\n");
                    } while (resultSet.next());

                    JOptionPane.showMessageDialog(null, details.toString());
                } else {
                    // No matching appointments found
                    JOptionPane.showMessageDialog(null, "No appointments found for patient ID " + patientId + ".");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    //method method number four booking appoitment 
    void bookAppointment(int appointmentId, String date, String contactNumber, String doctorName, int patientId) {
        try {
            // Create a prepared statement to execute the insert query
            String query = "INSERT INTO Appointment (appointmentId, patientId, date, contactNumber, doctorName) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
                
                preparedStatement.setInt(1, appointmentId);
                preparedStatement.setInt(2, patientId);
                preparedStatement.setString(3, date);
                preparedStatement.setString(4, contactNumber);
                preparedStatement.setString(5, doctorName);

                // Execute the insert query
                int rowsAffected = preparedStatement.executeUpdate();
                
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Appointment booked successfully.");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Booking appointment failed.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error booking appointment: " + e.getMessage() + "\nHow to solve this issue?\nOne way to solve this issue is by choosing a different Appointment ID as the\nAppointment ID is already booked!\nSo, please choose a different appointment ID.");
            System.out.println(e.getMessage());
        }
    }//end method_booking appoitment 
    //clear the appointment tab method five
    void clearAppointmentMethod() {
        EskandarConnectUI.appointmentidTF1.setText(null);
        EskandarConnectUI.chosendateTF.setText(null);
        EskandarConnectUI.doctornameTF.setText(null);
        EskandarConnectUI.doctornumberTF.setText(null);
    }
    //start EHR tab
    //method 1 add EHR 
    void addEHR(ElectricalHealthcareRecord ehr) {
        try {
            // Create a prepared statement to execute the insert query
            String query = "INSERT INTO ElectricalHealthcareRecord (patientId, alergies, currentMedication, medicalHistory) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
                preparedStatement.setInt(1, ehr.getPatientId());
                preparedStatement.setString(2, ehr.getAlergies());
                preparedStatement.setString(3, ehr.getCurrentMedication());
                preparedStatement.setString(4, ehr.getMedicalHistory());

                // Execute the insert query
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {//if it is true 
                    JOptionPane.showMessageDialog(null, "EHR added successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Adding EHR failed.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding EHR: " + e.getMessage());
            System.out.println(e.getMessage());
        }
    }//end add EHR method 
    //start method 2 delete EHR method 
    public void deleteEHR(int patientId) {
        try {
            // Create a prepared statement to execute the delete query
            String query = "DELETE FROM ElectricalHealthcareRecord WHERE patientId = ?";
            
            try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
                preparedStatement.setInt(1, patientId);

                // Execute the delete query
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "EHR for patientId " + patientId + " deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "No EHR found for patientId " + patientId + ". Deletion failed.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting EHR: " + e.getMessage());
            System.out.println(e.getMessage());
        }
    }
    //end delete EHR method 
    //start method 3 update EHR 
    void updateEHR(int patientId, String newAllergies, String newCurrentMedication, String newMedicalHistory) {
        try {
            String query = "UPDATE ElectricalHealthcareRecord SET alergies = ?, currentMedication = ?, medicalHistory = ? WHERE patientId = ?";
            try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
                preparedStatement.setString(1, newAllergies);
                preparedStatement.setString(2, newCurrentMedication);
                preparedStatement.setString(3, newMedicalHistory);
                preparedStatement.setInt(4, patientId);

                // Execute the update query
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "EHR for patientId " + patientId + " updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "No EHR found for patientId " + patientId + ". Update failed.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating EHR: " + e.getMessage());
        }
    }//end method 3 update EHR 
    //start method 4 write to file 
    void writeUserEHRToFile(String filePath, String loggedInUserId) {
        try {
            // Create a file writer
            FileWriter fileWriter = new FileWriter(filePath);
            // Create a buffered writer
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Get the current date and time
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentDateTime = dateFormat.format(new Date());

            // Write header with date and time
            String header = String.format("This is official Electrical health record\nPatient EHR - Logged-in User ID: " + loggedInUserId + "\nThis official EHR was issued on date: " + currentDateTime + "\n\n");
            bufferedWriter.write(header);

            // Write table header
            //The %-15s %-25s %-25s %-25s%n each one is a fix width to print the required string // source https://stackoverflow.com/questions/29370621/java-printing-string-with-fixed-width
            String tableHeader = String.format("%-15s %-25s %-25s %-25s%n", "Patient ID|", "|Allergies|", "|Current Medication|", "|Medical History|\n"
                    + "--------------------------------------------------------------------------------------------------");
            bufferedWriter.write(tableHeader);

            // Retrieve EHR records for the logged-in user from the database
            String query = "SELECT * FROM ElectricalHealthcareRecord WHERE patientId = ?";
            try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
                preparedStatement.setString(1, loggedInUserId);
                ResultSet resultSet = preparedStatement.executeQuery();

                // Write each EHR record to the file
                while (resultSet.next()) {
                    int patientId = resultSet.getInt("patientId");
                    String alergies = resultSet.getString("alergies");
                    String currentMedication = resultSet.getString("currentMedication");
                    String medicalHistory = resultSet.getString("medicalHistory");

                    // Write the EHR record to the file
                    //The %-15s %-25s %-25s %-25s%n each one is a fix width to print the required string // source https://stackoverflow.com/questions/29370621/java-printing-string-with-fixed-width
                    String row = String.format("%-15d %-25s %-25s %-25s%n", patientId, alergies, currentMedication, medicalHistory);
                    bufferedWriter.write(row);
                }
                
                bufferedWriter.close();// Close the buffered writer
                System.out.println("EHR records for the logged-in user written to file: " + filePath);//for me to know, delete later 
                JOptionPane.showMessageDialog(null, "EHR records for the logged-in user written to file: " + filePath);
            }
        } catch (IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, "The error is: " + e.getMessage());
            System.err.println("Error writing EHR records to file: " + e.getMessage());
        }
    }
    //Clear the TFs in the EHR tab method number 5
    void ehrClear () {
        EHRalergyTF.setText(null);
        EHRmedicalhistoryTF.setText(null);
        EHRcurrentmedicationTF.setText(null);
        //EHRpathTF.setText(null);
        //EHRidTF.setText(null);
    }
    //method number 6 displaying the EHR based on their ID 
    public void displayEHR(int patientId) {
        try {
            // Create a prepared statement to execute the query
            String query = "SELECT * FROM ElectricalHealthcareRecord WHERE patientId = ?";
            try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
                preparedStatement.setInt(1, patientId);

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                // Check if there are matching EHR records
                if (resultSet.next()) {
                    // Display EHR records in the corresponding text fields
                    EskandarConnectUI.EHRalergyTF.setText(resultSet.getString("alergies"));
                    EskandarConnectUI.EHRcurrentmedicationTF.setText(resultSet.getString("currentMedication"));
                    EskandarConnectUI.EHRmedicalhistoryTF.setText(resultSet.getString("medicalHistory"));
                } else {
                    // No matching EHR records found
                    JOptionPane.showMessageDialog(null, "EHR records not found for Patient ID: " + patientId);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error displaying EHR records: " + e.getMessage());
        }
    }
    //extra methds to manipulate the components 
    void manipulateAfterLogIn () {
        EskandarConnectUI.exitBTN1.setVisible(true);
        EskandarConnectUI.signupBTN.setVisible(false);
        EskandarConnectUI.loginBTN1.setEnabled(false);
        idTF.setEditable(false);
        appointmentidTF.setEditable(false);
        EHRidTF.setEditable(false);
        //Enable everything if logged in
        EskandarConnectUI.displayBTN.setEnabled(true);
        EskandarConnectUI.deleteBTN.setEnabled(true);
        EskandarConnectUI.updateBTN.setEnabled(true);
        //HealthConnectUI.loginBTN1.setEnabled(true);
        EskandarConnectUI.appointmentdisplayBTN.setEnabled(true);
        EskandarConnectUI.appointmentdeleteBTN.setEnabled(true);
        EskandarConnectUI.appointmentupdateBTN1.setEnabled(true);
        EskandarConnectUI.appointmentbookBTN .setEnabled(true);
        EskandarConnectUI. EHRdisplayBTN.setEnabled(true);
        EskandarConnectUI. jButton2.setEnabled(true);
        EskandarConnectUI. EHRdeleteBTN.setEnabled(true);
        EskandarConnectUI. EHRupdateBTN.setEnabled(true);
        EskandarConnectUI. EHRaddBTN.setEnabled(true);
        //HealthConnectUI. .setEnabled(true);
        EskandarConnectUI.yonasBTN.setEnabled (true);
        EskandarConnectUI.joshuaBTN.setEnabled(true);
        
    }
    void manipulateAfterLogOut () {
        EskandarConnectUI.exitBTN1.setVisible(false);
        EskandarConnectUI.signupBTN.setVisible(true);
        EskandarConnectUI.loginBTN1.setEnabled(true);
        idTF.setEditable(true);
        appointmentidTF.setEditable(true);
        EHRidTF.setEditable(true);
        //Disable everything if logged in
        EskandarConnectUI.displayBTN.setEnabled(false);
        EskandarConnectUI.deleteBTN.setEnabled(false);
        EskandarConnectUI.updateBTN.setEnabled(false);
        //HealthConnectUI.loginBTN1.setEnabled(false);
        EskandarConnectUI.appointmentdisplayBTN.setEnabled(false);
        EskandarConnectUI.appointmentdeleteBTN.setEnabled(false);
        EskandarConnectUI.appointmentupdateBTN1.setEnabled(false);
        EskandarConnectUI.appointmentbookBTN.setEnabled(false);
        EskandarConnectUI.EHRdisplayBTN.setEnabled(false);
        EskandarConnectUI.jButton2.setEnabled(false);
        EskandarConnectUI.EHRdeleteBTN.setEnabled(false);
        EskandarConnectUI.EHRupdateBTN.setEnabled(false);
        EskandarConnectUI.EHRaddBTN.setEnabled(false);
        //HealthConnectUI.setEnabled(false);
        EskandarConnectUI.yonasBTN.setEnabled (false);
        EskandarConnectUI.joshuaBTN.setEnabled(false );
    }
    //create manipulatingAfterRegisteration method 
    void manipulatingAfterNewRegisteration () {
        //manipulation of the components 
        //Enable everything if logged in
        EskandarConnectUI.displayBTN.setEnabled(true);
        EskandarConnectUI.deleteBTN.setEnabled(true);
        EskandarConnectUI.updateBTN.setEnabled(true);
        EskandarConnectUI.loginBTN1.setEnabled(false);
        EskandarConnectUI.appointmentdisplayBTN.setEnabled(true);
        EskandarConnectUI.appointmentdeleteBTN.setEnabled(true);
        EskandarConnectUI.appointmentupdateBTN1.setEnabled(true);
        EskandarConnectUI.appointmentbookBTN .setEnabled(true);
        EskandarConnectUI. EHRdisplayBTN.setEnabled(true);
        EskandarConnectUI. jButton2.setEnabled(true);
        EskandarConnectUI. EHRdeleteBTN.setEnabled(true);
        EskandarConnectUI. EHRupdateBTN.setEnabled(true);
        EskandarConnectUI. EHRaddBTN.setEnabled(true);
        EskandarConnectUI. signupBTN.setVisible(false);
        EskandarConnectUI. exitBTN1.setVisible(true);
        appointmentidTF.setText(idTF.getText());
        EHRidTF.setText(idTF.getText());
        idTF.setEditable(false);
        appointmentidTF.setEditable(false);
        EHRidTF.setEditable(false);
        EskandarConnectUI.yonasBTN.setEnabled (true);
        EskandarConnectUI.joshuaBTN.setEnabled(true);
        
    }
}
