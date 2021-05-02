/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week12;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Model of a vehicle with methods acting on member variables
 *
 * @author Jonathan
 */
public class Car {

    private int year;
    private String make;
    private String model;
    private boolean isEngineRunning;
    private int speed;
    private int gear;
    private boolean timeCircuitsReady;
    private LocalDateTime currentTime = LocalDateTime.now();
    private LocalDateTime destinationTime;
    private int timeTravelSpeed = 88;
    private int maxSpeed = 135;

    void updateCarInfo(int carLandYear, String carLandMake, String carLandModel) {
        //accessor "setter" method
        year = carLandYear;
        make = carLandMake;
        model = carLandModel;
    }//close method updateCarInfo

    void startEngine() {
        if (!isEngineRunning) {
            isEngineRunning = true;
            System.out.println("Chugga chugga chugga vrrRROOOOM VROOOOOM!");
        } else {
            System.out.println("GRRRRSSSHHHHKKKKK! The engine is already running.");
        }

    }//close method startEngine

    void stopEngine() {
        if (isEngineRunning) {
            isEngineRunning = false;
            System.out.println("The engine is now off.");
            if (speed > 0) {
                System.out.println("YOU ARE NOW COASTING AT " + speed + " MPH!");
            }
        } else {
            System.out.println("The engine is already off.");
        }

    }//close method stopEngine

    int checkYear() {
        //accessor "getter" method
        return year;
    }//close method checkEngineStatus

    String checkMake() {
        //accessor "getter" method
        return make;
    }//close method checkEngineStatus

    String checkModel() {
        //accessor "getter" method
        return model;
    }//close method checkEngineStatus

    boolean checkEngineStatus() {
        //accessor "getter" method
        return isEngineRunning;
    }//close method checkEngineStatus

    int getCurrentSpeed() {
        //accessor "getter" method
        return speed;
    }//close method getCurrentSpeed

    int getCurrentGear() {
        //accessor "getter" method
        return gear;
    }//close method getCurrentSpeed

    int accelerate(int mphIncrease) throws InterruptedException {
        System.out.println("Accelerating...");
        while (mphIncrease > 0) {
            if (speed == maxSpeed) {
                System.out.println("You're currently driving at maximum speed.");
                mphIncrease = 0;
            } else {
                Thread.sleep(200);
                speed++;
                mphIncrease--;
                transmission();
                if (timeCircuitsReady == true && speed == timeTravelSpeed) {
                    System.out.println();
                    System.out.println("TIME TRAVEL SPEED OF " + timeTravelSpeed + " MPH HAS BEEN REACHED");
                    Thread.sleep(1000);
                    System.out.println("FLUX CAPACITOR: FLUXING!");
                    Thread.sleep(1000);
                    currentTime = destinationTime;
                    timeCircuitsReady = false;
                    System.out.println("You have just traveled to " + currentTime);
                    Thread.sleep(1000);
                }
            }
        }
        //ship new speed back to caller
        return speed;
    } //close method accelerate

    int decelerate(int mphDecrease) throws InterruptedException {
        System.out.println("Decelerating...");
        while (mphDecrease > 0) {
            if (speed == 0) {
                System.out.println("You're currently stopped.");
                mphDecrease = 0;
            } else {
                Thread.sleep(200);
                speed--;
                mphDecrease--;
                transmission();
            }
        }
        //ship new speed back to caller
        return speed;
    }//close method decelerate

    private void transmission() {
        if (speed == 0) {
            gear = 0;
            System.out.println("Shifting into Park.");
        }
        if (speed > 0 && speed < 15) {
            if (gear != 1) {
                System.out.println("Shifting into 1st gear...");
            }
            gear = 1;
        }
        if (speed > 14 && speed < 25) {
            if (gear != 2) {
                System.out.println("Shifting into 2nd gear...");
            }
            gear = 2;
        }
        if (speed > 24 && speed < 35) {
            if (gear != 3) {
                System.out.println("Shifting into 3rd gear...");
            }
            gear = 3;
        }
        if (speed > 34 && speed < 50) {
            if (gear != 4) {
                System.out.println("Shifting into 4th gear...");
            }
            gear = 4;
        }
        if (speed > 49) {
            if (gear != 5) {
                System.out.println("Shifting into 5th gear...");
            }
            gear = 5;
        }
    }//close method transmission

    boolean checkTimeCircuits() {
        //accessor "getter" method
        return timeCircuitsReady;
    }//close method checkEngineStatus

    LocalDateTime checkCurrentTime() {
        //accessor "getter" method
        return currentTime;
    }//close method checkEngineStatus

    LocalDateTime checkDestinationTime() {
        //accessor "getter" method
        return destinationTime;
    }//close method checkEngineStatus

    void activateTimeCircuits() {
        Scanner userInput = new Scanner(System.in);
        if (checkTimeCircuits() == true) {
            System.out.println("Time circuits have been deactivated.");
            timeCircuitsReady = false;
        } else {
            timeCircuitsReady = true;
            System.out.println("Time circuits are armed. Set destination time.");
            System.out.println("Current local time: " + LocalDateTime.now());
            System.out.println();
            System.out.println("Enter destination year:");
            while (!userInput.hasNextInt()) { //Validation block.
                System.out.println("Enter a valid choice:");
                userInput.next();
            }
            int goToYear = userInput.nextInt();
            System.out.println();
            System.out.println("Enter destination month (two digits - 01 through 12):");
            while (!userInput.hasNextInt()) { //Validation block.
                System.out.println("Enter a valid choice:");
                userInput.next();
            }
            int goToMonth = userInput.nextInt();
            System.out.println();
            System.out.println("Enter destination day (two digits - 01 through 28-31):");
            while (!userInput.hasNextInt()) { //Validation block.
                System.out.println("Enter a valid choice:");
                userInput.next();
            }
            int goToDay = userInput.nextInt();
            System.out.println();
            System.out.println("Enter destination hour (24 hour format - 00 through 23):");
            while (!userInput.hasNextInt()) { //Validation block.
                System.out.println("Enter a valid choice:");
                userInput.next();
            }
            int goToHour = userInput.nextInt();
            System.out.println();
            System.out.println("Enter destination minute (two digits - 00 through 59):");
            while (!userInput.hasNextInt()) { //Validation block.
                System.out.println("Enter a valid choice:");
                userInput.next();
            }
            int goToMinute = userInput.nextInt();
            destinationTime = LocalDateTime.of(goToYear, goToMonth, goToDay, goToHour, goToMinute);
            System.out.println();
            System.out.println("The destination time has been set.");
        }
    }

} //close class Car
