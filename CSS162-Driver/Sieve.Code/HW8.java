import java.util.Scanner;

/**
 Driver file for HW8 to exercise the Sieve class
 
 @author Clark Olson
 */
public class HW8
{

    /**
     main program to exercise the Sieve class
     pre:  None.
     post: Detects the primes between 2 and a user-specified value.
     */
    static public void main(String[] args) {
        Sieve mySieve = new Sieve();
        Scanner keyboard = new Scanner(System.in);
        
        int number = 1;
        while (number > 0) {
            System.out.print("Maximum n to compute (0 to quit)? ");
            number = keyboard.nextInt();
            if (number > 0) {
                System.out.println();
                System.out.println("Primes up to " + number + " are as follows:");
                mySieve.computeTo(number);
                mySieve.reportResults();
                System.out.println("% of primes = " + 100 * mySieve.getCount() / mySieve.getMax());
                System.out.println();
            }
        }  
    }
    
}
