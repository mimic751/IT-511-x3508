package Final.Milestone_2.Recipe_book;

public class Ingredient {
    // Variables to store ingredient details
    private String ingredientName;
    private double caloriesPerCup;

    // Constructor to create a new Ingredient object
    public Ingredient(String ingredientName, double caloriesPerCup) {
        this.ingredientName = ingredientName;
        this.caloriesPerCup = caloriesPerCup;
    }

    // Update or add ingredient details in local list
    public static void updateIngredient(String ingredientName, double caloriesPerCup) {
        // Check if ingredient exists in local list
        if (IngredientManager.localIngredientList.containsKey(ingredientName)) {
            // If found, update calorie count if different
            double currentCalories = IngredientManager.localIngredientList.get(ingredientName);
            if (currentCalories != caloriesPerCup) {
                IngredientManager.localIngredientList.put(ingredientName, caloriesPerCup);
            }
        } else {
            // If not found, add new ingredient to local list
            addIngredientLocal(ingredientName, caloriesPerCup);
        }
    }

    // Add new ingredient to local list
    private static void addIngredientLocal(String ingredientName, double caloriesPerCup) {
        // Check if ingredient already exists to prevent duplicates
        if (!IngredientManager.localIngredientList.containsKey(ingredientName)) {
            // Add new ingredient to local list
            IngredientManager.localIngredientList.put(ingredientName, caloriesPerCup);
        } else {
            System.out.println("Error: Ingredient exists");
        }
    }

    // Add new ingredient to default list for long-term storage
    public static void addIngredientDefault(String ingredientName, double caloriesPerCup) {
        // Check if ingredient already exists in default list
        if (!IngredientManager.defaultIngredientList.containsKey(ingredientName)) {
            // Add new ingredient to default list
            IngredientManager.defaultIngredientList.put(ingredientName, caloriesPerCup);
        } else {
            System.out.println("Error: Ingredient exists");
        }
    }

    // Retrieve an ingredient's name from the local list
    public static String getIngredientName(String ingredientName) {
        // Check if ingredient exists in local list
        if (IngredientManager.localIngredientList.containsKey(ingredientName)) {
            return ingredientName;
        } else {
            return "Error: Ingredient not found";
        }
    }

    // Retrieve calorie count per cup for an ingredient from the local list
    public static double getCaloriesPerCup(String ingredientName) {
        // Check if ingredient exists in local list
        if (IngredientManager.localIngredientList.containsKey(ingredientName)) {
            return IngredientManager.localIngredientList.get(ingredientName);
        } else {
            return -1; 
        }
    }

}
