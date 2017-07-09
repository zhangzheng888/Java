import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

/**
 * Demonstrate the basics of drawing using DrawingPanel
 * 
 * @author      Bill Barry
 * @version     2017-01-13
 */
public class SimpleDemo {
    
    public static void main(String[] args) {
        // Set up drawing panel and graphics
        DrawingPanel dp = new DrawingPanel( 300, 300);
        dp.setBackground(Color.WHITE);
        Graphics dpg = dp.getGraphics();

        // Draw an "x" through the space
        dpg.drawLine(  0,   0, 299, 299);
        dpg.drawLine(  0, 299, 299,   0);

        // Draw the outline of the rectangle, in black, then fill 
        // in the rectangle, being careful not to draw over the outline
        dpg.drawRect(149, 0, 150, 150);
        dpg.setColor(Color.BLUE);
        dpg.fillRect(149 + 1, 0 + 1, 150 - 1, 150 - 1);
        
        // Write something on the canvas
        Font myFont = new Font("Arial", Font.PLAIN, 12);
        dpg.setFont(myFont);
        dpg.drawString("Bill Was Here", 0, 12);
    }
}
