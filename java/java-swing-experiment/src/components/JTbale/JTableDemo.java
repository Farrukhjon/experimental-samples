package components.JTbale;

import javax.swing.JFrame;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class JTableDemo extends JFrame {

	public JTableDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new JTable(new UserTableModel()));
		setSize(500, 250);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JTableDemo();
	}

}
