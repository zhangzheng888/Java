import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;

public class JFrameLoc extends JFrame {
    
    private Toolkit toolkit;
    
    public JFrameLoc() {
        setSize(300, 200);
        toolkit = getToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setLocation((screenSize.width - getWidth())/2, (screenSize.height - getHeight())/2);
        setTitle("My Smarter JFrame");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFrameLoc myFrame = new JFrameLoc();
        myFrame.setVisible(true);
    }
}
