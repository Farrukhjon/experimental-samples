package components.JMenuBar;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ContructMenuWithAction {
	public static void main(final String args[]) {
		JFrame frame = new JFrame("MenuSample Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();

		// File Menu, F - Mnemonic
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);

		fileMenu.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				System.out.println("File Menu Changed");

			}
		});

		// File->New, N - Mnemonic
		JMenuItem newMenuItem = new JMenuItem("New");
		fileMenu.add(newMenuItem);

		newMenuItem.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				System.out.println("new menu item changed");
			}
		});

		frame.setJMenuBar(menuBar);
		frame.setSize(350, 250);
		frame.setVisible(true);
	}
}
