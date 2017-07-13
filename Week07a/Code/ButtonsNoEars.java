import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonsNoEars extends JFrame {

    private Toolkit toolkit;

    public ButtonsNoEars() {
        setTitle("Buttons");
        setSize(300, 200);
        toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width - getWidth())/2, (size.height - getHeight())/2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Add a panel to the frame, allow absolute positioning of widgets
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        // Create a Beep button, set its position
        JButton beep = new JButton("Beep");
        beep.setBounds(150, 60, 80, 30);

        // Create the Close button and its listener
        JButton close = new JButton("Close");
        close.setBounds(50, 60, 80, 30);

        // Add both buttons to the panel
        panel.add(beep);
        panel.add(close);
    }

    public static void main(String[] args) {
        ButtonsNoEars buttons = new ButtonsNoEars();
        buttons.setVisible(true);
    }
}