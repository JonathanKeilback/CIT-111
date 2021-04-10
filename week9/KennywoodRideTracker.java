package week9;

import java.util.Random;
import java.util.Scanner;

/**
 * Chunk 2, Mod 3, Exercise 1 (Kennywood Ride Tracker) This program simulates
 * rider groups who ride the Black Widow and Merry Go Round. The number of rider
 * groups & the maximum size of a group is determined by the user. The number of
 * riders in each group is randomly generated, as well as the height of each
 * rider. If one rider in a group is too short for the ride, the entire group is
 * not allowed to ride. If a group gets to ride, then a random number of riders
 * who get sick is generated.
 *
 * @author Jonathan
 */
public class KennywoodRideTracker {

    private static int totalRiders = 0;
    private static int totalGroups = 0;
    private static int totalFailedRideAttampts = 0;
    private static int totalFailedGroups = 0;
    private static int totalSickRiders = 0;
    private static int blackWidowRiders = 0;
    private static int blackWidowGroups = 0;
    private static int blackWidowFailedRideAttampts = 0;
    private static int blackWidowFailedGroups = 0;
    private static int blackWidowSickRiders = 0;
    private static int merryGoRoundRiders = 0;
    private static int merryGoRoundGroups = 0;
    private static int merryGoRoundFailedRideAttampts = 0;
    private static int merryGoRoundFailedGroups = 0;
    private static int merryGoRoundSickRiders = 0;
    private static final int MIN_HEIGHT_INCHES_BW = 52;
    private static final int MIN_HEIGHT_INCHES_MGR = 36;
    private static int maxGroupSize;

    /**
     * This method is the engine that generates rides on the Black Widow.
     *
     * @param groups
     */
    public static void rideBlackWidow(int groups) {
        Random randomizer = new Random();
        while (groups > 0) { //This block of code will loop for each riding group.
            int generatedHeight;
            int shortestHeight = 108; //Upper threshold for determining the shortest rider.
            int riders = randomizer.nextInt(maxGroupSize) + 1; //Randomly generated number of riders per group.
            int riderLooper = riders; //control variable for taking rider's height measurement.
            while (riderLooper > 0) { //Random height generator loop. A height is generated for each rider.
                //The average height of a 2-year old is 34 inches, so that's the minimum for the height generator.
                //The tallest person on Earth was 107 inches tall, so that's the maximum for the height generator.
                generatedHeight = randomizer.nextInt(72) + 35; //nextInt is set to offset the minimum expected rider of 34 inches.
                if (generatedHeight < shortestHeight) {
                    shortestHeight = generatedHeight; //the shortest rider determines if the group gets to ride.
                }
                riderLooper = riderLooper - 1;
            }
            if (shortestHeight >= MIN_HEIGHT_INCHES_BW) { //Block of code for a ride group that was tall enough to ride.
                int sickRiders = randomizer.nextInt(riders);
                totalSickRiders = totalSickRiders + sickRiders;
                blackWidowSickRiders = blackWidowSickRiders + sickRiders;
                totalRiders = totalRiders + riders;
                totalGroups = totalGroups + 1;
                blackWidowRiders = blackWidowRiders + riders;
                blackWidowGroups = blackWidowGroups + 1;

            } else { //Block of code for a ride group that was too short to ride.
                totalFailedRideAttampts = totalFailedRideAttampts + riders;
                totalFailedGroups = totalFailedGroups + 1;
                blackWidowFailedRideAttampts = blackWidowFailedRideAttampts + riders;
                blackWidowFailedGroups = blackWidowFailedGroups + 1;
            }
            groups = groups - 1;
        }
    } //close rideBlackWidow

    /**
     * This method is the engine that generates rides on the Merry Go Round.
     *
     * @param groups
     */
    public static void rideMerryGoRound(int groups) {
        Random randomizer = new Random();
        while (groups > 0) { //This block of code will loop for each riding group.
            int generatedHeight;
            int shortestHeight = 108; //Upper threshold for determining the shortest rider.
            int riders = randomizer.nextInt(maxGroupSize) + 1; //Randomly generated number of riders per group.
            int riderLooper = riders; //control variable for taking rider's height measurement.
            while (riderLooper > 0) { //Random height generator loop. A height is generated for each rider.
                //The average height of a 2-year old is 34 inches, so that's the minimum for the height generator.
                //The tallest person on Earth was 107 inches tall, so that's the maximum for the height generator.
                generatedHeight = randomizer.nextInt(72) + 35; //nextInt is set to offset the minimum expected rider of 34 inches.
                if (generatedHeight < shortestHeight) {
                    shortestHeight = generatedHeight; //the shortest rider determines if the group gets to ride.
                }
                riderLooper = riderLooper - 1;
            }
            if (shortestHeight >= MIN_HEIGHT_INCHES_MGR) { //Block of code for a ride group that was tall enough to ride.
                int sickRiders = randomizer.nextInt(riders);
                totalSickRiders = totalSickRiders + sickRiders;
                merryGoRoundSickRiders = merryGoRoundSickRiders + sickRiders;
                totalRiders = totalRiders + riders;
                totalGroups = totalGroups + 1;
                merryGoRoundRiders = merryGoRoundRiders + riders;
                merryGoRoundGroups = merryGoRoundGroups + 1;

            } else { //Block of code for a ride group that was too short to ride.
                totalFailedRideAttampts = totalFailedRideAttampts + riders;
                totalFailedGroups = totalFailedGroups + 1;
                merryGoRoundFailedRideAttampts = merryGoRoundFailedRideAttampts + riders;
                merryGoRoundFailedGroups = merryGoRoundFailedGroups + 1;
            }
            groups = groups - 1;
        }
    } //close rideMerryGoRound

    /**
     * This method displays rider stats to the user.
     */
    public static void printRideStats() {
        System.out.println("***** TOTAL RIDER STATS *****");
        System.out.println("Total number of groups who rode: " + totalGroups);
        System.out.println("Total number of riders who rode: " + totalRiders);
        System.out.println("Total number of riders who got sick: " + totalSickRiders);
        System.out.println("Total number of groups turned away: " + totalFailedGroups);
        System.out.println("Total number of riders turned away: " + totalFailedRideAttampts);

        System.out.println();
        System.out.println("***** BLACK WIDOW STATS *****");
        System.out.println("Number of groups who rode: " + blackWidowGroups);
        System.out.println("Number of riders who rode: " + blackWidowRiders);
        System.out.println("Number of riders who got sick: " + blackWidowSickRiders);
        System.out.println("Number of groups turned away: " + blackWidowFailedGroups);
        System.out.println("Number of riders turned away: " + blackWidowFailedRideAttampts);

        System.out.println();
        System.out.println("***** MERRY GO ROUND STATS *****");
        System.out.println("Number of groups who rode: " + merryGoRoundGroups);
        System.out.println("Number of riders who rode: " + merryGoRoundRiders);
        System.out.println("Number of riders who got sick: " + merryGoRoundSickRiders);
        System.out.println("Number of groups turned away: " + merryGoRoundFailedGroups);
        System.out.println("Number of riders turned away: " + merryGoRoundFailedRideAttampts);

        System.out.println();
    } //close printRideStats

    /**
     * Main method: Provides user interface.
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        boolean runAgain = true; //Control variable for looping the program.
        Scanner userInput = new Scanner(System.in);
        System.out.println("*** KENNYWOOD RIDE SIMULATOR ***");
        System.out.println();
        Thread.sleep(2000);
        System.out.println("This program simulates groups of riders who want");
        System.out.println("to ride Black Widow and Merry Go Round at Kennywood.");
        System.out.println();
        Thread.sleep(2000);
        System.out.println("If a member of a group is too short to ride,");
        System.out.println("The entire group will not be permitted to ride.");
        System.out.println();
        Thread.sleep(2000);
        System.out.println("Some riders will get sick!");
        System.out.println();
        Thread.sleep(2000);
        System.out.println("Group sizes and rider heights are randomized.");
        Thread.sleep(2000);
        do { //Main program loop: allows the user to calculate additional rides at the end of the program, if they choose so.
            System.out.println();
            System.out.println("Enter the number of groups riding Black Widow:");
            //User inputs the number of groups who will try to ride the Black Widow.
            while (!userInput.hasNextInt()) { //Validation block.
                System.out.println("Enter a valid number:");
                userInput.next();
            }
            int blackWidowGroups = userInput.nextInt();
            System.out.println("Enter the number of groups riding the Merry Go Round:");
            //User inputs the number of groups who will try to ride the Merry Go Round.
            while (!userInput.hasNextInt()) { //Validation block.
                System.out.println("Enter a valid number:");
                userInput.next();
            }
            int merryGoRoundGroups = userInput.nextInt();
            System.out.println("Enter the maximum number of riders permitted in a riding group:");
            //User determines the maximum number of potential riders in a riding group.
            while (!userInput.hasNextInt()) { //Validation block.
                System.out.println("Enter a valid number:");
                userInput.next();
            }
            maxGroupSize = userInput.nextInt();
            System.out.println();
            System.out.println("Calculating rides!");
            System.out.println();
            Thread.sleep(1500);
            rideBlackWidow(blackWidowGroups); //Calls rideBlackWidow method to calculate rides.
            rideMerryGoRound(merryGoRoundGroups); //Calls merryGoRound method to calculate rides.
            printRideStats(); //Displays stats of successful rides, rejected rides, and sick riders.
            Thread.sleep(1500);
            System.out.println("Would you like to process any additional groups?");
            System.out.println("Enter 1 for YES. Enter anything else for NO.");
            System.out.println("Type your selection and press ENTER.");
            String rideAgain = userInput.next();
            switch (rideAgain) {
                case "1":
                    break;
                default:
                    runAgain = false;
                    System.out.println();
                    System.out.println("Thanks for using the Kennywood Ride Simulator!");
            }
        } while (runAgain == true); //End of main program loop.

    } //close main
} //close class
