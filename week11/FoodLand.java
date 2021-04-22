/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week11;

import java.util.Scanner;

/**
 * Client class for Jon's Food Consumption simulator
 *
 * @author Jonathan
 */
public class FoodLand {

    //initiate FoodItem variables, one for each food
    public static FoodItem jonRasinBran = new FoodItem();
    public static FoodItem leweyRamen = new FoodItem();
    public static FoodItem jacobLifeSavers = new FoodItem();
    public static FoodItem robPopTarts = new FoodItem();
    //food names as strings
    public static String jonFood = "Jon's Rasin Bran";
    public static String leweyFood = "Lewey's Ramen Noodles";
    public static String jacobFood = "Jacob's Life Savers";
    public static String robFood = "Rob's Cinnamon Pop Tarts";

    public static void main(String[] args) {

        loadNutritionFacts(); //calls method that loads nutrition facts for all items
        int foodChoice;
        int eatServings;
        boolean loopProgram = true;
        boolean validChoice = false;

        System.out.println("Welcome to Jon's Food Consumption Simulator!");
        do {
            Scanner userInput = new Scanner(System.in);
            System.out.println();
            System.out.println("Enter the number of the food you want to eat:");
            System.out.println("1. " + jonFood);
            System.out.println("2. " + leweyFood);
            System.out.println("3. " + jacobFood);
            System.out.println("4. " + robFood);
            System.out.println("0. EXIT THE PROGRAM, I'M FULL!");
            //int validation block
            do {
                while (!userInput.hasNextInt()) {
                    System.out.println("Enter a valid choice:");
                    userInput.next();
                }
                foodChoice = userInput.nextInt();
                //
                switch (foodChoice) {
                    case 1:
                        jonRasinBran.itemInfo();
                        validChoice = true;
                        break;
                    case 2:
                        leweyRamen.itemInfo();
                        validChoice = true;
                        break;
                    case 3:
                        jacobLifeSavers.itemInfo();
                        validChoice = true;
                        break;
                    case 4:
                        robPopTarts.itemInfo();
                        validChoice = true;
                        break;
                    case 0: //this case ends the program
                        System.out.println();
                        System.out.println("I'm glad you're full!");
                        System.out.println();
                        loopProgram = false;
                        //allows the program to end by stopping the question-asking loop
                        break;
                    default:
                        System.out.println("Enter a valid choice:");
                }
            } while (validChoice == false);
            //The program only asks/calculates servings if loopProgram == true
            if (loopProgram == true) {
                System.out.println("Enter the number of servings to eat:");
                //int validation block
                while (!userInput.hasNextInt()) {
                    System.out.println("Enter a valid choice:");
                    userInput.next();
                }
                eatServings = userInput.nextInt();
                switch (foodChoice) {
                    case 1:
                        jonRasinBran.eatFood(eatServings);
                        break;
                    case 2:
                        leweyRamen.eatFood(eatServings);
                        break;
                    case 3:
                        jacobLifeSavers.eatFood(eatServings);
                        break;
                    case 4:
                        robPopTarts.eatFood(eatServings);
                }

            }

        } while (loopProgram == true);

    } //close main method

    /**
     * This method loads the nutrition facts of each food item into instances of
     * FoodItem.java
     */
    public static void loadNutritionFacts() {
        //Jon's Rasin Bran
        jonRasinBran.name = jonFood;
        jonRasinBran.servingsPerContainer = 12;
        jonRasinBran.servingSize = 1.25;
        jonRasinBran.servingSizeUnit = "cups";
        jonRasinBran.servingCalories = 190;
        jonRasinBran.sodiumMG = 240;
        jonRasinBran.sodiumDV = 11;
        //Lewey's Ramen Noodles
        leweyRamen.name = leweyFood;
        leweyRamen.servingsPerContainer = 1;
        leweyRamen.servingSize = 85;
        leweyRamen.servingSizeUnit = "grams";
        leweyRamen.servingCalories = 380;
        leweyRamen.sodiumMG = 1600;
        leweyRamen.sodiumDV = 69;
        //Jacob's Life Savers
        jacobLifeSavers.name = jacobFood;
        jacobLifeSavers.servingsPerContainer = 7;
        jacobLifeSavers.servingSize = 28;
        jacobLifeSavers.servingSizeUnit = "grams";
        jacobLifeSavers.servingCalories = 90;
        jacobLifeSavers.sodiumMG = 0;
        jacobLifeSavers.sodiumDV = 0;
        //Rob's Cinnamon Pop Tarts
        robPopTarts.name = robFood;
        robPopTarts.servingsPerContainer = 2;
        robPopTarts.servingSize = 1;
        robPopTarts.servingSizeUnit = "pastry";
        robPopTarts.servingCalories = 400;
        robPopTarts.sodiumMG = 340;
        robPopTarts.sodiumDV = 15;

    } //close loadNutritionFacts method

}
