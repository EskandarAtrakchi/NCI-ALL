package healthconnect;

public class HealthData {// start class
    Methods m = new Methods ();
    private Health health;
    private Nutrition nutrition;
    private Exercise exercise;
    private double bmi;

    // Constructors, getters, and setters 
    public HealthData(Health health, Nutrition nutrition, Exercise exercise) {
        this.health = health;
        this.nutrition = nutrition;
        this.exercise = exercise;

    }
    
     

    // Getter methods for Health, Nutrition, and Exercise
    public Health getHealth() {
        return health;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public Exercise getExercise() {
        return exercise;
    }
    
    public void setHealth(Health health) {
        this.health = health;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
    

    //  methods for suggesting nutrition and exercise based on BMI
    public void suggestNutrition() {
        m.provideNutritionSuggestions(bmi, nutrition);
    }

    public void suggestExercise() {
    String exerciseFreeTime = exercise.getFreeTime();
    String currentFitnessLevel = health.getActivityLevel();
    m.provideExerciseSuggestions(bmi, exerciseFreeTime, currentFitnessLevel, exercise.getFitnessGoals());


}
}//end class
