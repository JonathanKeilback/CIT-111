package week8;

import java.util.Scanner;

/**
 * Chunk 2, Mod 2, Unit Converter mini-project.
 * This program provides imperial & metric conversion for hospital patient height & weight.
 *
 * @author Jonathan
 */
public class UnitConverter {

    /**
     * Main Method
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to the UPMC Imperial & Metric conversion program.");
        Thread.sleep(2000);
        System.out.println("Since we cannot seem to consistently use one system,");
        Thread.sleep(2000);
        System.out.println("this program will help alleviate your conversion headaches.");
        Thread.sleep(2000);
        boolean loopConverter = true;
        do { //start of loop. The user can perform more than one conversion by using this loop.
            int converterChoice = chooseConverter(); //calls method that allows the user to choose the conversion type.
            switch (converterChoice) { //this switch customizes the text displayed to the user.
                case 1:
                    System.out.println("Type inches to convert and press Enter:");
                    break;
                case 2:
                    System.out.println("Type centimeters to convert and press Enter:");
                    break;
                case 3:
                    System.out.println("Type pounds to convert and press Enter:");
                    break;
                case 4:
                    System.out.println("Type kilograms to convert and press Enter:");
            }
            double valueToConvert = enterValue(); //calls method that asks user to enter the value to convert.
            switch (converterChoice) { //switches value to the appropriate converter.
                case 1:
                    inToCm(valueToConvert);
                    break;
                case 2:
                    cmToIn(valueToConvert);
                    break;
                case 3:
                    lbToKg(valueToConvert);
                    break;
                case 4:
                    kgToLb(valueToConvert);
            }
            Thread.sleep(1000);
            //asks user if they want to convert again, or end the program.
            System.out.println("Type 1 and press Enter to perform another conversion.");
            System.out.println("Type anything else and press Enter to exit the program.");
            Scanner userInput = new Scanner(System.in);
            String convertAgain = userInput.next();
            switch (convertAgain) {
                case "1":
                    break;
                default:
                    loopConverter = false;
                    System.out.println();
                    System.out.println("Have a wonderful UPMC day!");
            }
        } while (loopConverter == true); //end loop
    } //close main method

    /**
     * This method asks the user to choose a conversion type.
     *
     * @return Returns the user's choice to switches in the main method.
     * @throws InterruptedException
     */
    public static int chooseConverter() throws InterruptedException {
        System.out.println();
        System.out.println("Choose a converter to use:");
        System.out.println();
        System.out.println("Patient height:");
        System.out.println("1. inches to centimeters");
        System.out.println("2. centimeters to inches");
        System.out.println();
        System.out.println("Patient weight:");
        System.out.println("3. pounds to kilograms");
        System.out.println("4. kilograms to pounds");
        System.out.println();
        Scanner userInput = new Scanner(System.in);
        int userChoice;
        do { //validation block
            System.out.println("Type the number of your selection and press Enter:");
            while (!userInput.hasNextInt()) {
                System.out.println("Type the number of your selection and press Enter:");
                userInput.next();
            }
            userChoice = userInput.nextInt();
        } while ((userChoice <= 0) || (userChoice >= 5));
        return userChoice;
    } //close chooseConverter method

    /**
     * This method records the user's desired value to convert.
     *
     * @return Returns the number that the user wants to convert.
     */
    public static double enterValue() {
        Scanner userInput = new Scanner(System.in);
        double userChoice;
        while (!userInput.hasNextDouble()) { //validation block
            System.out.println("Please enter a valid number.");
            userInput.next();
        }
        userChoice = userInput.nextDouble();
        return userChoice;
    } //close enterValue method

    /**
     * This method performs the calculation to convert in to cm.
     *
     * @param valueToConvert This value is what the user wants to convert.
     */
    public static void inToCm(double valueToConvert) {
        double finalResult = valueToConvert * 2.54;
        System.out.println(valueToConvert + " inches converts to " + finalResult + " centimeters.");
        System.out.println();
    } //close inToCm method

    /**
     * This method performs the calculation to convert cm to in.
     *
     * @param valueToConvert This value is what the user wants to convert.
     */
    public static void cmToIn(double valueToConvert) {
        double finalResult = valueToConvert * 0.3937007874;
        System.out.println(valueToConvert + " centimeters converts to " + finalResult + " inches.");
        System.out.println();
    } //close cmToIn method

    /**
     * This method performs the calculation to convert lb to kg.
     *
     * @param valueToConvert This value is what the user wants to convert.
     */
    public static void lbToKg(double valueToConvert) {
        double finalResult = valueToConvert * 0.45359237;
        System.out.println(valueToConvert + " pounds converts to " + finalResult + " kilograms.");
        System.out.println();
    } //close lbToKg method

    /**
     * This method performs the calculation to convert kg to lb.
     *
     * @param valueToConvert This value is what the user wants to convert.
     */
    public static void kgToLb(double valueToConvert) {
        double finalResult = valueToConvert * 2.20462262185;
        System.out.println(valueToConvert + " kilograms converts to " + finalResult + " pounds.");
        System.out.println();
    } //close kgToLb method

} //close class
