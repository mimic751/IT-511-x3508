package SteppingStones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *package SteppingStones;

/**
 *
 * @author snhu.edu
 */

import java.util.Scanner;

public class SteppingStone2_IngredientCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String nameOfIngredient = "";
       float numberCups = 0;
       int numberCaloriesPerCup = 0;
       double totalCalories = 0.0;
       
       Scanner scnr = new Scanner(System.in);
       
       System.out.println("Please enter the name of the ingredient: ");
       nameOfIngredient = scnr.next();
       

       //another method would be to have a recursive calling of methods I think. 
       do {
        System.out.println("Please enter the number of cups of " + nameOfIngredient + " we'll need: ");
        numberCups = scnr.nextFloat();
        if (numberCups < 1 || numberCups > 100) {
            System.out.println(numberCups + " is not a valid number of cups!");
            System.out.println("Please enter another number of cups between 1 and 100.");
        }
        } while (numberCups < 1 || numberCups > 100);
       
       System.out.println("Please enter the name of calories per cup: ");
       numberCaloriesPerCup = scnr.nextInt();
       
       totalCalories = numberCups * numberCaloriesPerCup;
       
       System.out.println(nameOfIngredient + " uses " + numberCups + " cups and has " + totalCalories + " calories.");
       
    }
    
}
