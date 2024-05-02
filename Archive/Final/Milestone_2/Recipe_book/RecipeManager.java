package Final.Milestone_2.Recipe_book;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecipeManager {
    private Map<String, Recipe> localRecipeList = new HashMap<>();
    private Map<String, Recipe> defaultRecipeList = new HashMap<>();

    private static RecipeManager instance = new RecipeManager();

    private RecipeManager() {}

    public static RecipeManager getInstance() {
        return instance;
    }

    public void updateRecipe(String recipeName, int servings, Map<String, Double> ingredients) {
        Recipe recipe = localRecipeList.get(recipeName);
        if (recipe != null) {
            recipe.setServings(servings);
            recipe.updateRecipeIngredients(ingredients);
        } else {
            addRecipeLocal(new Recipe(recipeName, servings, ingredients));
        }
    }

    public void addRecipeLocal(Recipe recipe) {
        if (!localRecipeList.containsKey(recipe.getRecipeName())) {
            localRecipeList.put(recipe.getRecipeName(), recipe);
        } else {
            System.out.println("Error: Recipe already exists");
        }
    }

    private void addRecipeDefault(Recipe recipe) {
        if (!defaultRecipeList.containsKey(recipe.getRecipeName())) {
            defaultRecipeList.put(recipe.getRecipeName(), new Recipe(recipe.getRecipeName(), recipe.getServings(), recipe.getIngredients()));
        } else {
            System.out.println("Error: Recipe already exists in default list");
        }
    }

    public void syncRecipeLists() {
        for (Recipe recipe : localRecipeList.values()) {
            addRecipeDefault(recipe);
        }
    }

    public Recipe getRecipe(String recipeName) {
        return localRecipeList.getOrDefault(recipeName, null);
    }

    public void saveRecipeList() {
        System.out.println("Method to save list to file is not implemented yet.");
    }
    
    public Map<String, Recipe> getLocalRecipeList() {
        return localRecipeList;
    }

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
                    double calories = Double.parseDouble(scanner.nextLine());
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
