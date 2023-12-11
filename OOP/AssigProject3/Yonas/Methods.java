package healthconnect;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Methods {// start class
    
    private static final String FILE_PATH = "user_health_data.ser";
    private static List<HealthData> userHealthDataList = new ArrayList<>(); 
    public static List<HealthData> getUserHealthDataList() {
        return userHealthDataList;
    }
    
    
    void setHealthData(HealthData existingUser, HealthData userHealthData) {
        existingUser.setHealth(userHealthData.getHealth());
        existingUser.setNutrition(userHealthData.getNutrition());
        existingUser.setExercise(userHealthData.getExercise());
    }

 double calculateBMI(String userId, String gender, int age, double height, double weight, String activityLevel) {
    // Create a Health object
    Health person = new Health(userId, gender, age, height, weight, activityLevel);

    // Convert height to meters
    double heightInMeters = person.getHeight() / 100.0;

    // Calculate BMI
    double bmi = person.getWeight() / (heightInMeters * heightInMeters);

    // Round BMI to two decimal places
    bmi = Math.round(bmi * 100.0) / 100.0;

    return bmi;
}
  double calculateBMI(Health health) {
    // calculate BMI using the health object
    double heightInMeters = health.getHeight() / 100.0;
    return health.getWeight() / (heightInMeters * heightInMeters);
}

     void handleCalorieIntakeOption(String userId, String gender, int age, double height, double weight, String activityLevel) {
        // Create a Health object
        Health person = new Health(userId, gender, age, height, weight, activityLevel);

        //  Print input values
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("Activity Level: " + activityLevel);

        // Estimate BMI
        double bmi = calculateBMI(userId, gender, age, height, weight, activityLevel);

        //  Print calculated BMI
        System.out.println("Calculated BMI: " + bmi);

        // Estimate daily calorie intake
        double calorieIntake = estimateCalorieIntake(person, activityLevel);

        // Convert calorie intake to grams for macronutrients
        int carbsGrams = (int) (calorieIntake * 0.4 / 4); // 40% of calories from carbs
        int proteinsGrams = (int) (calorieIntake * 0.3 / 4); // 30% of calories from proteins
        int fatsGrams = (int) (calorieIntake * 0.3 / 9); // 30% of calories from fats

        // Display estimated values in the HealthjConnectUI
        displayCalorieIntake(carbsGrams, proteinsGrams, fatsGrams, (int) calorieIntake, bmi);
    }

    double estimateCalorieIntake(Health person, String activityLevel) {
        // estimation based on activity level
        double baseCalories = 2000; // adjust this based on your needs

        switch (activityLevel.toLowerCase()) {
            case "low":
                return baseCalories * 1.2;
            case "moderate":
                return baseCalories * 1.5;
            case "high":
                return baseCalories * 1.8;
            default:
                return baseCalories;
        }
    }
      // Method to Display WeightMeasurement
      void displayCalorieIntake(int carbsGrams, int proteinsGrams, int fatsGrams, int calorieIntake, double bmi) {

    // Display WeightMeasurement
    String weightMeasurement = getWeightMeasurement(bmi);
    System.out.println("Weight Measurement: " + weightMeasurement);
}

 String getWeightMeasurement(double bmi) {
    if (bmi < 18.5) {
        return "Underweight";
    } else if (bmi >= 18.5 && bmi <= 24.9) {
        return "Normal weight";
    } else if (bmi >= 25.0 && bmi <= 29.9) {
        return "Overweight";
    } else {
        return "Obese";
    }
}
// this method will take parametrs and output the suggestion as string
 List<String> provideNutritionSuggestions(double bmi, Nutrition userNutrition) {
        List<String> suggestions = new ArrayList<>();

        // Get BMI category
        String bmiCategory = getWeightMeasurement(bmi);

        //Check BMI category and provide suggestions
        switch (bmiCategory) {
            case "Underweight":
                suggestions.add("Consider increasing calorie intake for underweight individuals.");
                break;
            case "Normal weight":
                suggestions.add("Maintain a balanced diet for normal weight individuals.");
                break;
            case "Overweight":
                suggestions.add("Consider reducing calorie intake for overweight individuals.");
                break;
            case "Obese":
                suggestions.add("Focus on a healthy diet and exercise for obese individuals.");
                break;
            default:
                suggestions.add("Unexpected BMI category.");
                break;
        }

        //Check user's nutrition preferences and adjust suggestions
        if (userNutrition.isVegetarian()) {
            suggestions.add("Consider plant-based protein sources for vegetarians.");
        }

        if (userNutrition.isVegan()) {
            suggestions.add("Include only plant-based foods for vegans.");
        }

        if (userNutrition.isAllergies()) {
            suggestions.add("Adjust suggestions based on allergies.");
        }

        return suggestions;
    }
// this method will take parametrs and output the suggestion as string
 List<String> provideExerciseSuggestions(double bmi, String freeTime, String currentFitnessLevel, String fitnessGoals) {

    List<String> suggestions = new ArrayList<>();

    // Customize based on free time preferences
    switch (freeTime.toLowerCase()) {
        case "morning":
            suggestions.add("Consider morning workouts for a fresh start to your day.");
            break;
        case "daytime":
            suggestions.add("Daytime workouts can boost your energy levels throughout the day.");
            break;
        case "evening":
            suggestions.add("Evening workouts are a great way to unwind and de-stress.");
            break;
        default:
            suggestions.add("Invalid free time preference");
            break;
    }

    // Customize based on activity level
  switch (currentFitnessLevel.toLowerCase()) {
    case "beginner":
        suggestions.add("As a beginner, start with light exercises and gradually increase intensity.");
        break;
    case "intermediate":
        suggestions.add("For an intermediate fitness level, consider a mix of cardio and strength training.");
        break;
    case "advanced":
        suggestions.add("With an advanced fitness level, challenge yourself with high-intensity workouts.");
        break;
    case "not sure":
        suggestions.add("If you're not sure about your fitness level, consult with a fitness professional.");
        break;
    default:
        suggestions.add("Invalid fitness level preference");
        break;
}



    // Customize based on BMI category
    String bmiCategory = getWeightMeasurement(bmi); // Assuming getWeightMeasurement returns a String
    switch (bmiCategory.toLowerCase()) {
        case "underweight":
            suggestions.add("For underweight individuals, focus on healthy weight gain strategies.");
            break;
        case "normal weight":
            suggestions.add("Maintaining a normal weight is great. Continue with a balanced exercise routine.");
            break;
        case "overweight":
            suggestions.add("For overweight individuals, emphasize cardio and portion control for weight management.");
            break;
        case "obese":
            suggestions.add("Obesity may require a combination of dietary changes and increased physical activity.");
            break;
        default:
            suggestions.add("Invalid BMI category");
            break;
    }

    // Customize based on fitness goals
    switch (fitnessGoals.toLowerCase()) {
        case "weight":
            suggestions.add("Focus on a calorie deficit and include both cardio and strength training for weight loss.");
            break;
        case "muscle building":
            suggestions.add("For muscle building, prioritize strength training and ensure a protein-rich diet.");
            break;
        case "improving flexibility":
            suggestions.add("Include stretching exercises and yoga to improve flexibility.");
            break;
        case "overall well-being":
            suggestions.add("A well-rounded exercise routine contributes to overall well-being. Mix cardio, strength, and flexibility exercises.");
            break;
        default:
            suggestions.add("Invalid fitness goals preference");
            break;
    }

    return suggestions;
}
// method is to find and display health data for a user with a specific ID
HealthData searchAndDisplayUser(String userId) {
    System.out.println("Searching for user with ID: " + userId);

    for (HealthData userHealthData : userHealthDataList) {
        if (userHealthData.getHealth().getUserId().equals(userId)) {
            System.out.println("User found!");
            displayUserHealthData(userHealthData);
            return userHealthData;
        }
    }

    System.out.println("User not found.");
    return null;
}
 void displayUserHealthData(HealthData userHealthData) {
        System.out.println("User ID: " + userHealthData.getHealth().getUserId());
        System.out.println("Gender: " + userHealthData.getHealth().getGender());
        System.out.println("Age: " + userHealthData.getHealth().getAge());
        System.out.println("Height: " + userHealthData.getHealth().getHeight());
        System.out.println("Weight: " + userHealthData.getHealth().getWeight());
        System.out.println("Activity Level: " + userHealthData.getHealth().getActivityLevel());

        // Display information from Nutrition and Exercise if needed
        System.out.println("Nutrition Info: " + userHealthData.getNutrition());
        System.out.println("Exercise Info: " + userHealthData.getExercise());
    }
// method to gathering user input (replace this with your actual implementation)
 void addUsersFromInput() {
    
    String userId1 = "1";
    String gender1 = "Male";
    int age1 = 25;
    double height1 = 175.0;
    double weight1 = 70.0;
    String activityLevel1 = "Moderate";

    String userId2 = "2";
    String gender2 = "Female";
    int age2 = 30;
    double height2 = 160.0;
    double weight2 = 55.0;
    String activityLevel2 = "High";

    // Create HealthData objects directly
    HealthData userHealthData1 = createUserHealthData(userId1, gender1, age1, height1, weight1, activityLevel1);
    HealthData userHealthData2 = createUserHealthData(userId2, gender2, age2, height2, weight2, activityLevel2);

    // using addOrUpdateUser method to add these users to the list
    addOrUpdateUser(userHealthData1);
    addOrUpdateUser(userHealthData2);
}

// method to create HealthData objects
 HealthData createUserHealthData(String userId, String gender, int age, double height, double weight, String activityLevel) {
    // Create Health, Nutrition, and Exercise objects
    Health healthData = new Health(userId, gender, age, height, weight, activityLevel);
    Nutrition nutritionData = new Nutrition(userId, gender, age, height, weight, activityLevel, "bmiValue", true, true, true, true);
    Exercise exerciseData = new Exercise(userId, gender, age, weight, height, "Evening", "Intermediate", "Weight Loss");
    // Create HealthData object
    return new HealthData(healthData, nutritionData, exerciseData);
}
 //method to adduser or update info
 void addOrUpdateUser(HealthData userHealthData) {
    // Check if user with the same ID already exists
    String userId = userHealthData.getHealth().getUserId();
    HealthData existingUser = searchAndDisplayUser(userId);

    if (existingUser != null) {
        // User exists, update the data
        existingUser.setHealth(userHealthData.getHealth());
        existingUser.setNutrition(userHealthData.getNutrition());
        existingUser.setExercise(userHealthData.getExercise());
        JOptionPane.showMessageDialog(null, "User updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

    } else {
        // User doesn't exist, add new user
        userHealthDataList.add(userHealthData);
         // Optionally, you can display a success message
        JOptionPane.showMessageDialog(null, "User Added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);


        // Print the contents of the userHealthDataList to vertify
        System.out.println("User Health Data List:");
        for (HealthData user : userHealthDataList) {
            System.out.println(user);
        }
    }
}

  void deleteUserById(String userId) {//delete method by userid
        HealthData userToDelete = searchAndDisplayUser(userId);
        if (userToDelete != null) {
            userHealthDataList.remove(userToDelete);
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found. Deletion failed.");
        }
    }
      
    void WriteToFile(JTextArea displayInfo) {//file to print file method 
       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_details.txt", true))) {
            
            // Append the success message to the displayInfo JTextArea
        displayInfo.append("File printed successfully!\n");
            

            // Append the user details to the displayInfo JTextArea and write to the file
            for (HealthData userHealthData : getUserHealthDataList()) {
                displayInfo.append("User ID: " + userHealthData.getHealth().getUserId() + "\n");
                displayInfo.append("Gender: " + userHealthData.getHealth().getGender() + "\n");
                displayInfo.append("Age: " + userHealthData.getHealth().getAge() + "\n");
                displayInfo.append("Height: " + userHealthData.getHealth().getHeight() + "\n");
                displayInfo.append("Weight: " + userHealthData.getHealth().getWeight() + "\n");
                displayInfo.append("Activity Level: " + userHealthData.getHealth().getActivityLevel() + "\n");
                displayInfo.append("Nutrition Info:\n");
                displayInfo.append("   Vegetarian: " + userHealthData.getNutrition().isVegetarian() + "\n");
                displayInfo.append("   Vegan: " + userHealthData.getNutrition().isVegan() + "\n");
                displayInfo.append("   Allergies: " + userHealthData.getNutrition().isAllergies() + "\n");
                displayInfo.append("   Omnivore: " + userHealthData.getNutrition().isOmnivore() + "\n");
                displayInfo.append("Exercise Info:\n");
                displayInfo.append("   Free Time: " + userHealthData.getExercise().getFreeTime() + "\n");
                displayInfo.append("   Current Fitness Level: " + userHealthData.getExercise().getCurrenFitnessLevel() + "\n");
                displayInfo.append("   Fitness Goals: " + userHealthData.getExercise().getFitnessGoals() + "\n");
                displayInfo.append("----------------------\n"); // Separator between users

                // Write the user details to the file
                writer.write("User ID: " + userHealthData.getHealth().getUserId() + "\n");
                writer.write("Gender: " + userHealthData.getHealth().getGender() + "\n");
                writer.write("Age: " + userHealthData.getHealth().getAge() + "\n");
                writer.write("Height: " + userHealthData.getHealth().getHeight() + "\n");
                writer.write("Weight: " + userHealthData.getHealth().getWeight() + "\n");
                writer.write("Activity Level: " + userHealthData.getHealth().getActivityLevel() + "\n");
                writer.write("Nutrition Info:\n");
                writer.write("   Vegetarian: " + userHealthData.getNutrition().isVegetarian() + "\n");
                writer.write("   Vegan: " + userHealthData.getNutrition().isVegan() + "\n");
                writer.write("   Allergies: " + userHealthData.getNutrition().isAllergies() + "\n");
                writer.write("   Omnivore: " + userHealthData.getNutrition().isOmnivore() + "\n");
                writer.write("Exercise Info:\n");
                writer.write("   Free Time: " + userHealthData.getExercise().getFreeTime() + "\n");
                writer.write("   Current Fitness Level: " + userHealthData.getExercise().getCurrenFitnessLevel() + "\n");
                writer.write("   Fitness Goals: " + userHealthData.getExercise().getFitnessGoals() + "\n");
                writer.write("----------------------\n"); // Separator between users
            }
          // Clear displayInfo JTextArea
            displayInfo.setText("");
        } catch (IOException e) {
        }
    }
    
   void readFromFileAndDisplay(JTextArea displayInfo) {//read file  method 
    String fileName = "user_details.txt";
    File file = new File(fileName);
    // if statement to cheack if the file is exit  and try and catch to handel the exception/error
    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder userDetails = new StringBuilder();

            while ((line = reader.readLine()) != null) { //while loop statement to read from the file
                userDetails.append(line).append("\n");

                // Check for the separator to identify the end of a user's details
                if (line.equals("----------------------")) {
                    appendToDisplay(displayInfo, userDetails.toString());
                    userDetails.setLength(0); // Clear StringBuilder for the next user
                }
            }
        } catch (IOException e) {//if there is error will be handle with try and catch
            showError("Error reading file: " + e.getMessage());
        }
    } else {
            //  error message to let the user know they have to print the file first
          JOptionPane.showMessageDialog(null, "Nothing to print. Please Print them first.");
    }
}
// method to dispaly on the textarea after the file reding is done sucessfully
 void appendToDisplay(JTextArea displayInfo, String text) {
    SwingUtilities.invokeLater(() -> {
        displayInfo.append(text);
    });
}
//method to dispaly error if  file reding is  not done sucessfully
 void showError(String message) {
    SwingUtilities.invokeLater(() -> {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    });
}
}// end class


    

     
    

