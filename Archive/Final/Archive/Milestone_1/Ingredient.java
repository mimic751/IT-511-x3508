package Archive.Final.Archive.Milestone_1;
import java.util.Map;
import java.util.HashMap;
// there is a bunch of setup for this to work
//part of it is intializing the lists

// Static maps to simulate the global variables
private static Map<String, Double> localIngredientList = new HashMap<>();
private static Map<String, Double> defaultIngredientList = new HashMap<>();


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
        if (localIngredientList.containsKey(ingredientName)) {
            // If found, update calorie count if different
            double currentCalories = localIngredientList.get(ingredientName);
            if (currentCalories != caloriesPerCup) {
                localIngredientList.put(ingredientName, caloriesPerCup);
            }
        } else {
            // If not found, add new ingredient to local list
            addIngredientLocal(ingredientName, caloriesPerCup);
        }
    }

    // Add new ingredient to local list
    private static void addIngredientLocal(String ingredientName, double caloriesPerCup) {
        // Check if ingredient already exists to prevent duplicates
        if (!localIngredientList.containsKey(ingredientName)) {
            // Add new ingredient to local list
            localIngredientList.put(ingredientName, caloriesPerCup);
        } else {
            System.out.println("Error: Ingredient exists");
        }
    }

    // Add new ingredient to default list for long-term storage
    public static void addIngredientDefault(String ingredientName, double caloriesPerCup) {
        // Check if ingredient already exists in default list
        if (!defaultIngredientList.containsKey(ingredientName)) {
            // Add new ingredient to default list
            defaultIngredientList.put(ingredientName, caloriesPerCup);
        } else {
            System.out.println("Error: Ingredient exists");
        }
    }

    // Retrieve an ingredient's name from the local list
    public static String getIngredientName(String ingredientName) {
        // Check if ingredient exists in local list
        if (localIngredientList.containsKey(ingredientName)) {
            return ingredientName;
        } else {
            return "Error: Ingredient not found";
        }
    }

    // Retrieve calorie count per cup for an ingredient from the local list
    public static double getCaloriesPerCup(String ingredientName) {
        // Check if ingredient exists in local list
        if (localIngredientList.containsKey(ingredientName)) {
            return localIngredientList.get(ingredientName);
        } else {
            return -1; 
        }
    }

    // Synchronize local ingredient list with default list
    public static void syncIngredientLists() {
        // Loop through local list and add/update entries in default list as necessary
        for (Map.Entry<String, Double> entry : localIngredientList.entrySet()) {
            String key = entry.getKey();
            double value = entry.getValue();
            // If ingredient not found in default list or calories per cup not equal, update default list
            if (!defaultIngredientList.containsKey(key) || !defaultIngredientList.get(key).equals(value)) {
                addIngredientDefault(key, value);
            }
        }
    }

// I would have a method here to save the default ingredient list to a file. I did not want to add it here because I honestly have not researched it yet
// I will have this in the final version

}
