/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package healthconnect;

/**
 *
 * @author yonas
 */
public class Exercise extends Health {// start class
    private String freeTime;
    private String CurrenFitnessLevel;
    private String  FitnessGoals;
    
    
public Exercise(String userId, String gender, int age, double weight, double height, String freeTime, String CurrenFitnessLevel, String FitnessGoals) {
    super(userId, gender, age, weight, height, ""); // Assuming activityLevel is not relevant here
    this.freeTime = freeTime;
    this.CurrenFitnessLevel = CurrenFitnessLevel;
    this.FitnessGoals = FitnessGoals;
}


    // Getters and Setters

    public String getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(String freeTime) {
        this.freeTime = freeTime;
    }

    public String getCurrenFitnessLevel() {
        return CurrenFitnessLevel;
    }

    public void setCurrenFitnessLevel(String CurrenFitnessLevel) {
        this.CurrenFitnessLevel = CurrenFitnessLevel;
    }

    public String getFitnessGoals() {
        return FitnessGoals;
    }

    public void setFitnessGoals(String FitnessGoals) {
        this.FitnessGoals = FitnessGoals;
    }

    

 
}// end class
