/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week10;

/**
 * Object class for Jon's Food Consumption simulator
 *
 * @author Jonathan
 */
public class FoodItem {

    //member variables, accessed by loadNutritionFacts method in FoodLand.java
    public String name;
    public int servingsPerContainer;
    public double servingSize;
    public String servingSizeUnit;
    public int servingCalories;
    public int sodiumMG;
    public int sodiumDV;
    public int eatServings;
    public static int totalCaloriesConsumed = 0;
    public static int totalSodiumConsumed = 0;
    public static int totalSodiumDVConsumed = 0;

    /**
     * This method displays the nutrition information of a food item.
     */
    public void itemInfo() {
        System.out.println();
        System.out.println("NUTRITION INFORMATION:");
        System.out.println("Name of food: " + name);
        System.out.println("Servings per container " + servingsPerContainer);
        System.out.println("Serving size: " + servingSize + " " + servingSizeUnit);
        System.out.println("Calories per serving: " + servingCalories);
        System.out.println("Sodium per serving (mg): " + sodiumMG);
        System.out.println("Daily Value (%) of sodium per serving: " + sodiumDV + "%");
        System.out.println();
    } //close itemInfo method

    /**
     * This method simulates eating the user's food of choice.
     *
     * @param servings This is the number of servings the user chose to eat.
     */
    public void eatFood(int servings) {
        int caloriesConsumed = (servingCalories * servings);
        int sodiumConsumed = (sodiumMG * servings);
        int sodiumDVConsumed = (sodiumDV * servings);
        totalCaloriesConsumed = totalCaloriesConsumed + caloriesConsumed;
        totalSodiumConsumed = totalSodiumConsumed + sodiumConsumed;
        totalSodiumDVConsumed = totalSodiumDVConsumed + sodiumDVConsumed;
        System.out.println();
        System.out.println("You have just consumed...");
        System.out.print(caloriesConsumed + " calories and ");
        System.out.println(sodiumConsumed + " mg of sodium.");
        System.out.println("(" + sodiumDVConsumed + "% of the Daily Value of sodium)");
        System.out.println();
        System.out.println("TOTAL CONSUMED:");
        System.out.print(totalCaloriesConsumed + " calories and ");
        System.out.println(totalSodiumConsumed + " mg of sodium.");
        System.out.println("(" + totalSodiumDVConsumed + "% Daily Value of sodium)");
        System.out.println();
        if (totalSodiumDVConsumed > 1000) {
            System.out.println("YOU'VE EXCEEDED 1000% DAILY VALUE OF SODIUM!");
            System.out.println("I've called 911 to get you to the emergency room.");
            System.out.println("Good luck!");
        } else if (totalSodiumDVConsumed > 500) {
            System.out.println("*****DANGER!!!*****");
            System.out.println("YOU'VE EXCEEDED 500% DAILY VALUE OF SODIUM!");
            System.out.println("YOU NEED TO STOP RIGHT NOW!");
        } else if (totalSodiumDVConsumed > 100) {
            System.out.println("*****WARNING!!!*****");
            System.out.println("YOU'VE EXCEEDED 100% DAILY VALUE OF SODIUM!");
            System.out.println("CHECK YOURSELF BEFORE YOU WRECK YOURSELF!");
        }

    }
} //close eatFood method
