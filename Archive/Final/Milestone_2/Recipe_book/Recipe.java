package Final.Milestone_2.Recipe_book;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Recipe {
    private String recipeName;
    private int servings;
    private Map<String, Double> ingredients;

    public Recipe(String recipeName, int servings, Map<String, Double> ingredients) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.ingredients = new HashMap<>(ingredients);
    }

    public String getRecipeName() {
        return recipeName;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public Map<String, Double> getIngredients() {
        return new HashMap<>(ingredients);
    }

    public void setIngredients(Map<String, Double> ingredients) {
        this.ingredients = new HashMap<>(ingredients);
    }

    public double calculateTotalCalories() {
        double totalCalories = 0;
        for (Entry<String, Double> entry : ingredients.entrySet()) {
            String ingredientName = entry.getKey();
            Double cups = entry.getValue();
            double caloriesPerCup = IngredientManager.getCaloriesPerCup(ingredientName); // Ensure IngredientManager is implemented
            totalCalories += caloriesPerCup * cups;
        }
        return totalCalories;
    }

    public void updateRecipeIngredients(Map<String, Double> newIngredients) {
        this.ingredients.putAll(newIngredients);
    }

    public void printRecipe() {
        System.out.println("Recipe Name: " + recipeName);
        System.out.println("Servings: " + servings);
        System.out.println("Ingredients:");
        for (Map.Entry<String, Double> entry : ingredients.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue());
        }
        // If calories calculation is needed
        double totalCalories = calculateTotalCalories();
        System.out.println("Total Calories: " + totalCalories);
    }
    
}
