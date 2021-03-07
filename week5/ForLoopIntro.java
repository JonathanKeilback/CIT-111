package week5;

import java.util.Scanner;

/**
 * Chunk 1, Mod 5, For Loops exercise
 * @author Jonathan
 */
public class ForLoopIntro {
    public static void main(String[] args){
        int loopControl;
        Scanner userScanner = new Scanner(System.in);
        System.out.println("How many loops shall I print with for()?");
        loopControl = userScanner.nextInt();
        for(int numLoops = 0; numLoops <= loopControl; numLoops = numLoops +1){
            System.out.println("The value of numLoops: " + numLoops);
        }
    }
}
