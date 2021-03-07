package week5;

import java.util.Scanner;

/**
 * Chunk 1, Mod 5, Drawing Loops - Retirement Age exercise
 * @author Jonathan
 */
public class RetirementAge {
    public static void main(String[] args){
        int age;
        int numOfInquiries = 0; //int to track total inquiries
        int overAge = 0; //int to track retirement age inquiries
        int underAge = 0; //int to track under age inquiries
        int invalidResponse = 0; //int to track invalid responses
        
        Scanner inputScanner = new Scanner(System.in);
        while (true){ //Start loop
            System.out.println("Enter your age to see if you can retire (enter 0 to exit program):");
            age = inputScanner.nextInt();
            if (age == 0){ //Ends program, displays inquiry summary to the user.
                System.out.println("Thanks for using the program.");
                System.out.println(numOfInquiries + " inquiries were made with this program.");
                System.out.println(overAge + " inquiries met the retirement age.");
                System.out.println(underAge + " inquiries were under the retirement age.");
                System.out.println(invalidResponse + " inquiries were invalid.");
                break;
            } else if (age < 0){ //I removed the break since there's now an option to leave the program.
                System.out.println("Invalid response.");
                numOfInquiries = numOfInquiries + 1;
                invalidResponse = invalidResponse + 1;
            } else if (age > 123){ //The oldest person in history was 122 years old, so I set the threshold to 123.
                System.out.println("Invalid response.");
                numOfInquiries = numOfInquiries + 1;
                invalidResponse = invalidResponse + 1;
            } else if (age >= 65){ //Meets retirement age
                System.out.println("Wahoo! Grab the newspaper and a martini!");
                numOfInquiries = numOfInquiries + 1;
                overAge = overAge + 1;
            } else { //does not meet retirement age
                System.out.println("Sorry, Keep working...");
                numOfInquiries = numOfInquiries + 1;
                underAge = underAge + 1;
            }
        } //end loop
        
    } //end main method
    
} //end class