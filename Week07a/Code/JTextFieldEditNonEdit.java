// A program to demonstrate the use of JTextFields's
//Import Statements
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JTextFieldEditNonEdit extends JFrame {

	//Class Declarations
	JTextField jtfTextEd, jtfTextNonEd;
	String disp = "";
	TextHandler handler = null;
	
	//Constructor
	public JTextFieldEditNonEdit() {
		super("TextField Test Demo");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		jtfTextEd = new JTextField(10);
		jtfTextNonEd = new JTextField("You can't edit me!", 20);
		jtfTextNonEd.setEditable(false);
		container.add(jtfTextEd);
		container.add(jtfTextNonEd);
		handler = new TextHandler();
		jtfTextEd.addActionListener(handler);
		jtfTextNonEd.addActionListener(handler);
		setSize(325, 100);
		setVisible(true);
	}
	
	//Inner Class TextHandler
	private class TextHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jtfTextEd) {
				disp = "jtfTextEd : " + e.getActionCommand();
			} else if (e.getSource() == jtfTextNonEd) {
				disp = "jtfTextNonEd : " + e.getActionCommand();
			}
			JOptionPane.showMessageDialog(null, disp);
		}
	}
	
	//Main Program that starts Execution
	public static void main(String args[]) {
		JTextFieldEditNonEdit test = new JTextFieldEditNonEdit();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}