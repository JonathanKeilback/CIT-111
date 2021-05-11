package JonathanObjectProject;

import java.util.Scanner;

/**
 * Client class for Mixer program.
 * @author Jonathan
 */
public class Mixer {

    private static Scanner userInput = new Scanner(System.in);
    static MixerChannel[] channel;
    private static final int MAX_LEVEL = 20; //maximum volume level for the entire mixer

    public static void main(String[] args) throws InterruptedException {

        boolean endProgram = false;
        System.out.println("Welcome to Jonathan's Java Audio Mixer!");
        Thread.sleep(2000);
        System.out.println("With this mixer, you can set up as many input channels as you wish.");
        Thread.sleep(2000);
        System.out.println("There are four Aux channels for monitors.");
        Thread.sleep(2000);
        System.out.println();
        //calls method that lets the user choose the number of channels
        channelSetup();
        //calls method that allows the user to name each channel
        nameChannels();
        do { //this loop operates the mixer
            int userChoice;
            boolean validInput = false;
            displayLevels();
            System.out.println("Choose an option!");
            System.out.println("1. Adjust a level!");
            System.out.println("2. View an Aux channel mix!");
            System.out.println("3. Exit the program!");
            do { //input and validation block
                while (!userInput.hasNextInt()) {
                    System.out.println("Enter a valid choice:");
                    userInput.next();
                }
                userChoice = userInput.nextInt();
                if (userChoice >= 1 && userChoice <= 3) {
                    validInput = true;
                } else {
                    System.out.println("Enter a valid choice:");
                }
            } while (validInput == false);
            switch (userChoice){
                case 1:
                    changeLevel(); //calls method that changes volume levels
                    break;
                case 2:
                    displayAux(); //lets the user display a graphical mix of an Aux channel
                    break;
                case 3:
                    endProgram = true; //ends the program
            }
        } while (endProgram == false);
        System.out.println();
        System.out.println("Thank you for trying out my mixer!");
        Thread.sleep(1000);
    }//close main

    private static void channelSetup() {
        int numberOfChannels;
        boolean validInput = false;
        System.out.println("How many input channels would you like set up?");
        do {
            while (!userInput.hasNextInt()) { //validation block
                System.out.println("Enter a valid number:");
                userInput.next();
            }
            //It adds an extra channel so the program can designate
            //Channel 0 as the Main Output channel.
            numberOfChannels = userInput.nextInt() + 1;
            if (numberOfChannels > 1) {
                validInput = true;
            } else {
                System.out.println("Enter a valid number:");
            }
        } while (!validInput);
        channel = new MixerChannel[numberOfChannels]; //creates the array
    }//close numberOfChannels

    private static void nameChannels() {
        //One of the channels needs to be the Main Output,
        //so I made it Channel 0 so all other channels correspond to their
        //respective channel number.
        MixerChannel mainOutput = new MixerChannel();
        mainOutput.channelName = "Main Output";
        channel[0] = mainOutput;
        //user names all of the other channels
        System.out.println("Name your channels! (ex: Kick, Snare)");
        for (int c = 1; c < channel.length; c++) {
            MixerChannel tempChannel = new MixerChannel();
            System.out.println("Channel " + c + ":");
            tempChannel.channelName = userInput.next();
            channel[c] = tempChannel;
        }
    }//close nameChannels

    private static void displayLevels() {
        System.out.println();
        System.out.println("MAIN MIX LEVELS:");
        System.out.println();
        System.out.print("[");
        for (int level = channel[0].faderLevel; level > 0; level--) {
            System.out.print("|");
        }
        System.out.println("]");
        System.out.println(channel[0].channelName);
        System.out.print("Fader: " + channel[0].faderLevel);
        System.out.println();
        System.out.println();
        for (int c = 1; c < channel.length; c++) {
            System.out.print("[");
            for (int level = channel[c].faderLevel; level > 0; level--) {
                System.out.print("|");
            }
            System.out.println("]");
            System.out.println("Channel " + c + ": " + channel[c].channelName + " ");
            System.out.print("Fader: " + channel[c].faderLevel + " | ");
            System.out.print("Aux1: " + channel[c].aux1Level + " | ");
            System.out.print("Aux2: " + channel[c].aux2Level + " | ");
            System.out.print("Aux3: " + channel[c].aux3Level + " | ");
            System.out.print("Aux4: " + channel[c].aux4Level + " | ");
            System.out.println();
            System.out.println();
        }

    }//close displayLevels

    private static void displayAux() {
        System.out.println("Which Aux levels would you like to display?");
        boolean validInput = false;
        int auxChannel;
        do { //input and validation block
            while (!userInput.hasNextInt()) {
                System.out.println("Enter a valid choice:");
                userInput.next();
            }
            auxChannel = userInput.nextInt();
            if (auxChannel >= 1 && auxChannel <= 4) {
                validInput = true;
            } else {
                System.out.println("Enter a valid choice:");
            }
        } while (validInput == false);
        System.out.println();
        System.out.println("AUX" + auxChannel + " LEVELS");
        System.out.println();
        for (int c = 1; c < channel.length; c++) {
            switch (auxChannel) {
                case 1:
                    System.out.print("[");
                    for (int level = channel[c].aux1Level; level > 0; level--) {
                        System.out.print("|");
                    }
                    System.out.println("]");
                    System.out.println("Channel " + c + ": " + channel[c].channelName + " ");
                    System.out.print("Aux1: " + channel[c].aux1Level);
                    System.out.println();
                    System.out.println();
                    break;
                case 2:
                    System.out.print("[");
                    for (int level = channel[c].aux2Level; level > 0; level--) {
                        System.out.print("|");
                    }
                    System.out.println("]");
                    System.out.println("Channel " + c + ": " + channel[c].channelName + " ");
                    System.out.print("Aux2: " + channel[c].aux2Level);
                    System.out.println();
                    System.out.println();
                    break;
                case 3:
                    System.out.print("[");
                    for (int level = channel[c].aux3Level; level > 0; level--) {
                        System.out.print("|");
                    }
                    System.out.println("]");
                    System.out.println("Channel " + c + ": " + channel[c].channelName + " ");
                    System.out.print("Aux3: " + channel[c].aux3Level);
                    System.out.println();
                    System.out.println();
                    break;
                case 4:
                    System.out.print("[");
                    for (int level = channel[c].aux4Level; level > 0; level--) {
                        System.out.print("|");
                    }
                    System.out.println("]");
                    System.out.println("Channel " + c + ": " + channel[c].channelName + " ");
                    System.out.print("Aux4: " + channel[c].aux4Level);
                    System.out.println();
                    System.out.println();
            }
        }
    }//close displayAux

    private static void changeLevel() {
        System.out.println("Which channel would you like to adjust? (Enter 0 for Main Output)");
        int channelChoice;
        int level;
        int userChoice;
        boolean validInput = false;
        do { //input and validation block
            while (!userInput.hasNextInt()) {
                System.out.println("Enter a valid choice:");
                userInput.next();
            }
            channelChoice = userInput.nextInt();
            if (channelChoice >= 0 && channelChoice < channel.length) {
                validInput = true;
            } else {
                System.out.println("Enter a valid choice:");
            }
        } while (validInput == false);
        validInput = false;
        if (channelChoice == 0) {
            System.out.println("Adjust the Main Output fader to what level? (Maximum " + MAX_LEVEL + ")");
            do { //input and validation block
                while (!userInput.hasNextInt()) {
                    System.out.println("Enter a valid choice:");
                    userInput.next();
                }
                level = userInput.nextInt();
                if (level >= 0 && level <= MAX_LEVEL) {
                    channel[0].faderLevel = level;
                    validInput = true;
                } else {
                    System.out.println("Enter a valid choice:");
                }
            } while (validInput == false);
        } else {
            System.out.println("Which level would you like to adjust? (Enter the corresponding number)");
            System.out.println("0: Fader");
            System.out.println("1: Aux1");
            System.out.println("2: Aux2");
            System.out.println("3: Aux3");
            System.out.println("4: Aux4");
            do { //input and validation block
                while (!userInput.hasNextInt()) {
                    System.out.println("Enter a valid choice:");
                    userInput.next();
                }
                userChoice = userInput.nextInt();
                if (userChoice >= 0 && userChoice <= 4) {
                    validInput = true;
                } else {
                    System.out.println("Enter a valid choice:");
                }
            } while (validInput == false);
            validInput = false;
            System.out.println("Adjust to what level? (Maximum " + MAX_LEVEL + ")");
            do { //input and validation block
                while (!userInput.hasNextInt()) {
                    System.out.println("Enter a valid choice:");
                    userInput.next();
                }
                level = userInput.nextInt();
                if (level >= 0 && level <= MAX_LEVEL) {
                    validInput = true;
                } else {
                    System.out.println("Enter a valid choice:");
                }
            } while (validInput == false);
            switch (userChoice) {
                case 0:
                    channel[channelChoice].faderLevel = level;
                    break;
                case 1:
                    channel[channelChoice].aux1Level = level;
                    break;
                case 2:
                    channel[channelChoice].aux2Level = level;
                    break;
                case 3:
                    channel[channelChoice].aux3Level = level;
                    break;
                case 4:
                    channel[channelChoice].aux4Level = level;
            }
        }
    }//close changeLevel

}//close class
