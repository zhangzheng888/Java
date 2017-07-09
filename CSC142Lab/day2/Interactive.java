import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.util.Scanner;

/**
 * Challenge Exercise for Week2b - gathering user data to draw a graphical box
 * 
 * @author      Bill Barry 
 * @version     2017-01-12
 */
public class Interactive {
    
    public static void main(String[] args) {
        // Set up the Scanner and associate it with the keyboard
        Scanner conIn = new Scanner(System.in);

        // Get the user's name
        System.out.print("What is your name? ");
        String userName = conIn.next();
        conIn.nextLine();
        
        // Get box dimensions
        System.out.print("Specify box width (1 to 400): ");
        int boxWidth = conIn.nextInt();
        System.out.print("Specify box height (1 to 400): ");
        int boxHeight = conIn.nextInt();

        // Set up drawing panel and graphics
        DrawingPanel dp = new DrawingPanel( 500, 500);
        dp.setBackground(Color.WHITE);
        Graphics dpg = dp.getGraphics();

        // Draw a red box of the specified size
        dpg.setColor(Color.RED);
        dpg.fillRect(50, 75, boxWidth, boxHeight);
        
        // Draw a greeting to the user
        dpg.setColor(Color.BLACK);
        dpg.setFont(new Font("Courier New", Font.BOLD, 24));
        dpg.drawString("HELLO " + userName, 0, 500);
        
        // Let user know the program is done
        System.out.println("\nProgram has completed.  Goodbye.");

    }
}
