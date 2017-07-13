import javax.swing.JFrame;

public class SimpleJFrame extends JFrame {
    public SimpleJFrame() {
        setSize(300, 200);
        setTitle("My Simple JFrame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SimpleJFrame simple = new SimpleJFrame();
        simple.setVisible(true);
    }
}
