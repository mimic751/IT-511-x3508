package Final.Recipe_book;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Represents a recipe, including the recipe name, number of servings, and a list of ingredients with their quantities.
 */
public class Recipe {
    /**
     * The name of the recipe.
     */
    private String recipeName;

    /**
     * The number of servings the recipe yields.
     */
    private int servings;

    /**
     * A map of ingredients and their quantities in cups.
     */
    private Map<String, Double> ingredients;

    /**
     * Constructs a new Recipe object with specified name, servings, and ingredients.
     * @param recipeName the name of the recipe.
     * @param servings the number of servings the recipe provides.
     * @param ingredients a map of ingredients with their respective quantities in cups.
     */
    public Recipe(String recipeName, int servings, Map<String, Double> ingredients) {
        this.recipeName = recipeName;
        this.servings = servings;
        this.ingredients = new HashMap<>(ingredients);
    }

    /**
     * Gets the name of the recipe.
     * @return the name of the recipe.
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * Gets the number of servings for the recipe.
     * @return the number of servings.
     */
    public int getServings() {
        return servings;
    }

    /**
     * Sets the number of servings for the recipe.
     * @param servings the new number of servings.
     */
    public void setServings(int servings) {
        this.servings = servings;
    }

    /**
     * Gets a copy of the ingredients map.
     * @return a new map of the ingredients.
     */
    public Map<String, Double> getIngredients() {
        return new HashMap<>(ingredients);
    }

    /**
     * Sets the ingredients for the recipe.
     * @param ingredients a map of the ingredients with their respective quantities.
     */
    public void setIngredients(Map<String, Double> ingredients) {
        this.ingredients = new HashMap<>(ingredients);
    }

    /**
     * Calculates the total calories for the recipe based on the ingredients and their quantities.
     * @return the total calories for the recipe.
     */
    public double calculateTotalCalories() {
        double totalCalories = 0;
        for (Entry<String, Double> entry : ingredients.entrySet()) {
            String ingredientName = entry.getKey();
            Double cups = entry.getValue();
            double caloriesPerCup = IngredientManager.getCaloriesPerCup(ingredientName); // Assumes IngredientManager is implemented correctly
            totalCalories += caloriesPerCup * cups;
        }
        return totalCalories;
    }

    /**
     * Updates the ingredients of the recipe by adding or replacing ingredients and their quantities.
     * @param newIngredients a map of ingredients to update in the recipe.
     */
    public void updateRecipeIngredients(Map<String, Double> newIngredients) {
        this.ingredients.putAll(newIngredients);
    }

    /**
     * Prints the recipe details to the console.
     */
    public void printRecipe() {
        System.out.println("Recipe Name: " + recipeName);
        System.out.println("Servings: " + servings);
        System.out.println("Ingredients:");
        for (Map.Entry<String, Double> entry : ingredients.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue() + " cups");
        }
        // Optionally calculate and display total calories
        double totalCalories = calculateTotalCalories();
        System.out.println("Total Calories: " + totalCalories);
    }
}
