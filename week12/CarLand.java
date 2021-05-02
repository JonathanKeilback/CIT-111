/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week12;

import java.util.Scanner;

/**
 * Client class of our car model
 *
 * @author Jonathan
 */
public class CarLand {

    static Scanner userInput = new Scanner(System.in);

    /**
     * Main method - lets user choose a custom car and calls the car driving method
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Car userCar = new Car();
        welcome();
        boolean validYear = false;
        int carLandYear;
        System.out.println("Enter the YEAR of your car and press Enter");
        do {
            while (!userInput.hasNextInt()) { //Validation block.
                System.out.println("Enter a valid choice:");
                userInput.next();
            }
            carLandYear = userInput.nextInt();
            if (carLandYear > 1885 && carLandYear < 2024) {
                validYear = true;
            } else {
                System.out.println("Enter a valid choice:");
            }
        } while (!validYear);
        System.out.println();
        System.out.println("Enter the MAKE of your car and press Enter");
        String carLandMake = userInput.next();
        System.out.println();
        System.out.println("Enter the MODEL of your car and press Enter");
        String carLandModel = userInput.next();
        userCar.updateCarInfo(carLandYear, carLandMake, carLandModel);
        driveCar(userCar);

    } //close main method

    private static void welcome() throws InterruptedException {
        System.out.println("Welcome to Jon's CarLand!");
        Thread.sleep(2000);
        System.out.println("It sounds like the name of a terrible dealership...");
        Thread.sleep(2000);
        System.out.println("But it's actually a car simulator.");
        Thread.sleep(2000);
        System.out.println();
    }

    private static void displayCarStats(Car userCar) {
        System.out.println();
        System.out.print("*** ");
        System.out.print(userCar.checkYear());
        System.out.print(" ");
        System.out.print(userCar.checkMake());
        System.out.print(" ");
        System.out.print(userCar.checkModel());
        System.out.println(" ***");
        System.out.print("Engine on? ");
        System.out.println(userCar.checkEngineStatus());
        System.out.print("Current speed: ");
        System.out.println(userCar.getCurrentSpeed());
        System.out.print("Current gear: ");
        System.out.print(userCar.getCurrentGear());
        if (userCar.getCurrentGear() == 0) {
            System.out.println("(Park)");
        } else {
            System.out.println();
        }
        if (userCar.checkTimeCircuits() == true) {
            System.out.println("Time circuits are ACTIVATED.");
            System.out.println("Destination time: " + userCar.checkDestinationTime());
        } else {
            System.out.println("Time circuits are currently off.");
        }
        System.out.println("Current local time: " + userCar.checkCurrentTime());
    }//close method displayCarStats

    private static void driveCar(Car userCar) throws InterruptedException {
        boolean doneWithCar = false;
        do {
            displayCarStats(userCar);
            System.out.println();
            System.out.println("Drive your car!");
            System.out.println("1. Start engine");
            System.out.println("2. Stop engine");
            System.out.println("3. Accelerate");
            System.out.println("4. Decelerate");
            System.out.println("5. Activate/deactivate time circuits");
            System.out.println("6. I'm done driving");
            while (!userInput.hasNextInt()) { //Validation block.
                System.out.println("Enter a valid choice:");
                userInput.next();
            }
            int switcher = userInput.nextInt();
            switch (switcher) {
                case 1:
                    userCar.startEngine();
                    break;
                case 2:
                    userCar.stopEngine();
                    break;
                case 3:
                    if (userCar.checkEngineStatus() == true) {
                        System.out.println("Enter (in MPH) how much faster you want to go");
                        while (!userInput.hasNextInt()) { //Validation block.
                            System.out.println("Enter a valid number:");
                            userInput.next();
                        }
                        int speedInput = userInput.nextInt();
                        int newSpeed = userCar.accelerate(speedInput);
                        if (userCar.checkEngineStatus() == true) {
                            System.out.println("Your speed is now " + newSpeed + " MPH.");
                        }
                    } else {
                        System.out.println("The engine is off... you cannot accelerate.");
                    }
                    break;
                case 4:
                    System.out.println("Enter (in MPH) how much slower you want to go");
                    while (!userInput.hasNextInt()) { //Validation block.
                        System.out.println("Enter a valid number:");
                        userInput.next();
                    }
                    int speedInput = userInput.nextInt();
                    int newSpeed = userCar.decelerate(speedInput);
                    System.out.println("Your speed is now " + newSpeed + " MPH.");
                    break;
                case 5:
                    System.out.println();
                    userCar.activateTimeCircuits();
                    break;
                case 6:
                    doneWithCar = true;
                    if (userCar.getCurrentSpeed() == 0) {
                        System.out.println("Hope you enjoyed your drive!");
                        if (userCar.checkEngineStatus() == true) {
                            Thread.sleep(1000);
                            System.out.println("However, you left the car running.");
                            Thread.sleep(1000);
                            System.out.println("But hey, it's your car... do whatever you want! I can't stop you.");
                        }
                    } else {
                        System.out.println("YOU JUST JUMPED OUT OF A MOVING CAR!");
                        Thread.sleep(1000);
                        System.out.println("Who do you think you are? Some kind of action movie hero?");
                        Thread.sleep(1000);
                        System.out.println("Well, I hope you had fun doing that. Sheesh...");
                    }
                    break;
                default:
                    System.out.println("Enter a valid chocie:");
            }
        } while (!doneWithCar);

    }//close method driveCar

} //close class CarLand
