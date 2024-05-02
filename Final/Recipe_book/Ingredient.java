package Final.Recipe_book;

/**
 * Represents an ingredient with a name and caloric value per cup.
 */
public class Ingredient {
    /**
     * The name of the ingredient.
     */
    private String ingredientName;

    /**
     * Calories per cup of the ingredient.
     */
    private double caloriesPerCup;

    /**
     * Constructs a new Ingredient object with specified name and calories per cup.
     * @param ingredientName the name of the ingredient.
     * @param caloriesPerCup the caloric value per cup of the ingredient.
     */
    public Ingredient(String ingredientName, double caloriesPerCup) {
        this.ingredientName = ingredientName;
        this.caloriesPerCup = caloriesPerCup;
    }

    /**
     * Updates or adds an ingredient's details in the local list.
     * If the ingredient exists and the calorie count differs, it updates; otherwise, it adds a new ingredient.
     * @param ingredientName the name of the ingredient to update or add.
     * @param caloriesPerCup the new caloric value per cup.
     */
    public static void updateIngredient(String ingredientName, Integer caloriesPerCup) {
        if (IngredientManager.localIngredientList.containsKey(ingredientName)) {
            double currentCalories = IngredientManager.localIngredientList.get(ingredientName);
            if (currentCalories != caloriesPerCup) {
                IngredientManager.localIngredientList.put(ingredientName, caloriesPerCup);
            }
        } else {
            addIngredientLocal(ingredientName, caloriesPerCup);
        }
    }

    /**
     * Adds a new ingredient to the local list if it does not already exist, preventing duplicates.
     * @param ingredientName the name of the ingredient.
     * @param caloriesPerCup the caloric value per cup.
     */
    private static void addIngredientLocal(String ingredientName, Integer caloriesPerCup) {
        if (!IngredientManager.localIngredientList.containsKey(ingredientName)) {
            IngredientManager.localIngredientList.put(ingredientName, caloriesPerCup);
        } else {
            System.out.println("Error: Ingredient exists");
        }
    }

    /**
     * Adds a new ingredient to the default list for long-term storage if it does not already exist.
     * @param ingredientName the name of the ingredient.
     * @param caloriesPerCup the caloric value per cup.
     */
    public static void addIngredientDefault(String ingredientName, Integer caloriesPerCup) {
        if (!IngredientManager.defaultIngredientList.containsKey(ingredientName)) {
            IngredientManager.defaultIngredientList.put(ingredientName, caloriesPerCup);
        } else {
            System.out.println("Error: Ingredient exists");
        }
    }

    /**
     * Retrieves the name of an ingredient from the local list if it exists.
     * @param ingredientName the name of the ingredient to retrieve.
     * @return the name of the ingredient or an error message if not found.
     */
    public static String getIngredientName(String ingredientName) {
        if (IngredientManager.localIngredientList.containsKey(ingredientName)) {
            return ingredientName;
        } else {
            return "Error: Ingredient not found";
        }
    }

    /**
     * Retrieves the calorie count per cup for an ingredient from the local list if it exists.
     * @param ingredientName the name of the ingredient to check.
     * @return the calorie count per cup or -1 if the ingredient is not found.
     */
    public static double getCaloriesPerCup(String ingredientName) {
        if (IngredientManager.localIngredientList.containsKey(ingredientName)) {
            return IngredientManager.localIngredientList.get(ingredientName);
        } else {
            return -1; 
        }
    }
}
