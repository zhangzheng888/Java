
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiWithButtons2 extends JFrame {

    private Toolkit toolkit;
    private boolean drawIt;

    public GuiWithButtons2() {
        setTitle("Buttons");
        setSize(300, 200);
        toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width - getWidth())/2, (size.height - getHeight())/2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Add a panel to the frame, allow absolute positioning of widgets
        JPanel panel = new JPanel() {
        	@Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);              
                g.drawString("BLAH", 20, 20);
                g.drawRect(200, 200, 200, 200);
                if (drawIt) {
                	g.drawString("HELLO KEVIN !!!", 20, 20);
                	g.drawRect(10, 10, 190, 190);
                    g.setColor(Color.BLUE);
                    g.fillOval(50, 50, 100, 100);
                }
            }
        };
        
        
        
        getContentPane().add(panel);
        panel.setLayout(null);

        // Create a Beep button, set its position, say what to do when clicked
        JButton beep = new JButton("Beep");
        beep.setBounds(150, 60, 80, 30);
        beep.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent event) {
                    //toolkit.beep();                	
                	drawIt = true;
                    repaint();
                }

            });

        // Create the Close button and its listener
        JButton close = new JButton("Close");
        close.setBounds(50, 60, 80, 30);
        close.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    System.exit(0);
                }
            });

        // Add both buttons to the panel
        panel.add(beep);
        panel.add(close);
        
        
    }

    public static void main(String[] args) {
        GuiWithButtons buttons = new GuiWithButtons();
        buttons.setVisible(true);
    }
}