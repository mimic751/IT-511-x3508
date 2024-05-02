package Final.Milestone_2.Recipe_book;

import java.util.HashMap;
import java.util.Map;

public class IngredientManager {
    // Making the maps public static so they can be accessed globally
    public static Map<String, Double> localIngredientList = new HashMap<>();
    public static Map<String, Double> defaultIngredientList = new HashMap<>();
    private static IngredientManager instance = new IngredientManager();

    private IngredientManager() {}

    public static IngredientManager getInstance() {
        return instance;
    }
    
    // Methods to manipulate and access the maps
    public static void updateLocalIngredient(String ingredientName, double caloriesPerCup) {
        localIngredientList.put(ingredientName, caloriesPerCup);
    }

    public static double getCaloriesPerCup(String ingredientName) {
        return localIngredientList.getOrDefault(ingredientName, 0.0);
    }
    
    public static void updateDefaultIngredient(String ingredientName, double caloriesPerCup) {
        defaultIngredientList.put(ingredientName, caloriesPerCup);
    }

    public static Double getLocalIngredientCalories(String ingredientName) {
        return localIngredientList.get(ingredientName);
    }

    public static Double getDefaultIngredientCalories(String ingredientName) {
        return defaultIngredientList.get(ingredientName);
    }

    public static boolean ingredientExists(String ingredientName) {
        return localIngredientList.containsKey(ingredientName);
    }

    public static void addIngredient(String ingredientName, double caloriesPerCup) {
        localIngredientList.put(ingredientName, caloriesPerCup);
    }
 
    public Map<String, Double> getLocalIngredientList() {
        return localIngredientList;
    }

}
