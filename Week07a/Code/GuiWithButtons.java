import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class GuiWithButtons extends JFrame {

    private Toolkit toolkit;

    public GuiWithButtons() {
        setTitle("Buttons");
        setSize(300, 500);
        toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width - getWidth())/2, (size.height - getHeight())/2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Add a panel to the frame, allow absolute positioning of widgets
        JPanel panel = new JPanel();
        getContentPane().add(new GPanel());
        panel.setLayout(null);

        // Create a Beep button, set its position, say what to do when clicked
        JButton beep = new JButton("Beep");
        beep.setBounds(150, 60, 80, 30);
        beep.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent event) {
                    toolkit.beep();
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
        //panel.add(beep);
        //panel.add(close);
        
        //JPanel panel2 = new JPanel();
        //getContentPane().add(panel2);
        panel.setPreferredSize(new Dimension(100, 200));
        //panel2.setLayout(null);
        //panel.setBackground(Color.BLACK);
        //panel.add(panel2);
        //panel.add(new GPanel());
    }
    
    

    public static void main(String[] args) {
        GuiWithButtons buttons = new GuiWithButtons();
        buttons.setVisible(true);
    }
}

class GPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawRect(10, 10, 190, 190);
            g.setColor(Color.BLUE);
            g.fillOval(50, 50, 100, 100);
        }
    }