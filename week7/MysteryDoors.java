package week7;

import java.util.Random;
import java.util.Scanner;

/**
 * Chunk 2, Mod 1, MysteryDoors project. I worked ahead and incorporated return
 * values in these methods.
 *
 * @author Jonathan
 */
public class MysteryDoors {

    public static void main(String[] args) throws InterruptedException {
        boolean loopDoors = true;
        String userName = welcome(); //Welcome method, asks user's name and stores it

        //This loop allows the user to exit the door selection prompt
        do {
            int doorNumber = chooseDoor(userName);
            switch (doorNumber) {
                case 1:
                    loopDoors = doorOne(userName); //goes to Door 1 method
                    break;
                case 2:
                    loopDoors = doorTwo(userName); //goes to Door 2 method
                    break;
                case 3:
                    loopDoors = doorThree(userName); //goes to Door 3 method
                    break;
                default:
                    loopDoors = false; //triggers end of program
            }
        } while (loopDoors);

        //End of program prompts
        System.out.println();
        System.out.println("You've had enough of Jonathan's shenanigans for today, huh?");
        System.out.println();
        Thread.sleep(2000);
        System.out.println("I don't blame you!");
        System.out.println();
        Thread.sleep(2000);
        System.out.println("Cya ^_^");
        System.out.println();
        Thread.sleep(2000);
    }//close main method

    /**
     * This method welcomes the user, asks for the user's name, and returns name
     * to main so it can be passed on to the other methods.
     *
     * @return Returns user's name to main method
     */
    public static String welcome() throws InterruptedException {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome, user, to Jonathan's Weird Mystery Doors!!");
        Thread.sleep(2000);
        System.out.println("If you don't mind, please tell me your name.");
        Thread.sleep(2000);
        System.out.println("It would be rude of me to keep calling you User!");
        Thread.sleep(2000);
        System.out.println("Type in your name and press Enter:");
        String userName = userInput.next();
        System.out.println("Excellent! From now on, you shall be named " + userName);
        Thread.sleep(2000);
        return userName;
    }//close welcome method

    /**
     * This method asks the user to choose a fictional mystery door.
     *
     * @param userName is the same as userName from main method.
     * @return Returns the chosen door number to the main method door switch.
     */
    public static int chooseDoor(String userName) throws InterruptedException {
        System.out.println();
        Scanner userInput = new Scanner(System.in);
        System.out.println("|---|  |---|  |---|");
        System.out.println("| 1 |  | 2 |  | 3 |");
        System.out.println("|---|  |---|  |---|");
        System.out.println();
        Thread.sleep(2000);
        System.out.println(userName + ", please choose one of Jonathan's Weird Mystery Doors!");
        Thread.sleep(2000);
        System.out.println("Type the number of the door you wish to open.");
        System.out.println("Type 4 to choose a random door.");
        System.out.println("Type anything else to exit this program:");
        System.out.println("MAKE YOUR SELECTION AND PRESS ENTER:");
        int doorNumber = 0;
        String userChoice = userInput.next();
        switch (userChoice) {
            case "1":
                doorNumber = 1;
                break;
            case "2":
                doorNumber = 2;
                break;
            case "3":
                doorNumber = 3;
                break;
            case "4":
                Random randomDoor = new Random();
                doorNumber = randomDoor.nextInt(3) + 1;
                break;
            default:
        }
        return doorNumber;
    }//close chooseDoor method

    /**
     * This method "opens" door #1. Encounter the Doggo of Good Luck!
     *
     * @param userName is the same as userName from main method.
     * @return Returns whether the user wants to choose another door or exit the
     * program.
     */
    public static boolean doorOne(String userName) throws InterruptedException {
        Scanner userInput = new Scanner(System.in);
        boolean happyDoggo = false;
        int doggoTrigger = 3;
        System.out.println();
        System.out.println("*****DOOR NUMBER ONE*****");
        Thread.sleep(2000);
        System.out.println();
        System.out.println(userName + ", a good doggo approaches you.");
        Thread.sleep(2000);
        //doggo loop!
        do {
            System.out.println("Type 1 and press Enter to boop the doggo on the snoot.");
            String boopDoggo = userInput.next();
            switch (boopDoggo) {
                case "1":
                    doggoTrigger = 0;
                    happyDoggo = true;
                    break;
                default:
                    System.out.println("The good doggo waits.");
                    doggoTrigger--;
            }
        } while (doggoTrigger > 0);

        if (happyDoggo) {
            System.out.println("You just booped the Doggo of Good Luck on the snoot.");
            Thread.sleep(2000);
            System.out.println("The Doggo of Good Luck grants you 7 days of focused, distraction-free study time for CIT-111.");
            Thread.sleep(2000);
            System.out.println("*Bork*, says the Doggo of Good Luck, as it dematerializes back into the lower doggosphere.");
        } else {
            System.out.println("The good doggo is not impressed.");
            Thread.sleep(2000);
            System.out.println("It transforms from good doggo to DOGZILLA.");
            Thread.sleep(2000);
            System.out.println("*Bork*, says DOGZILLA as it grows taller than the Pittsburgh skyline and levels the city.");
            Thread.sleep(2000);
            System.out.println("Next time, " + userName + ", just boop the doggo on the snoot!");
        }
        //End of Door 1 activity, asking user to return to Door Selection Menu
        System.out.println();
        Thread.sleep(2000);
        System.out.println("Would you like to try another door?");
        Thread.sleep(2000);
        System.out.println("Enter 1 for YES");
        System.out.println("Enter anything else for NO");
        System.out.println("Type your selection and press Enter:");
        boolean loopDoors = true;
        String anotherDoor = userInput.next();
        switch (anotherDoor) {
            case "1":
                break;
            default:
                loopDoors = false;
        }
        return loopDoors; //tells main method whether to go to Door Selection Menu
    } //end Door #1

    /**
     * This method "opens" Door #2. Enter Dennis Nedry's (from Jurassic Park)
     * magic word.
     *
     * @param userName is the same as userName from main method.
     * @return Returns whether the user wants to choose another door or exit the
     * program.
     */
    public static boolean doorTwo(String userName) throws InterruptedException {
        Scanner userInput = new Scanner(System.in);
        String magicWord = "mr.goodbytes";
        int loginAttempts = 3;
        boolean correctPassword = false;
        System.out.println();
        System.out.println("*****DOOR NUMBER TWO*****");
        System.out.println(userName + ", please enter Dennis Nedry's magic word!");
        System.out.println();
        Thread.sleep(2000);
        System.out.println("Jurassic Park, System Security Interface");
        Thread.sleep(400);
        System.out.println("Version 4.0.5, Alpha E");
        Thread.sleep(400);
        System.out.println("Ready...");
        Thread.sleep(400);
        System.out.println(">");
        //password authentication loop
        do {
            String commandLine = userInput.next();
            switch (commandLine) {
                case "mr":
                    System.out.println("access: PERMISSION GRANTED");
                    Thread.sleep(2000);
                    System.out.println();
                    loginAttempts = 0;
                    correctPassword = true;
                    break;
                default:
                    System.out.println("access: PERMISSION DENIED");
                    loginAttempts--;
            }
        } while (loginAttempts > 0);

        if (correctPassword == false) {
            Thread.sleep(1000);
        }
        while (correctPassword == false) {
            System.out.println("YOU DIDN'T SAY THE MAGIC WORD!");
            Thread.sleep(50);
        }
        //End of Door 2 activity, asking user to return to Door Selection Menu
        System.out.println("Would you like to try another door?");
        Thread.sleep(2000);
        System.out.println("Enter 1 for YES");
        System.out.println("Enter anything else for NO");
        System.out.println("Type your selection and press Enter:");
        boolean loopDoors = true;
        String anotherDoor = userInput.next();
        switch (anotherDoor) {
            case "1":
                break;
            default:
                loopDoors = false;
        }
        return loopDoors; //tells main method whether to go to Door Selection Menu
    } //end Door #2

    /**
     * This method "opens" Door #3. I am burned out from my job and ran out of
     * ideas. Sorry.
     *
     * @param userName is the same as userName from main method.
     * @return Returns whether the user wants to choose another door or exit the
     * program.
     */
    public static boolean doorThree(String userName) throws InterruptedException {
        Scanner userInput = new Scanner(System.in);
        System.out.println();
        System.out.println("*****DOOR NUMBER THREE*****");
        System.out.println();
        Thread.sleep(2000);
        System.out.println("I'm super sorry, " + userName + ", but I burned out while coding this program.");
        Thread.sleep(2000);
        System.out.println("and my creative juices just stopped flowing.");
        Thread.sleep(2000);
        System.out.println("I was going to make some kind of joke involving Monty Python");
        Thread.sleep(2000);
        System.out.println("while incorporating random number generation,");
        Thread.sleep(2000);
        System.out.println("But, I'm out of gas.");
        Thread.sleep(2000);
        System.out.println("So, please accept my offer of this ASCII art version of TARDIS.");
        Thread.sleep(3000);
        System.out.println("        ___        ");
        System.out.println("_______(_@_)_______");
        System.out.println("| POLICE      BOX |");
        System.out.println("|_________________|");
        System.out.println(" | _____ | _____ | ");
        System.out.println(" | |###| | |###| | ");
        System.out.println(" | |###| | |###| | ");
        System.out.println(" | _____ | _____ | ");
        System.out.println(" | || || | || || | ");
        System.out.println(" | ||_|| | ||_|| | ");
        System.out.println(" | _____ |$_____ | ");
        System.out.println(" | || || | || || | ");
        System.out.println(" | ||_|| | ||_|| | ");
        System.out.println(" | _____ | _____ | ");
        System.out.println(" | || || | || || | ");
        System.out.println(" | ||_|| | ||_|| | ");
        System.out.println(" |       |       | ");
        System.out.println(" ***************** ");
        System.out.println();
        System.out.println();
        Thread.sleep(3000);
        //End of Door 3 activity, asking user to return to Door Selection Menu
        System.out.println("Would you like to try another door?");
        Thread.sleep(2000);
        System.out.println("Enter 1 for YES");
        System.out.println("Enter anything else for NO");
        System.out.println("Type your selection and press Enter:");
        boolean loopDoors = true;
        String anotherDoor = userInput.next();
        switch (anotherDoor) {
            case "1":
                break;
            default:
                loopDoors = false;
        }
        return loopDoors; //tells main method whether to go to Door Selection Menu
    } //end Door #3

}//close MysteryDoors class
