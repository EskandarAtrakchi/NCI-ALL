package healthconnect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author eskandar atrakchi
 */
public class JavaMethods {
    
    Connection myConn;
    
    //method 1 connection 
    void getConnection() {
        
        //create a connection to our db 
        try {
            //getConnection("like to db ", "username", "password");
            myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/OOP", "root", "0723524754Aa.");
            
        }catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null , "Error, connection to DB: " + e);
            
        }
    }//end method 1
    /////////////////////start tab one login tab
    //method 1 login user   metod 
    public boolean loginUser(int enteredPatientId, String enteredPassword) {
        try {
            // Retrieve user profile based on entered patientId
            UserProfile userProfile = getUserProfile(enteredPatientId);//database-related code is encapsulated within the getUserProfile method.

            if (userProfile != null && userProfile.getPatientPassword().equals(enteredPassword)) {
                // User credentials are valid
                JOptionPane.showMessageDialog(null, "Login successful!");

                HealthConnectUI.appointmentidTF.setText(String.valueOf(userProfile.getPatientId()));
                HealthConnectUI.EHRidTF.setText(String.valueOf(userProfile.getPatientId()));
                HealthConnectUI.idTF.setEditable(false);

                return true;
            } else {
                // No matching user found or invalid password
                JOptionPane.showMessageDialog(null, "Invalid login credentials. Please try again.");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }
    }

    // the loginUser method now calls a new method getUserProfile, which retrieves the user profile from the database based on the entered patientId
    //this method will be used in the tabs buttons
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
    //this method will be used in the tabs buttons
    UserProfile mapResultSetToUserProfile(ResultSet resultSet) throws SQLException {
        
        int patientId = resultSet.getInt("patientId");
        String patientFirstName = resultSet.getString("patientFirstName");
        String patientLastName = resultSet.getString("patientLastName");
        String patientAddress = resultSet.getString("patientAddress");
        int patientAge = resultSet.getInt("patientAge");
        String patientPassword = resultSet.getString("patientPassword");

        return new UserProfile(patientId, patientFirstName, patientLastName, patientAddress, patientAge, patientPassword);
        
    }

    //end method user  log in
    
    //start method 2 Display user 
    
    public void displayUserData(int patientId) {
        try {
            // Retrieve user profile based on entered patientId
            UserProfile userProfile = getUserProfile(patientId);

            if (userProfile != null) {
                // Display user data using the UserProfile object
                System.out.println("User Information:");
                HealthConnectUI.fnameTF.setText(userProfile.getPatientFirstName());
                HealthConnectUI.lnameTF.setText(userProfile.getPatientLastName());
                HealthConnectUI.addressTF.setText(userProfile.getPatientAddress());
                HealthConnectUI.ageTF.setText(String.valueOf(userProfile.getPatientAge()));

                JOptionPane.showMessageDialog(null, "The data is populated successfully");
            } else {
                // No matching user found
                JOptionPane.showMessageDialog(null, "User not found. Please check your patientId.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    //end display user  method 
    //method 3 searchUserForDeleetion
    boolean deleteUser(int patientId) throws SQLException {
        // Retrieve user profile based on entered patientId
        UserProfile userProfile = getUserProfile(patientId);

        if (userProfile != null) {
            // User found, proceed with deletion
            //confirm dialog is needed to confirm that the EHR will be deleted and the appointment will be deleted also
            //JOptionPane.showConfirmDialog(, this)
            
            deleteAppointments(patientId);
            deleteElectricalHealthcareRecord(patientId);

            JOptionPane.showMessageDialog(null, "the deletetion is successful");
            // Create a prepared statement to execute the delete query for UserProfile
            String query = "DELETE FROM UserProfile WHERE patientId = ?";
            try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
                preparedStatement.setInt(1, patientId);

                // Execute the delete query for UserProfile
                int rowsAffected = preparedStatement.executeUpdate();

                //the number of rows that are effected should be more than zero which means true
                return rowsAffected > 0;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No matching user found");
            // No matching user found
            return false;
        }
    }
    //I need to delete the children first then delete the parent 
    //child one appointment 
    void deleteAppointments(int patientId) throws SQLException {
        // Create a prepared statement to execute the delete query for Appointments
        String appointmentQuery = "DELETE FROM Appointment WHERE patientId = ?";
        try (PreparedStatement appointmentStatement = myConn.prepareStatement(appointmentQuery)) {
            appointmentStatement.setInt(1, patientId);
            // Execute the delete query for Appointments
            appointmentStatement.executeUpdate();
        }
    }
    //child two EHR
    void deleteElectricalHealthcareRecord(int patientId) throws SQLException {
        // Create a prepared statement to execute the delete query for Appointments
        String EHRQuery = "DELETE FROM ElectricalHealthcareRecord WHERE patientId = ?";
        try (PreparedStatement EHRStatement = myConn.prepareStatement(EHRQuery)) {
            EHRStatement.setInt(1, patientId);
            // Execute the delete query for ElectricalHealthcareRecord
            EHRStatement.executeUpdate();
        }
    }
    //method 4 update user info
    public void updateUser(UserProfile updatedUserProfile) {
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

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "User with patientId " + updatedUserProfile.getPatientId() + " updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "No user found with patientId " + updatedUserProfile.getPatientId() + ". Update failed.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    //end method 4 update user method 
    //method 5 clear FTs
    void clearLoginTab() {
        
        HealthConnectUI.lnameTF.setText(null);
        HealthConnectUI.fnameTF.setText(null);
        HealthConnectUI.addressTF.setText(null);
        HealthConnectUI.ageTF.setText(null);
                
    }
    //start registeration  methods here 
    void registerUser(int patientId, String patientFirstName, String patientLastName, String patientAddress, int patientAge, String patientPassword) {
        try {
            // Check if the chosen patientId already exists
            if (userExists(patientId)) {//call the method and pass value through the parameter, I should create the method later
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

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "User registered successfully with patientId: " + userProfile.getPatientId());
                } else {
                    JOptionPane.showMessageDialog(null, "User registration failed.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error registering user: " + e.getMessage());
        }
    }
    //I should run if statement that if the user exists or not in the first place 
    boolean userExists(int patientId) {
        // Check if a user with the same patientId already exists
        String query = "SELECT COUNT(*) FROM UserProfile WHERE patientId = ?";
        try (PreparedStatement preparedStatement = myConn.prepareStatement(query)) {
            preparedStatement.setInt(1, patientId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error checking user existence: " + e.getMessage());
        }
        return false;
    }
}
