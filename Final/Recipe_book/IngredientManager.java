package Final.Recipe_book;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the storage and manipulation of ingredients both locally and by default settings.
 */
public class IngredientManager {
    /**
     * Local storage of ingredients and their caloric values per cup.
     */
    public static Map<String, Integer> localIngredientList = new HashMap<>();

    /**
     * Default storage of ingredients and their caloric values per cup.
     */
    public static Map<String, Integer> defaultIngredientList = new HashMap<>();

    private static IngredientManager instance = new IngredientManager();

    /**
     * Private constructor to prevent instantiation.
     */
    private IngredientManager() {}

    /**
     * Provides access to the single instance of IngredientManager.
     * @return the single instance of IngredientManager.
     */
    public static IngredientManager getInstance() {
        return instance;
    }

    /**
     * Updates or adds an ingredient's calories per cup in the local list.
     * @param ingredientName the name of the ingredient.
     * @param caloriesPerCup the caloric value per cup of the ingredient.
     */
    public static void updateLocalIngredient(String ingredientName, Integer caloriesPerCup) {
        localIngredientList.put(ingredientName, caloriesPerCup);
    }

    /**
     * Retrieves the calorie count per cup of a given ingredient from the local list.
     * @param ingredientName the name of the ingredient.
     * @return the calorie count per cup of the ingredient.
     */
    public static double getCaloriesPerCup(String ingredientName) {
        return localIngredientList.getOrDefault(ingredientName, 0);
    }

    /**
     * Updates or adds an ingredient's calories per cup in the default list.
     * @param ingredientName the name of the ingredient.
     * @param caloriesPerCup the caloric value per cup of the ingredient.
     */
    public static void updateDefaultIngredient(String ingredientName, Integer caloriesPerCup) {
        defaultIngredientList.put(ingredientName, caloriesPerCup);
    }

    /**
     * Retrieves the calorie count per cup of a given ingredient from the local list.
     * @param ingredientName the name of the ingredient.
     * @return the calorie count per cup of the ingredient if it exists, null otherwise.
     */
    public static int getLocalIngredientCalories(String ingredientName) {
        return localIngredientList.get(ingredientName);
    }

    /**
     * Retrieves the calorie count per cup of a given ingredient from the default list.
     * @param ingredientName the name of the ingredient.
     * @return the calorie count per cup of the ingredient if it exists, null otherwise.
     */
    public static int getDefaultIngredientCalories(String ingredientName) {
        return defaultIngredientList.get(ingredientName);
    }

    /**
     * Checks if an ingredient exists in the local list.
     * @param ingredientName the name of the ingredient.
     * @return true if the ingredient exists in the local list, false otherwise.
     */
    public static boolean ingredientExists(String ingredientName) {
        return localIngredientList.containsKey(ingredientName);
    }

    /**
     * Adds an ingredient and its calories per cup to the local list.
     * @param ingredientName the name of the ingredient.
     * @param caloriesPerCup the caloric value per cup of the ingredient.
     */
    public static void addIngredient(String ingredientName, Integer caloriesPerCup) {
        localIngredientList.put(ingredientName, caloriesPerCup);
    }

    /**
     * Returns the local list of ingredients.
     * @return a map of ingredient names to their caloric values.
     */
    public Map<String, Integer> getLocalIngredientList() {
        return localIngredientList;
    }
}
