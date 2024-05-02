package Final.Recipe_book;

import java.util.HashMap;
import java.util.Map;

public class Recipe_Test {
    public static void main(String[] args) {
        // Add ingredients
        addIngredients();

        // Create recipes
        createRecipes();

        // List all recipes
        listRecipes();

        // List all ingredients and their calories
        listingredients();

        // Display details of the Chocolate Cake
        printSpecificRecipe("Chocolate Cake");
    }

    private static void addIngredients() {
        IngredientManager.addIngredient("Flour", 455);  
        IngredientManager.addIngredient("Sugar", 773);
        IngredientManager.addIngredient("Egg", 78);     
        IngredientManager.addIngredient("Milk", 103);  
        IngredientManager.addIngredient("Butter", 1628);
    }

    private static void createRecipes() {
        Map<String, Double> ingredientsChocolateCake = new HashMap<>();
        ingredientsChocolateCake.put("Flour", 2.0);
        ingredientsChocolateCake.put("Sugar", 1.5);
        ingredientsChocolateCake.put("Butter", 0.5);

        Map<String, Double> ingredientsPancake = new HashMap<>();
        ingredientsPancake.put("Flour", 1.0);
        ingredientsPancake.put("Milk", 0.5);
        ingredientsPancake.put("Egg", 2.0);

        Map<String, Double> ingredientsOmelette = new HashMap<>();
        ingredientsOmelette.put("Egg", 3.0);
        ingredientsOmelette.put("Milk", 0.2);
        ingredientsOmelette.put("Butter", 0.1);

        RecipeManager.getInstance().addRecipeLocal(new Recipe("Chocolate Cake", 4, ingredientsChocolateCake));
        RecipeManager.getInstance().addRecipeLocal(new Recipe("Pancake", 2, ingredientsPancake));
        RecipeManager.getInstance().addRecipeLocal(new Recipe("Omelette", 1, ingredientsOmelette));
    }

    private static void listRecipes() {
        Map<String, Recipe> localRecipes = RecipeManager.getInstance().getLocalRecipeList();
        System.out.println("Available Recipes:");
        localRecipes.keySet().forEach(System.out::println);
    }

    private static void listingredients() {
        Map<String, Integer> localIngredients = IngredientManager.getInstance().getLocalIngredientList(); 
        System.out.println("Available ingredients and their calories per cup:");
        localIngredients.forEach((ingredient, calories) -> {
            System.out.println(ingredient + ": " + calories + " cal/cup");
        });
    }


    private static void printSpecificRecipe(String recipeName) {
        Recipe recipe = RecipeManager.getInstance().getRecipe(recipeName);
        if (recipe != null) {
            recipe.printRecipe();
        } else {
            System.out.println("Recipe not found: " + recipeName);
        }
    }
}
