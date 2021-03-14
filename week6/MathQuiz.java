package week6;

/**
 * Chunk 1, Mod 5, Math Quiz project
 *
 * @author Jonathan
 */
import java.util.Random;
import java.util.Scanner;

public class MathQuiz {

    public static void main(String[] args) throws InterruptedException {

        Random randGen = new Random(); //Initalize random number generator
        Scanner userInput = new Scanner(System.in); //Initalize scanner

        final int MEME_NUMBER = 9000; //Son Goku's power level, as reported by Vegeta's scouter while fighting Nappa
        //Yes, this is a Dragonball Z meme
        System.out.println("Welcome to Vegeta's Random Math Quiz!");
        Thread.sleep(2000);
        System.out.println("All answers are OVER " + MEME_NUMBER + "!");
        System.out.println();
        Thread.sleep(2000);

        //*****QUESTION 1*****
        //Question 1 variables
        boolean question1Answered = false; //Control variable for Question 2 routing
        int q1Tries = 3; //Control variable for looping
        
        //Random math problem variables
        int a = randGen.nextInt(15) + 10;
        int b = randGen.nextInt(11) + 15;
        int c = randGen.nextInt(10) + 1;
        int d = randGen.nextInt(91) + 11;
        int e = randGen.nextInt(10) + 1;
        int correctAnswer1 = (a * (b - c)) + (d % e) + MEME_NUMBER;
        int userAnswer;

        System.out.println("Solve this math problem to determine Son Goku's power level:");
        System.out.println();
        System.out.println("(" + a + "*(" + b + "-" + c + "))+(" + d + "%" + e + ")+" + MEME_NUMBER + "= ?");
        
        //Question 1 LOOP
        while (q1Tries != 0) {
            System.out.println();
            System.out.println("Type your answer and press Enter:");
            userAnswer = userInput.nextInt();
            if (userAnswer == correctAnswer1) {
                question1Answered = true;
                q1Tries = 0;
                System.out.println("Correct! Good job!");
            } else {
                q1Tries--;
                System.out.println("Nope! Wrong answer.");
                if (userAnswer > correctAnswer1) {
                    System.out.println("Your answer was HIGHER than the correct answer.");
                } else {
                    System.out.println("Your answer was LOWER than the correct answer.");
                }
                System.out.println("You have " + q1Tries + " more chance(s) to solve the problem.");
            }
        }//end Question 1 loop
        Thread.sleep(2000);
        System.out.println();
        System.out.println("Son Goku's power level is " + correctAnswer1 + "! That's right... IT'S OVER 9000!");
        Thread.sleep(2000);
        System.out.println();

        //*****Setting up Question 2*****
        boolean triggerQ2Easy = false;
        boolean triggerQ2Hard = false;
        if (question1Answered) {
            System.out.println("Since you got it right, I have an offer for you!");
            Thread.sleep(2000);
            System.out.println("Would you like to try a harder question?");
            Thread.sleep(2000);
            System.out.println("Enter 1 for YES. Enter any other number for NO.");
            userAnswer = userInput.nextInt();
            if (userAnswer == 1) {
                triggerQ2Hard = true;
                System.out.println("Okay! Lets do it!");
            } else {
                System.out.println("No prob. Good job answering the first question!");
            }
        } else {
            System.out.println("Because you got it wrong, I have an offer for you...");
            Thread.sleep(2000);
            System.out.println("Would you like to try an easier question?");
            Thread.sleep(2000);
            System.out.println("Enter 1 for YES. Enter any other number for NO.");
            userAnswer = userInput.nextInt();
            if (userAnswer == 1) {
                triggerQ2Easy = true;
                System.out.println("Okay! Lets do it!");
            } else {
                System.out.println("No prob.");
            }
        }
        Thread.sleep(2000);
        //*****HARD QUESTION 2*****
        if (triggerQ2Hard) {
            boolean question2HardAnswered = false; //Control variable for the next question, not used, implemented for future development
            int q2HardTries = 3; //Control variable for looping
            
            //Random math problem variables
            a = randGen.nextInt(7) + 2;
            b = randGen.nextInt(11) + 15;
            c = randGen.nextInt(10) + 1;
            d = randGen.nextInt(91) + 11;
            e = randGen.nextInt(10) + 2;
            int correctAnswer2Hard = a * (d % c) + b + MEME_NUMBER * e;

            System.out.println("Try this harder question to determine Son Goku's power level:");
            System.out.println();
            System.out.println(a + "*(" + d + "%" + c + ")+" + b + "+" + MEME_NUMBER + "*" + e);
            
            //Hard Question 2 loop
            while (q2HardTries != 0) {
                System.out.println();
                System.out.println("Type your answer and press Enter:");
                userAnswer = userInput.nextInt();
                if (userAnswer == correctAnswer2Hard) {
                    question2HardAnswered = true;
                    q2HardTries = 0;
                    System.out.println("Correct! Good job!");
                } else {
                    q2HardTries--;
                    System.out.println("Nope! Wrong answer.");
                    if (userAnswer > correctAnswer2Hard) {
                        System.out.println("Your answer was HIGHER than the correct answer.");
                    } else {
                        System.out.println("Your answer was LOWER than the correct answer.");
                    }
                    System.out.println("You have " + q2HardTries + " more chance(s) to solve the problem.");
                }
            } //end Hard Question 2 loop
            Thread.sleep(2000);
            System.out.println();
            System.out.println("Son Goku's power level is " + correctAnswer2Hard + "! That's right... IT'S WAAAYYY OVER 9000!");
            Thread.sleep(2000);
            System.out.println();
        }

        //*****EASY QUESTION 2*****
        if (triggerQ2Easy) {
            boolean question2EasyAnswered = false; //Control variable for the next question, not used, implemented for future development
            int q2EasyTries = 3; //Control variable for looping
            
            //Random math problem variables
            a = randGen.nextInt(15) + 10;
            b = randGen.nextInt(11) + 15;
            c = randGen.nextInt(10) + 1;
            d = randGen.nextInt(91) + 11;
            e = randGen.nextInt(10) + 1;
            int correctAnswer2Easy = a + b + d - c - e + MEME_NUMBER;

            System.out.println("Try this easier question to determine Son Goku's power level:");
            System.out.println();
            System.out.println(a + "+" + b + "+" + d + "-" + c + "-" + e + "+" + MEME_NUMBER + "= ?");
            
            //Easy Question 2 loop
            while (q2EasyTries != 0) {
                System.out.println();
                System.out.println("Type your answer and press Enter:");
                userAnswer = userInput.nextInt();
                if (userAnswer == correctAnswer2Easy) {
                    question2EasyAnswered = true;
                    q2EasyTries = 0;
                    System.out.println("Correct! Good job!");
                } else {
                    q2EasyTries--;
                    System.out.println("Nope! Wrong answer.");
                    if (userAnswer > correctAnswer2Easy) {
                        System.out.println("Your answer was HIGHER than the correct answer.");
                    } else {
                        System.out.println("Your answer was LOWER than the correct answer.");
                    }
                    System.out.println("You have " + q2EasyTries + " more chance(s) to solve the problem.");
                }
            } //end Easy Question 2 loop
            Thread.sleep(2000);
            System.out.println();
            System.out.println("Son Goku's power level is " + correctAnswer2Easy + "! That's right... IT'S STILL OVER 9000!");
            Thread.sleep(2000);
            System.out.println();
        }
        //*****END PROGRAM*****
        System.out.println("That's the end of the quiz!");
        Thread.sleep(2000);
        System.out.println("Yes, this program is referencing Dragon Ball Z (in case you didn't know).");
        Thread.sleep(2000);
        System.out.println("Hope you enjoyed the program! :)");
        System.out.println();
        Thread.sleep(2000);

    }//close Main method
}//close class
