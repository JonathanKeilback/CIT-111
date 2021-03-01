package week4;

import java.util.Scanner;

/**
 * Might we be friends? Chunk 1 project
 *
 * @author Jonathan
 */
public class MightWeBeFriends {

    public static void main(String[] friends) throws InterruptedException {

        //Initiate variables
        int q1Score = 0;
        int q2Score = 0;
        int q3Score = 0;
        int q4Score = 0;
        int compatScore;
        String userResponse;
        final int COMPAT_THRESHOLD = 20;

        //Initiate scanner for all responses
        Scanner userInput = new Scanner(System.in);

        System.out.println("Hey hey, I'm Jonathan, and this is a program to see if we might be friends!");

        //Start Question 1
        Thread.sleep(3000);
        System.out.println();
        System.out.println("|------------|");
        System.out.println("| QUESTION 1 |");
        System.out.println("|------------|");
        System.out.println();
        Thread.sleep(3000);
        System.out.println("First of all, I'm a musician, and music is a huge part of my life.");
        Thread.sleep(3000);
        System.out.println("Are any of these music genres amongst your favorite genres?");
        Thread.sleep(3000);

        //Question 1 Loop (It will only loop if there is an invalid response)
        while (q1Score == 0) {
            System.out.println("Type the number that corresponds with the genre of your choice and press enter!");
            Thread.sleep(2000);
            System.out.println("1. Clasic Rock");
            System.out.println("2. Jazz");
            System.out.println("3. Metal");
            System.out.println("4. Country");
            System.out.println("5. Punk");
            System.out.println("6. Psychedelic Rock");
            System.out.println("7. Classical");
            System.out.println("8. Synthwave");
            System.out.println("9. Progressive Rock");
            System.out.println("0. Other");

            userResponse = userInput.next();
            switch (userResponse) {
                case "1": //Classic Rock
                    Thread.sleep(1000);
                    System.out.println("That's right, rock n roll will never die!");
                    q1Score = 7;
                    break;
                case "2": //Jazz
                    Thread.sleep(1000);
                    System.out.println("A person of fine taste, I see...");
                    q1Score = 8;
                    break;
                case "3": //Metal
                    Thread.sleep(1000);
                    System.out.println("HORNS UP!");
                    q1Score = 15;
                    break;
                case "4": //Country
                    Thread.sleep(1000);
                    System.out.println("Hmm, okay...");
                    q1Score = -2;
                    break;
                case "5": //Punk
                    Thread.sleep(1000);
                    System.out.println("Punk ain't dead!");
                    q1Score = 6;
                    break;
                case "6": //Psychedelic Rock
                    Thread.sleep(1000);
                    System.out.println("That's like, trippy, duuuude.");
                    q1Score = 5;
                    break;
                case "7": //Classical
                    Thread.sleep(1000);
                    System.out.println("Very, very classy.");
                    q1Score = 5;
                    break;
                case "8": //Synthwave
                    Thread.sleep(1000);
                    System.out.println("Yes! Sunglasses and DeLoreans!");
                    q1Score = 10;
                    break;
                case "9": //Progressive Rock
                    Thread.sleep(1000);
                    System.out.println("You must be a sophisticated one.");
                    q1Score = 9;
                    break;
                case "0": //Other
                    Thread.sleep(1000);
                    System.out.println("No prob, I get it... there's a LOT of music out there in the world.");
                    q1Score = 2;
                    break;
                default: //Invalid response
                    Thread.sleep(1000);
                    System.out.println("You must choose an answer between the numbers 0-9.");
            } //End Question 1 Loop
        }
        //Start Question 2
        Thread.sleep(3000);
        System.out.println();
        System.out.println("|------------|");
        System.out.println("| QUESTION 2 |");
        System.out.println("|------------|");
        System.out.println();
        Thread.sleep(3000);
        System.out.println("When friends are doing things together, they typically go out for food.");
        Thread.sleep(3000);
        System.out.println("Of these options, where would you rather get a bite to eat?");
        Thread.sleep(3000);

        //Question 2 Loop (It will only loop if there is an invalid response)
        while (q2Score == 0) {
            System.out.println("Type the number that corresponds with the eatery of your choice and press enter!");
            Thread.sleep(2000);
            System.out.println("1. Sheetz");
            System.out.println("2. Anywhere with sushi!");
            System.out.println("3. A big-chain fast food joint (McDonalds, Wendy's, etc...)");
            System.out.println("4. A craft brewery with food trucks");
            System.out.println("5. Eat n Park, Denny's, etc. (casual dining)");
            System.out.println("6. A place with two nouns as the resturaunt name");
            System.out.println("7. The bar (because booze is food!)");
            System.out.println("8. Primanti Bros.");
            System.out.println("9. A quiet, unassuming little diner on the main drag of a tiny town.");
            System.out.println("0. Other");

            userResponse = userInput.next();
            switch (userResponse) {
                case "1": //Sheetz
                    Thread.sleep(1000);
                    System.out.println("Like an old friend, Sheetz is always there.");
                    q2Score = 6;
                    break;
                case "2": //Anywhere with sushi!
                    Thread.sleep(1000);
                    System.out.println("...except for SAGA, because I don't want to get sick!");
                    q2Score = 8;
                    break;
                case "3": //A big-chain fast food joint (McDonalds, Wendy's, etc...)
                    Thread.sleep(1000);
                    System.out.println("Fast food isn't very fast anymore...");
                    q2Score = 1;
                    break;
                case "4": //A craft brewery with food trucks
                    Thread.sleep(1000);
                    System.out.println("Oh, okay. No prob.");
                    q2Score = 4;
                    break;
                case "5": //Eat n Park, Denny's, etc. (casual dining)
                    Thread.sleep(1000);
                    System.out.println("Breakfast at 4PM!");
                    q2Score = 5;
                    break;
                case "6": //A place with two nouns as the resturaunt name
                    Thread.sleep(1000);
                    System.out.println("Pear and The Pickle, Meat & Potatoes, Dog Food & Cat Food...");
                    q2Score = -2;
                    break;
                case "7": //The bar (because booze is food!)
                    Thread.sleep(1000);
                    System.out.println("Beer is our daily bread!");
                    q2Score = 7;
                    break;
                case "8": //Primanti Bros.
                    Thread.sleep(1000);
                    System.out.println("Never gets old!");
                    q2Score = 10;
                    break;
                case "9": //A quiet, unassuming little diner on the main drag of a tiny town.
                    Thread.sleep(1000);
                    System.out.println("A little slice of Americana.");
                    q2Score = 9;
                    break;
                case "0": //Other
                    Thread.sleep(1000);
                    System.out.println("Lots of options out there, I understand.");
                    q2Score = 2;
                    break;
                default: //Invalid response
                    Thread.sleep(1000);
                    System.out.println("You must choose an answer between the numbers 0-9.");
            } //End Question 2 Loop
        }
        //Start Question 3
        Thread.sleep(3000);
        System.out.println();
        System.out.println("|------------|");
        System.out.println("| QUESTION 3 |");
        System.out.println("|------------|");
        System.out.println();
        Thread.sleep(3000);
        System.out.println("Choose an internet meme!");
        Thread.sleep(3000);

        //Question 3 Loop (It will only loop if there is an invalid response)
        while (q3Score == 0) {
            System.out.println("Type the number that corresponds with the meme of your choice and press enter!");
            Thread.sleep(2000);
            System.out.println("1. Skip this question");
            System.out.println("2. All your base are belong to us");
            System.out.println("3. Leave Britney alone!");
            System.out.println("4. Lämp and möth");
            System.out.println("5. Port Authority Bus in sinkhole");
            System.out.println("6. Doge");
            System.out.println("7. You're the man now, dog!");
            System.out.println("8. Bernie Sanders' mittens");
            System.out.println("9. These choices make no sense to me!");

            userResponse = userInput.next();
            switch (userResponse) {
                case "1": //Skip this question
                    Thread.sleep(1000);
                    System.out.println("No... let memes be dreams!");
                    q3Score = -3;
                    break;
                case "2": //All your base are belong to us
                    Thread.sleep(1000);
                    System.out.println("What you say?");
                    q3Score = 10;
                    break;
                case "3": //Leave Britney alone!
                    Thread.sleep(1000);
                    System.out.println("...");
                    q3Score = 1;
                    break;
                case "4": //Lämp and möth
                    Thread.sleep(1000);
                    System.out.println("Läääääääääämp");
                    q3Score = 6;
                    break;
                case "5": //Port Authority Bus in sinkhole
                    Thread.sleep(1000);
                    System.out.println("Bonk");
                    q3Score = 4;
                    break;
                case "6": //Doge
                    Thread.sleep(1000);
                    System.out.println("Very answer, much point");
                    q3Score = 7;
                    break;
                case "7": //You're the man now, dog!
                    Thread.sleep(1000);
                    System.out.println("Punch the keys, for God's sake!");
                    q3Score = 12;
                    break;
                case "8": //Bernie Sanders' mittens
                    Thread.sleep(1000);
                    System.out.println("Never gets old!");
                    q3Score = 5;
                    break;
                case "9": //These choices make no sense to me!
                    Thread.sleep(1000);
                    System.out.println("I promise you, they're not intended to make sense.");
                    q3Score = 1;
                    break;
                default: //Invalid response
                    Thread.sleep(1000);
                    System.out.println("You must choose an answer between the numbers 1-9.");
            } //End Question 3 Loop
        }
        //Start Question 4
        Thread.sleep(3000);
        System.out.println();
        System.out.println("|------------|");
        System.out.println("| QUESTION 4 |");
        System.out.println("|------------|");
        System.out.println();
        Thread.sleep(3000);
        System.out.println("What is a bass?");
        Thread.sleep(3000);
        //Question 4 Loop (It will only loop if there is an invalid response)
        while (q4Score == 0) {
            System.out.println("Type the number that corresponds with the answer of your choice and press enter!");
            Thread.sleep(2000);
            System.out.println("1. A fish");
            System.out.println("2. A type of guitar");

            userResponse = userInput.next();
            switch (userResponse) {
                case "1": //A fish
                    Thread.sleep(1000);
                    System.out.println("Okay, if you say so!");
                    q4Score = 1;
                    break;
                case "2": //A type of guitar
                    Thread.sleep(1000);
                    System.out.println("Okay, if you say so!");
                    q4Score = 8;
                    break;
                default: //Invalid response
                    Thread.sleep(1000);
                    System.out.println("You must choose 1 or 2 for your answer.");
            } //End Question 4 Loop
        }
        //TALLYING THE RESULTS OF THE SURVEY
        compatScore = q1Score + q2Score + q3Score + q4Score;
        Thread.sleep(2000);
        System.out.println("That's the end of the survey! Time to calculate your answers!");
        Thread.sleep(1000);
        System.out.println("Processing...");
        Thread.sleep(5000);
        if (compatScore >= COMPAT_THRESHOLD) {
            System.out.println();
            System.out.println("|----------------------|");
            System.out.println("| WE MIGHT BE FRIENDS! |");
            System.out.println("|----------------------|");
            System.out.println();
            Thread.sleep(2000);
            System.out.println("Well, ain't that swell!");
            Thread.sleep(2000);
        } else {
            System.out.println();
            System.out.println("|-----------------------|");
            System.out.println("| WE MAY NOT BE FRIENDS |");
            System.out.println("|-----------------------|");
            System.out.println();
            Thread.sleep(2000);
            System.out.println("That's a bummer...");
            Thread.sleep(2000);
        }
        System.out.println("Thank you for trying out my friend compatibility program!");
        Thread.sleep(2000);
    }
}
