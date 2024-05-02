package Final.Recipe_book;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Manages the recipes stored both locally and in a default list, allowing for creation, updating, and retrieval of recipes.
 */
public class RecipeManager {
    /**
     * A map to store recipes locally.
     */
    private Map<String, Recipe> localRecipeList = new HashMap<>();

    /**
     * A map to store recipes for long-term or default storage.
     */
    private Map<String, Recipe> defaultRecipeList = new HashMap<>();

    private static RecipeManager instance = new RecipeManager();

    /**
     * Private constructor to prevent external instantiation.
     */
    private RecipeManager() {}

    /**
     * Provides access to the singleton instance of RecipeManager.
     * @return the singleton instance of RecipeManager.
     */
    public static RecipeManager getInstance() {
        return instance;
    }

    /**
     * Updates an existing recipe or adds a new recipe if it does not exist in the local list.
     * @param recipeName the name of the recipe to update or add.
     * @param servings the number of servings for the recipe.
     * @param ingredients the map of ingredients and their quantities.
     */
    public void updateRecipe(String recipeName, int servings, Map<String, Double> ingredients) {
        Recipe recipe = localRecipeList.get(recipeName);
        if (recipe != null) {
            recipe.setServings(servings);
            recipe.updateRecipeIngredients(ingredients);
        } else {
            addRecipeLocal(new Recipe(recipeName, servings, ingredients));
        }
    }

    /**
     * Adds a recipe to the local list if it does not already exist.
     * @param recipe the recipe to add.
     */
    public void addRecipeLocal(Recipe recipe) {
        if (!localRecipeList.containsKey(recipe.getRecipeName())) {
            localRecipeList.put(recipe.getRecipeName(), recipe);
        } else {
            System.out.println("Error: Recipe already exists");
        }
    }

    /**
     * Adds a recipe to the default list if it does not already exist.
     * @param recipe the recipe to add.
     */
    private void addRecipeDefault(Recipe recipe) {
        if (!defaultRecipeList.containsKey(recipe.getRecipeName())) {
            defaultRecipeList.put(recipe.getRecipeName(), new Recipe(recipe.getRecipeName(), recipe.getServings(), recipe.getIngredients()));
        } else {
            System.out.println("Error: Recipe already exists in default list");
        }
    }

    /**
     * Synchronizes the recipes from the local list to the default list.
     */
    public void syncRecipeLists() {
        for (Recipe recipe : localRecipeList.values()) {
            addRecipeDefault(recipe);
        }
    }

    /**
     * Retrieves a recipe by name from the local list.
     * @param recipeName the name of the recipe to retrieve.
     * @return the Recipe object, or null if not found.
     */
    public Recipe getRecipe(String recipeName) {
        return localRecipeList.getOrDefault(recipeName, null);
    }

    /**
     * Saves the current list of recipes to a file (not yet implemented).
     */
    public void saveRecipeList() {
        System.out.println("Method to save list to file is not implemented yet.");
    }

    /**
     * Gets the local list of recipes.
     * @return a map of recipe names to Recipe objects.
     */
    public Map<String, Recipe> getLocalRecipeList() {
        return localRecipeList;
    }

    /**
     * Interactively creates a new recipe using user input, adding it to the local recipe list.
     */
    public void createNewRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter recipe name:");
        String name = scanner.nextLine();
        System.out.println("Enter servings:");
        int servings = Integer.parseInt(scanner.nextLine());
        Map<String, Double> ingredients = new HashMap<>();
        String ingredient;
        
        while (true) {
            System.out.println("Enter ingredient name (type 'done' to finish):");
            ingredient = scanner.nextLine();
            if (ingredient.equalsIgnoreCase("done")) {
                break;
            }
            if (!IngredientManager.ingredientExists(ingredient)) {
                System.out.println("Ingredient not found in the database.");
                System.out.println("Would you like to add it? (yes/no)");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("yes")) {
                    System.out.println("Enter calories per cup for " + ingredient + ":");
                    Integer calories = Integer.parseInt(scanner.nextLine());
                    IngredientManager.addIngredient(ingredient, calories);
                    System.out.println("Ingredient added.");
                } else {
                    continue; // Skip to the next iteration to ask for another ingredient
                }
            }
            System.out.println("Enter amount for " + ingredient + ":");
            double amount = Double.parseDouble(scanner.nextLine());
            ingredients.put(ingredient, amount);
        }
    
        Recipe newRecipe = new Recipe(name, servings, ingredients);
        getInstance().addRecipeLocal(newRecipe);
        System.out.println("Recipe added successfully!");
    }
}
