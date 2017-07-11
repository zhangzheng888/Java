
import java.util.Scanner;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class UserBox
{
    public static void main (String [] args) {
    //get user name
    
    Scanner conInput = new Scanner(System.in);
    System.out.print("What is your name? ");
    String userName = conInput.next();
    conInput.nextLine();

    //get box dimensions
    System.out.print("Specify box width (1 to 100): ");
    int boxWidth = conInput.next();
    System.out.print("Specify box length (1 to 100): ");
    int boxHeight = conInput.next();
    
    //set up drawing panel
    DrawingPanel dpanel = new DrawingPanel (200, 200);
    
    //dpanel is a reference variable that points to the drawing panel
    dpanel.setBackground(Color.BROWN);
    Graphics dpg = dpanel.getGraphics();
    
    
    //draw the salutation and the box
    dpg.setColor(Color.BLUE);
    dpg.fillRect(50, 50, boxWidth, boxHeight);
    dpg.setFont(new Font ("Arial Bold", Font.PLAIN, 12));
    
    // userName.toUpperCase(); strings are immutable
    
    userName = userName.toUpperCase();
    dpg.drawString ("Hello " + userName, 0, 14);
    }
}
