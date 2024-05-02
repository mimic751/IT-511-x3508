package Archive.SteppingStones;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SteppingStone5 {
    private Scanner scnr = new Scanner(System.in);
    //initializes array of recipes
    private List<Recipe> recipes = new ArrayList<>();
    
    //creates a recipe class with name, ingredients, quantities, and units
    class Recipe {
        private String name;
        private List<String> ingredients;
        private List<Double> quantities;
        private List<String> units;
      
      //constructor for recipe
      public Recipe(String name) {
            this.name = name;
            this.ingredients = new ArrayList<>();
            this.quantities = new ArrayList<>();
            this.units = new ArrayList<>();
        }

        //adds ingredients to the recipe
        public void addIngredient(String ingredient, double quantity, String unit) {
            ingredients.add(ingredient);
            quantities.add(quantity);
            units.add(unit);
        }
        //displays the recipe
        public void displayRecipe() {
            System.out.println("Recipe Name: " + name);
            System.out.println("Ingredient List: ");
            for (int i = 0; i < ingredients.size(); i++) {
                System.out.println("     "+ingredients.get(i) + ", "+ quantities.get(i) + " " + units.get(i));
            }
        }

        public String getName() {
            return name;
        }
    }
    //this is a crappy way of doing it and will be removed if made with a prper ui
    private void clearScreen() {
        System.out.println("\n".repeat(30)); 
    }
    
    //adds a recipe to the list of recipes
    public void addRecipe() {
        clearScreen();
        System.out.println("Please enter the recipe name: ");
        String recipeName = scnr.nextLine();
        Recipe recipe = new Recipe(recipeName);
        boolean addMoreIngredients = true;
        //asks the user if they would like to add ingredients and starts the ingredient logic loop
        do {
            System.out.println("Would you like to enter an ingredient? (y or n)");
            String reply = scnr.next().toLowerCase();
            clearScreen();
            scnr.nextLine();  
            //if the user wants to add ingredients, it will ask if they want to add multiple ingredients
            if (reply.equals("y")) {
                System.out.println("Would you like to enter multiple ingredients? (y or n)");
                reply = scnr.next().toLowerCase();
                scnr.nextLine();
                clearScreen();
                //if the user wants to add multiple ingredients, it will start the loop to add ingredients
                if (reply.equals("y")) {
                    do {
                        System.out.println("Ingredients already added: " + recipe.ingredients);
                        System.out.println("Next ingredient (or press enter to finish):");
                        String ingredient = scnr.nextLine();
                        clearScreen();
                        //if the user enters an ingredient, it will ask for the quantity and unit
                        if (!ingredient.isEmpty()) {
                            System.out.println("Please enter the quantity:");
                            double quantity = scnr.nextDouble();
                            scnr.nextLine();  
                            clearScreen();
                            System.out.println("Please enter the unit (e.g., grams, liters):");
                            String unit = scnr.nextLine();
                            clearScreen();
                            recipe.addIngredient(ingredient, quantity, unit);
                            clearScreen();
                        } else {
                            break;
                        }
                    } while (true);
                    //asks the user if they are done adding ingredients
                    System.out.println("Are you done? (y to confirm)");
                    reply = scnr.next().toLowerCase();
                    scnr.nextLine();
                    addMoreIngredients = !reply.equals("y");
                    clearScreen();
                    //if the user does not want to add multiple ingredients, it will ask for the ingredient, quantity, and unit
                } else if (reply.equals("n")) {
                    System.out.println("Please enter the ingredient:");
                    String ingredient = scnr.nextLine();
                    clearScreen();
                    System.out.println("Please enter the quantity:");
                    double quantity = scnr.nextDouble();
                    scnr.nextLine(); 
                    clearScreen();
                    System.out.println("Please enter the unit (e.g., grams, liters):");
                    String unit = scnr.nextLine();
                    clearScreen();
                    recipe.addIngredient(ingredient, quantity, unit);
                    addMoreIngredients = false;
                    clearScreen();
                }
                //if the user does not want to add ingredients, it will exit the loop
            } else if (reply.equals("n")) {
                addMoreIngredients = false;
                clearScreen();
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
                clearScreen();
            }
        } while (addMoreIngredients);
        
        //adds the recipe to the list of recipes
        recipes.add(recipe);
        clearScreen();
    }
    
    //lists the recipes and allows the user to select a recipe
    public void listAndSelectRecipe() {
        clearScreen();
        //if there are no recipes, it will print that there are no recipes
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
            return;
        }

        //  lists the recipes
        System.out.println("Available Recipes:");
        for (int i = 0; i < recipes.size(); i++) {
            System.out.println((i + 1) + ": " + recipes.get(i).getName());
        }
        System.out.println(recipes.size() + 1 + ": Exit to main menu");
        
        //selects a recipe
        System.out.println("Select a recipe number:");
        int index = scnr.nextInt() - 1;
        scnr.nextLine(); 
        if (index >= 0 && index < recipes.size()) {
            clearScreen();
            recipes.get(index).displayRecipe();
        } else if (index == recipes.size()) {
        } else {
            System.out.println("Invalid selection.");
        }
    }

    //shows the menu
    public void showMenu() {
        if (recipes.isEmpty()) {
            clearScreen();
        }
        while (true) {
            System.out.println("1. Add a new recipe");
            System.out.println("2. List all recipes");
            System.out.println("3. Exit");

            System.out.println("Enter your choice:");
            int choice = scnr.nextInt();
            scnr.nextLine(); 

            switch (choice) {
                case 1:
                    addRecipe();
                    break;
                case 2:
                    listAndSelectRecipe();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please enter 1, 2, or 3.");
                    break;
            }
        }
    }

    public static void main() {
        new SteppingStone5().showMenu();
    }
}
