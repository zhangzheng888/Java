import java.util.Scanner;

/**
 * Experimenting with Scanner lookahead
 * 
 * @author      Bill Barry
 * @version     2017-01-14
 */
public class ScannerLookahead {

    public static void main(String[] args) {

        Scanner conIn = new Scanner(System.in);
        int userAge;
        
        System.out.print("Enter your age: ");
        while (!conIn.hasNextInt()) {
            conIn.next();
            System.out.print("Enter your age (whole numbers only): ");
        }
        userAge = conIn.nextInt();
        System.out.println("\nUser's age is: " + userAge);
    }

}
