import java.util.Scanner;

/**
 * Console-based menu program offering temperature conversions to and from C, F, and K
 * 
 * @author      Bill Barry
 * @version     2011-01-14
 */
public class TempConvDoWhile {
    
    public static void main(String[] args) {
        Scanner conIn = new Scanner(System.in);
        int choice;
        double inputTemp, result;
        
        do {
            System.out.println("\n\nTemperature Conversion Menu\n");
            System.out.println("1.  Fahrenheit to Celcius");
            System.out.println("2.  Fahrenheit to Kelvin");
            System.out.println("3.  Celsius to Fahrenheit");
            System.out.println("4.  Celcius to Kelvin");
            System.out.println("5.  Kelvin to Fahrenheit");
            System.out.println("6.  Kelvin to Celsius\n");
            System.out.println("0.  EXIT\n");
            System.out.print("Enter your choice: ");
            
            // Make sure we get an integer choice
            while (!conIn.hasNextInt()) {
                conIn.next();
                System.out.print("Enter your choice: ");
            }
            choice = conIn.nextInt();
            
            if (choice >= 1 && choice <= 6) {
                System.out.print("Enter the input temperature: ");
                inputTemp = conIn.nextDouble();
                result = 0.0;
                
                if (choice == 1) {
                    result = TempConversion.fToC(inputTemp);
                }
                else if (choice == 2) {
                    result = TempConversion.fToK(inputTemp);
                }
                else if (choice == 3) {
                    result = TempConversion.cToF(inputTemp);
                }
                else if (choice == 4) {
                    result = TempConversion.cToK(inputTemp);
                }
                else if (choice == 5) {
                    result = TempConversion.kToF(inputTemp);
                }
                else if (choice == 6) {
                    result = TempConversion.kToC(inputTemp);
                }
                System.out.printf("Converted temperature is: %8.2f\n", result);      // DEMO NOTE:  motivate need by choosing F to C and entering 10
            }
        } while (choice != 0);
        System.out.println("Goodbye");
    }

}