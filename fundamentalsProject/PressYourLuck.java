package fundamentalsProject;

import java.util.Random;
import java.util.Scanner;

/**
 * CIT-111 Fundamentals Project: Press Your Luck
 *
 * @author Jonathan
 */
public class PressYourLuck {

    public static int p1Cash = 0;
    public static int p1Whammies = 0;
    public static int p1Spins = 6;
    public static int p1PassedSpins = 0;
    public static int p2Cash = 0;
    public static int p2Whammies = 0;
    public static int p2Spins = 6;
    public static int p2PassedSpins = 0;
    public static int p3Cash = 0;
    public static int p3Whammies = 0;
    public static int p3Spins = 6;
    public static int p3PassedSpins = 0;

    /**
     * Main Method: Begins and ends the game, and switches between players.
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        boolean endGame = false;
        Scanner userInput = new Scanner(System.in);
        Random randomizer = new Random();
        System.out.println("WELCOME TO PRESS YOUR LUCK!");
        Thread.sleep(2000);
        System.out.println("This program is based on the classic game show.");
        Thread.sleep(2000);
        System.out.println("Spin the Big Board to win cash!");
        Thread.sleep(2000);
        System.out.println("If you get a Whammy, you lose all of your money.");
        Thread.sleep(2000);
        System.out.println("If you get 4 Whammies, you're eliminated from the game.");
        Thread.sleep(2000);
        System.out.println("You can also pass your spins to another player.");
        Thread.sleep(2000);
        System.out.println("You MUST use spins that are passed to you, unless you get a Whammy.");
        Thread.sleep(2000);
        System.out.println();
        System.out.println("Player 1, please enter your name:");
        String player1 = userInput.nextLine();
        System.out.println("Player 2, please enter your name:");
        String player2 = userInput.nextLine();
        System.out.println("Player 3, please enter your name:");
        String player3 = userInput.nextLine();
        displayScores(player1, player2, player3);
        System.out.println("The player who spins first will be randomly chosen");
        Thread.sleep(2000);
        System.out.println("LET'S START THE GAME!");
        Thread.sleep(2000);
        System.out.println();
        int playerSwitch = randomizer.nextInt(3) + 1;
        do {
            switch (playerSwitch) {
                case 1:
                    playerSwitch = player1Turn(player1, player2, player3);
                    break;
                case 2:
                    playerSwitch = player2Turn(player1, player2, player3);
                    break;
                case 3:
                    playerSwitch = player3Turn(player1, player2, player3);
                    break;
                case 0:
                    endGame = true;
            }
        } while (endGame == false);
        System.out.println();
        System.out.println("THE GAME IS OVER!");
        System.out.println();
        displayScores(player1, player2, player3);
        if (p1Cash > p2Cash && p1Cash > p3Cash) {
            System.out.println(player1 + " has won the game with $" + p1Cash + "!");
        } else if (p2Cash > p1Cash && p2Cash > p3Cash) {
            System.out.println(player2 + " has won the game with $" + p2Cash + "!");
        } else if (p3Cash > p1Cash && p3Cash > p2Cash) {
            System.out.println(player3 + " has won the game with $" + p3Cash + "!");
        } else if (p1Cash == 0 && p2Cash == 0 && p3Cash == 0) {
            System.out.println("NOBODY WINS! ALL PLAYERS HAVE $0!");
        }

    } //close main method

    /**
     * This method processes Player 1's turn to play the game.
     *
     * @param player1 Name string
     * @param player2 Name string
     * @param player3 Name string
     * @return Returns to main the player to switch to, and whether to end the
     * game or not.
     * @throws InterruptedException
     */
    public static int player1Turn(String player1, String player2, String player3) throws InterruptedException {
        Random randomizer = new Random();
        Scanner userInput = new Scanner(System.in);
        int player = 1;
        int switchToPlayer = 4;
        boolean playedPassedSpins = false;
        System.out.println("----- " + player1 + " IS UP -----");
        System.out.println();
        while (p1PassedSpins > 0) {
            playedPassedSpins = true;
            displayScores(player1, player2, player3);
            System.out.println(player1 + ", you have " + p1PassedSpins + " passed spin(s) that you must use, unless you hit a Whammy.");
            System.out.println("If you hit a Whammy, the passed spins are converted to regular spins.");
            p1PassedSpins--;
            spin(player);
        }
        if (playedPassedSpins == false) {
            p1Spins--;
            spin(player);
        }
        if (p1Whammies == 4 || p1Spins == 0) {
            if (p1Spins == 0) {
                System.out.println();
                System.out.println(player1 + " has used their final spin.");
                System.out.println("The program will switch to the next player up, per the rules.");
                System.out.println();
            }
            p1Spins = 0;
            if (p2Spins == 0 && p3Spins == 0) {
                switchToPlayer = 0;
            } else if (p2Whammies == 4 && p3Cash == 0) {
                switchToPlayer = 3;
            } else if (p3Whammies == 4 && p2Cash == 0) {
                switchToPlayer = 2;
            } else if (p2Cash < p3Cash && p2Spins > 0) {
                switchToPlayer = 2;
            } else if (p3Cash < p2Cash && p3Spins > 0) {
                switchToPlayer = 3;
            } else if (p3Cash == p2Cash) {
                if (p2Spins < p3Spins) {
                    switchToPlayer = 2;
                } else if (p3Spins < p2Spins) {
                    switchToPlayer = 3;
                } else {
                    switchToPlayer = randomizer.nextInt(2);
                    switch (switchToPlayer) {
                        case 0:
                            switchToPlayer = 2;
                            break;
                        case 1:
                            switchToPlayer = 3;
                    }
                }
            }
            if (p1Whammies == 4) {
                System.out.println();
                System.out.println(player1 + " has 4 Whammies and has been eliminated from the game!");
                System.out.println();
                if (p2Spins == 0 && p3Spins == 0 || p2Whammies == 4 && p3Cash > 0 || p3Whammies == 4 && p2Cash > 0) {
                    switchToPlayer = 0;
                }
            }
        }
        if (p1Cash > 0 && p1Cash > p2Cash && p1Cash > p3Cash && p2Spins == 0 && p3Spins == 0) {
            switchToPlayer = 0;
        } else if (p1Spins > 0) {
            boolean player2Pass = false;
            boolean player3Pass = false;
            boolean choiceValidation = false;
            displayScores(player1, player2, player3);
            System.out.println();
            System.out.println(player1 + " has " + p1Spins + " spins(s) remaining.");
            System.out.println();
            System.out.println("Enter 0 to spin again");
            if (p2Whammies < 4) {
                player2Pass = true;
                System.out.println("Enter 2 to pass your " + p1Spins + " spin(s) to " + player2);
            }
            if (p3Whammies < 4) {
                player3Pass = true;
                System.out.println("Enter 3 to pass your " + p1Spins + " spin(s) to " + player3);
            }
            do {
                while (!userInput.hasNextInt()) { //Validation block.
                    System.out.println("Enter a valid choice:");
                    userInput.next();
                }
                int spinChoice = userInput.nextInt();
                switch (spinChoice) {
                    case 0:
                        choiceValidation = true;
                        switchToPlayer = 1;
                        break;
                    case 2:
                        if (player2Pass == true) {
                            switchToPlayer = 2;
                            choiceValidation = true;
                            p2PassedSpins = p2PassedSpins + p1Spins;
                            p1Spins = 0;
                        } else {
                            System.out.println("Enter a valid choice:");
                        }
                        break;
                    case 3:
                        if (player3Pass == true) {
                            switchToPlayer = 3;
                            choiceValidation = true;
                            p3PassedSpins = p3PassedSpins + p1Spins;
                            p1Spins = 0;
                        } else {
                            System.out.println("Enter a valid choice:");
                        }
                        break;
                    default:
                        System.out.println("Enter a valid choice:");
                }
            } while (choiceValidation == false);
        }

        if (switchToPlayer == 4) { //debug block
            System.out.println();
            System.out.println("OH NO!!! SWITCHING ERROR IN PLAYER 1 METHOD!");
            System.out.println();
            switchToPlayer = 0;
        }
        return switchToPlayer;
    } //close player1Turn

    /**
     * This method processes Player 2's turn to play the game.
     *
     * @param player1 Name string
     * @param player2 Name string
     * @param player3 Name string
     * @return Returns to main the player to switch to, and whether to end the
     * game or not.
     * @throws InterruptedException
     */
    public static int player2Turn(String player1, String player2, String player3) throws InterruptedException {
        Random randomizer = new Random();
        Scanner userInput = new Scanner(System.in);
        int player = 2;
        int switchToPlayer = 4;
        boolean playedPassedSpins = false;
        System.out.println("----- " + player2 + " IS UP -----");
        System.out.println();
        while (p2PassedSpins > 0) {
            playedPassedSpins = true;
            displayScores(player1, player2, player3);
            System.out.println(player2 + ", you have " + p2PassedSpins + " passed spin(s) that you must use, unless you hit a Whammy.");
            System.out.println("If you hit a Whammy, the passed spins are converted to regular spins.");
            p2PassedSpins--;
            spin(player);
        }
        if (playedPassedSpins == false) {
            p2Spins--;
            spin(player);
        }
        if (p2Whammies == 4 || p2Spins == 0) {
            if (p2Spins == 0) {
                System.out.println();
                System.out.println(player2 + " has used their final spin.");
                System.out.println("The program will switch to the next player up, per the rules.");
                System.out.println();
            }
            p2Spins = 0;
            if (p1Spins == 0 && p3Spins == 0) {
                switchToPlayer = 0;
            } else if (p1Whammies == 4 && p3Cash == 0) {
                switchToPlayer = 3;
            } else if (p3Whammies == 4 && p1Cash == 0) {
                switchToPlayer = 1;
            } else if (p1Cash < p3Cash && p1Spins > 0) {
                switchToPlayer = 1;
            } else if (p3Cash < p1Cash && p3Spins > 0) {
                switchToPlayer = 3;
            } else if (p3Cash == p1Cash) {
                if (p1Spins < p3Spins) {
                    switchToPlayer = 1;
                } else if (p3Spins < p1Spins) {
                    switchToPlayer = 3;
                } else {
                    switchToPlayer = randomizer.nextInt(2);
                    switch (switchToPlayer) {
                        case 0:
                            switchToPlayer = 1;
                            break;
                        case 1:
                            switchToPlayer = 3;
                    }
                }
            }
            if (p2Whammies == 4) {
                System.out.println();
                System.out.println(player2 + " has 4 Whammies and has been eliminated from the game!");
                System.out.println();
                if (p1Spins == 0 && p3Spins == 0 || p1Whammies == 4 && p3Cash > 0 || p3Whammies == 4 && p1Cash > 0) {
                    switchToPlayer = 0;
                }
            }
        }
        if (p2Cash > 0 && p2Cash > p1Cash && p2Cash > p3Cash && p1Spins == 0 && p3Spins == 0) {
            switchToPlayer = 0;
        } else if (p2Spins > 0) {
            boolean player1Pass = false;
            boolean player3Pass = false;
            boolean choiceValidation = false;
            displayScores(player1, player2, player3);
            System.out.println();
            System.out.println(player2 + " has " + p2Spins + " spins(s) remaining.");
            System.out.println();
            System.out.println("Enter 0 to spin again");
            if (p1Whammies < 4) {
                player1Pass = true;
                System.out.println("Enter 1 to pass your " + p2Spins + " spin(s) to " + player1);
            }
            if (p3Whammies < 4) {
                player3Pass = true;
                System.out.println("Enter 3 to pass your " + p2Spins + " spin(s) to " + player3);
            }
            do {
                while (!userInput.hasNextInt()) { //Validation block.
                    System.out.println("Enter a valid choice:");
                    userInput.next();
                }
                int spinChoice = userInput.nextInt();
                switch (spinChoice) {
                    case 0:
                        choiceValidation = true;
                        switchToPlayer = 2;
                        break;
                    case 1:
                        if (player1Pass == true) {
                            switchToPlayer = 1;
                            choiceValidation = true;
                            p1PassedSpins = p1PassedSpins + p2Spins;
                            p2Spins = 0;
                        } else {
                            System.out.println("Enter a valid choice:");
                        }
                        break;
                    case 3:
                        if (player3Pass == true) {
                            switchToPlayer = 3;
                            choiceValidation = true;
                            p3PassedSpins = p3PassedSpins + p2Spins;
                            p2Spins = 0;
                        } else {
                            System.out.println("Enter a valid choice:");
                        }
                        break;
                    default:
                        System.out.println("Enter a valid choice:");
                }
            } while (choiceValidation == false);
        }
        if (switchToPlayer == 4) { //debug block
            System.out.println();
            System.out.println("OH NO!!! SWITCHING ERROR IN PLAYER 2 METHOD!");
            System.out.println();
            switchToPlayer = 0;
        }
        return switchToPlayer;
    } //close player2Turn

    /**
     * This method processes Player 3's turn to play the game.
     *
     * @param player1 Name string
     * @param player2 Name string
     * @param player3 Name string
     * @return Returns to main the player to switch to, and whether to end the
     * game or not.
     * @throws InterruptedException
     */
    public static int player3Turn(String player1, String player2, String player3) throws InterruptedException {
        Random randomizer = new Random();
        Scanner userInput = new Scanner(System.in);
        int player = 3;
        int switchToPlayer = 4;
        boolean playedPassedSpins = false;
        System.out.println("----- " + player3 + " IS UP -----");
        System.out.println();
        while (p3PassedSpins > 0) {
            playedPassedSpins = true;
            displayScores(player1, player2, player3);
            System.out.println(player3 + ", you have " + p3PassedSpins + " passed spin(s) that you must use, unless you hit a Whammy.");
            System.out.println("If you hit a Whammy, the passed spins are converted to regular spins.");
            p3PassedSpins--;
            spin(player);
        }
        if (playedPassedSpins == false) {
            p3Spins--;
            spin(player);
        }
        if (p3Whammies == 4 || p3Spins == 0) {
            if (p3Spins == 0) {
                System.out.println();
                System.out.println(player3 + " has used their final spin.");
                System.out.println("The program will switch to the next player up, per the rules.");
                System.out.println();
            }
            p3Spins = 0;
            if (p2Spins == 0 && p1Spins == 0) {
                switchToPlayer = 0;
            } else if (p2Whammies == 4 && p1Cash == 0) {
                switchToPlayer = 1;
            } else if (p1Whammies == 4 && p2Cash == 0) {
                switchToPlayer = 2;
            } else if (p2Cash < p1Cash && p2Spins > 0) {
                switchToPlayer = 2;
            } else if (p1Cash < p2Cash && p1Spins > 0) {
                switchToPlayer = 1;
            } else if (p1Cash == p2Cash) {
                if (p2Spins < p1Spins) {
                    switchToPlayer = 2;
                } else if (p1Spins < p2Spins) {
                    switchToPlayer = 1;
                } else {
                    switchToPlayer = randomizer.nextInt(2);
                    switch (switchToPlayer) {
                        case 0:
                            switchToPlayer = 2;
                            break;
                        case 1:
                            switchToPlayer = 1;
                    }
                }
            }
            if (p3Whammies == 4) {
                System.out.println();
                System.out.println(player3 + " has 4 Whammies and has been eliminated from the game!");
                System.out.println();
                if (p2Spins == 0 && p1Spins == 0 || p2Whammies == 4 && p1Cash > 0 || p1Whammies == 4 && p2Cash > 0) {
                    switchToPlayer = 0;
                }
            }
        }
        if (p3Cash > 0 && p3Cash > p2Cash && p3Cash > p1Cash && p2Spins == 0 && p1Spins == 0) {
            switchToPlayer = 0;
        } else if (p3Spins > 0) {
            boolean player2Pass = false;
            boolean player1Pass = false;
            boolean choiceValidation = false;
            displayScores(player1, player2, player3);
            System.out.println();
            System.out.println(player3 + " has " + p3Spins + " spins(s) remaining.");
            System.out.println();
            System.out.println("Enter 0 to spin again");
            if (p1Whammies < 4) {
                player1Pass = true;
                System.out.println("Enter 1 to pass your " + p3Spins + " spin(s) to " + player1);
            }
            if (p2Whammies < 4) {
                player2Pass = true;
                System.out.println("Enter 2 to pass your " + p3Spins + " spin(s) to " + player2);
            }
            do {
                while (!userInput.hasNextInt()) { //Validation block.
                    System.out.println("Enter a valid choice:");
                    userInput.next();
                }
                int spinChoice = userInput.nextInt();
                switch (spinChoice) {
                    case 0:
                        choiceValidation = true;
                        switchToPlayer = 3;
                        break;
                    case 2:
                        if (player2Pass == true) {
                            switchToPlayer = 2;
                            choiceValidation = true;
                            p2PassedSpins = p2PassedSpins + p3Spins;
                            p3Spins = 0;
                        } else {
                            System.out.println("Enter a valid choice:");
                        }
                        break;
                    case 1:
                        if (player1Pass == true) {
                            switchToPlayer = 1;
                            choiceValidation = true;
                            p1PassedSpins = p1PassedSpins + p3Spins;
                            p3Spins = 0;
                        } else {
                            System.out.println("Enter a valid choice:");
                        }
                        break;
                    default:
                        System.out.println("Enter a valid choice:");
                }
            } while (choiceValidation == false);
        }
        if (switchToPlayer == 4) { //debug block
            System.out.println();
            System.out.println("OH NO!!! SWITCHING ERROR IN PLAYER 3 METHOD!");
            System.out.println();
            switchToPlayer = 0;
        }
        return switchToPlayer;
    } //close player3Turn

    /**
     * This method displays the game's current scores to the user.
     *
     * @param player1 Name string
     * @param player2 Name string
     * @param player3 Name string
     */
    public static void displayScores(String player1, String player2, String player3) {
        System.out.println();
        System.out.println("CURRENT SCORES:");
        System.out.println();
        System.out.println("*** " + player1 + " ***");
        System.out.println("Cash: $" + p1Cash);
        System.out.println("Spins: " + p1Spins);
        System.out.println("Whammies: " + p1Whammies);
        if (p1Whammies == 4) {
            System.out.println(player1 + " is out of the game!");
        }
        System.out.println();
        System.out.println("*** " + player2 + " ***");
        System.out.println("Cash: $" + p2Cash);
        System.out.println("Spins: " + p2Spins);
        System.out.println("Whammies: " + p2Whammies);
        if (p2Whammies == 4) {
            System.out.println(player2 + " is out of the game!");
        }
        System.out.println();
        System.out.println("*** " + player3 + " ***");
        System.out.println("Cash: $" + p3Cash);
        System.out.println("Spins: " + p3Spins);
        System.out.println("Whammies: " + p3Whammies);
        if (p3Whammies == 4) {
            System.out.println(player3 + " is out of the game!");
        }
        System.out.println();
    } //close displayScores

    /**
     * This method simulates a spin on the Big Board, and adds/deducts the
     * appropriate scores.
     *
     * @param player This is a control variable to choose which player's scores
     * to change.
     * @throws InterruptedException
     */
    public static void spin(int player) throws InterruptedException {
        Random randomizer = new Random();
        System.out.println("Press the enter key to spin the Big Board!");
        Scanner userInput = new Scanner(System.in);
        userInput.nextLine();
        System.out.println("-boop-");
        Thread.sleep(100);
        System.out.println("-beep-");
        Thread.sleep(100);
        System.out.println("-boop-");
        Thread.sleep(100);
        System.out.println("-boop-");
        Thread.sleep(100);
        System.out.println("-beep-");
        Thread.sleep(100);
        System.out.println("-beep-");
        Thread.sleep(100);
        System.out.println("-boop-");
        Thread.sleep(100);
        System.out.println("-beep-");
        Thread.sleep(100);
        System.out.println("-boop-");
        Thread.sleep(100);
        System.out.println("-boop-");
        Thread.sleep(100);
        System.out.println("-beep-");
        Thread.sleep(100);
        System.out.println("-beep-");
        Thread.sleep(100);
        System.out.println("-boop-");
        Thread.sleep(100);
        System.out.println("Big bucks!");
        Thread.sleep(800);
        System.out.println("No whammies!");
        Thread.sleep(800);
        System.out.println("aaaaand...");
        Thread.sleep(800);
        System.out.println("STOP!");
        Thread.sleep(1000);
        System.out.println();
        int spinResult = randomizer.nextInt(10);
        switch (spinResult) {
            case 0:
                System.out.println("--- WHAMMY! ---");
                if (player == 1) {
                    p1Whammies = p1Whammies + 1;
                    p1Spins = p1Spins + p1PassedSpins;
                    p1PassedSpins = 0;
                    p1Cash = 0;
                } else if (player == 2) {
                    p2Whammies = p2Whammies + 1;
                    p2Spins = p2Spins + p2PassedSpins;
                    p2PassedSpins = 0;
                    p2Cash = 0;
                } else if (player == 3) {
                    p3Whammies = p3Whammies + 1;
                    p3Spins = p3Spins + p3PassedSpins;
                    p3PassedSpins = 0;
                    p3Cash = 0;
                }
                break;
            case 1:
                System.out.println("--- WHAMMY! ---");
                if (player == 1) {
                    p1Whammies = p1Whammies + 1;
                    p1Spins = p1Spins + p1PassedSpins;
                    p1PassedSpins = 0;
                    p1Cash = 0;
                } else if (player == 2) {
                    p2Whammies = p2Whammies + 1;
                    p2Spins = p2Spins + p2PassedSpins;
                    p2PassedSpins = 0;
                    p2Cash = 0;
                } else if (player == 3) {
                    p3Whammies = p3Whammies + 1;
                    p3Spins = p3Spins + p3PassedSpins;
                    p3PassedSpins = 0;
                    p3Cash = 0;
                }
                break;
            case 2:
                System.out.println("--- $200 + A SPIN ---");
                if (player == 1) {
                    p1Cash = p1Cash + 200;
                    p1Spins = p1Spins + 1;
                } else if (player == 2) {
                    p2Cash = p2Cash + 200;
                    p2Spins = p2Spins + 1;
                } else if (player == 3) {
                    p3Cash = p3Cash + 200;
                    p3Spins = p3Spins + 1;
                }
                break;
            case 3:
                System.out.println("--- $500 + A SPIN ---");
                if (player == 1) {
                    p1Cash = p1Cash + 500;
                    p1Spins = p1Spins + 1;
                } else if (player == 2) {
                    p2Cash = p2Cash + 500;
                    p2Spins = p2Spins + 1;
                } else if (player == 3) {
                    p3Cash = p3Cash + 500;
                    p3Spins = p3Spins + 1;
                }
                break;
            case 4:
                System.out.println("--- $300 ---");
                if (player == 1) {
                    p1Cash = p1Cash + 300;
                } else if (player == 2) {
                    p2Cash = p2Cash + 300;
                } else if (player == 3) {
                    p3Cash = p3Cash + 300;
                }
                break;
            case 5:
                System.out.println("--- $500 ---");
                if (player == 1) {
                    p1Cash = p1Cash + 500;
                } else if (player == 2) {
                    p2Cash = p2Cash + 500;
                } else if (player == 3) {
                    p3Cash = p3Cash + 500;
                }
                break;
            case 6:
                System.out.println("--- $1000 ---");
                if (player == 1) {
                    p1Cash = p1Cash + 1000;
                } else if (player == 2) {
                    p2Cash = p2Cash + 1000;
                } else if (player == 3) {
                    p3Cash = p3Cash + 1000;
                }
                break;
            case 7:
                System.out.println("--- $100 ---");
                if (player == 1) {
                    p1Cash = p1Cash + 100;
                } else if (player == 2) {
                    p2Cash = p2Cash + 100;
                } else if (player == 3) {
                    p3Cash = p3Cash + 100;
                }
                break;
            case 8:
                System.out.println("--- $3000 ---");
                if (player == 1) {
                    p1Cash = p1Cash + 3000;
                } else if (player == 2) {
                    p2Cash = p2Cash + 3000;
                } else if (player == 3) {
                    p3Cash = p3Cash + 3000;
                }
                break;
            case 9:
                System.out.println("--- $1000 + A SPIN ---");
                if (player == 1) {
                    p1Cash = p1Cash + 1000;
                    p1Spins = p1Spins + 1;
                } else if (player == 2) {
                    p2Cash = p2Cash + 1000;
                    p2Spins = p2Spins + 1;
                } else if (player == 3) {
                    p3Cash = p3Cash + 1000;
                    p3Spins = p3Spins + 1;
                }
        }
        Thread.sleep(2000);
    } //close spin

} //close PressYourLuck
