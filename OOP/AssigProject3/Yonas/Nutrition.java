package healthconnect;

public class Nutrition extends Health {// start class
    private String bmi;
    private boolean vegetarian;
    private boolean vegan;
    private boolean allergies;
    private boolean omnivore;

    public Nutrition(String userId, String gender, int age, double height, double weight, String activityLevel,
                     String bmi, boolean vegetarian, boolean vegan, boolean allergies, boolean omnivore) {
        super(userId, gender, age, height, weight, activityLevel);
        this.bmi = bmi;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.allergies = allergies;
        this.omnivore = omnivore;
    }

    // Getters and Setters for boolean values
    public boolean isVegetarian() {
        return vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public boolean isAllergies() {
        return allergies;
    }

    public boolean isOmnivore() {
        return omnivore;
    }


}//end class