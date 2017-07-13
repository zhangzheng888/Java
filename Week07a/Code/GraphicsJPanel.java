import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class GraphicsJPanel extends JFrame {

    private Toolkit toolkit;

    public GraphicsJPanel() {
        setSize(220, 240);
        toolkit = getToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setLocation((screenSize.width - getWidth())/2, (screenSize.height - getHeight())/2);
        setTitle("Graphics on a JPanel");
        setResizable(false);

        JPanel panel = new GPanel();
        getContentPane().add(panel);
        panel.setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class GPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawRect(10, 10, 190, 190);
            g.setColor(Color.BLUE);
            g.fillOval(50, 50, 100, 100);
        }
    }

    public static void main(String[] args) {
        GraphicsJPanel myFrame = new GraphicsJPanel();
        myFrame.setVisible(true);
    }
}
