package chunk1_mod2;

/**
 *
 * @author Jonathan
 */
public class OperatorsChallenge {
    public static void main(String[] args){
        
        //1.3 Variables, Operators, and If-Controlled Blocks
        //Exercise 0: Coding Exercise
        
        int a = 100;
        int b = 2000;
        double d = 10.5;
        String line1 = "Go Ask Alice";
        String line2 = "I think she'll know";
        
        int r = b / a;
        System.out.println("The value of variable r is: " + r);
        
        int mod = b % a;
        System.out.println("b % a is: " + mod);
        
        double rd = mod * d;
        System.out.println("The value of variable rd is: " + rd);
        
        a = a + 5;
        
        System.out.println("I'm about to compute the value of " + b + " mod " + a);
        rd = b % a;
        System.out.println("The value of variable rd is now: " + rd);
        
        System.out.println(line1);
        System.out.println(line2);
        System.out.println("Combined: " + line2 + " " + line1);
        System.out.println("Or is it " + line1 + " " + line2);
        
    }
}
