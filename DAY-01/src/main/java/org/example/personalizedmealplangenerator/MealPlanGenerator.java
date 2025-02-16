package org.example.personalizedmealplangenerator;

// MealPlan Interface
interface MealPlan {
    void displayMealDetails();
}

// Vegetarian Meal
class VegetarianMeal implements MealPlan {
    private String dishName;

    public VegetarianMeal(String dishName) {
        this.dishName = dishName;
    }

    @Override
    public void displayMealDetails() {
        System.out.println("Vegetarian Meal: " + dishName);
    }
}

// Vegan Meal
class VeganMeal implements MealPlan {
    private String dishName;

    public VeganMeal(String dishName) {
        this.dishName = dishName;
    }

    @Override
    public void displayMealDetails() {
        System.out.println("Vegan Meal: " + dishName);
    }
}

// Generic Meal Class
class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    // Method to validate and generate a personalized meal plan
    public void validateAndGenerateMeal() {
        if (meal == null) {
            System.out.println("Error: No meal selected.");
        } else {
            System.out.println("Meal Plan Generated: ");
            meal.displayMealDetails();
            System.out.println("------------------------------------------------------------");
        }
    }
}

public class MealPlanGenerator {

    public static void main(String[] args) {
        // Create different meal plan objects
        VegetarianMeal vegetarian = new VegetarianMeal("Paneer And Milk");
        VeganMeal vegan = new VeganMeal("Mixed Fruits");


        // Create generic meal objects for each meal type
        Meal<VegetarianMeal> vegetarianMeal = new Meal<>(vegetarian);
        Meal<VeganMeal> veganMeal = new Meal<>(vegan);


        // Validate and generate the meal plans
        vegetarianMeal.validateAndGenerateMeal();
        veganMeal.validateAndGenerateMeal();

    }
}

