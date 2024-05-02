package SteppingStones;
import java.util.Scanner;
import java.util.ArrayList;

public class SteppingStone4_Loops {

  public static void main(String[] args) {
    //sets variables
      Scanner scnr = new Scanner(System.in);
      String recipeName = "";
      ArrayList<String> ingredientList = new ArrayList();
      String newIngredient = "";
      boolean addMoreIngredients = true;
      
      System.out.println("Please enter the recipe name: ");
      recipeName = scnr.nextLine();
// this sets a loop that accomodates bad enties and multiple entries
      do {
          System.out.println("Would you like to enter an ingredient? (y or n)");
          String reply = scnr.next().toLowerCase();
          scnr.nextLine(); 
      //enters  ingredient loop
          if (reply.equals("y")) {
              System.out.println("Would you like to enter multiple ingredients? (y or n)");
              reply = scnr.next().toLowerCase();
              scnr.nextLine();
            //enters multiple ingredient loop
              if (reply.equals("y")) {
                  do {
                      System.out.println("Ingredients already added: " + ingredientList);
                      System.out.println("Next ingredient (or press enter to finish):");
                      newIngredient = scnr.nextLine(); 
                    //builds an array and displays it until a null entry is entered. Then asks if you want to exit
                      if (!newIngredient.isEmpty()) {
                          ingredientList.add(newIngredient);
                      }
                  } while (!newIngredient.isEmpty());
      
                  System.out.println("Are you done? (y to confirm)");
                  reply = scnr.next().toLowerCase();
                  scnr.nextLine(); 
                  addMoreIngredients = !reply.equals("y");
              } else if (reply.equals("n")) {
              System.out.println("Please enter the ingredient:");
              newIngredient = scnr.nextLine();
              ingredientList.add(newIngredient);
              addMoreIngredients = false;
              }
          } else if (reply.equals("n")) {
              addMoreIngredients = false;
          } else {
              System.out.println("Invalid input. Please enter 'y' or 'n'.");
          }
      } while (addMoreIngredients);
    //formatted the display a little bit. I wanted it to display the recipe name then off set the entire list of ingredients
      System.out.println("Recipe Name: " + recipeName);
      System.out.println("Ingredients:");
      for (String ingredient : ingredientList) {
          System.out.println("            " + ingredient);
      }
      
  }
}



