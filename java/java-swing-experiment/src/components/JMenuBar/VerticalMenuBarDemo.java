package components.JMenuBar;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class VerticalMenuBarDemo {
	public static void main(final String args[]) {
	    JFrame frame = new JFrame("MenuSample Example");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JMenuBar menuBar = new VerticalMenuBar();

	    // File Menu, F - Mnemonic
	    JMenu fileMenu = new JMenu("File");
	    fileMenu.setMnemonic(KeyEvent.VK_F);
	    menuBar.add(fileMenu);
	    fileMenu.add(new JMenuItem("1fdsfas"));
	    fileMenu.add(new JMenuItem("2dsfds"));
	    fileMenu.add(new JMenuItem("3fsdfds"));

	    JMenu editMenu = new JMenu("Edit");
	    menuBar.add(editMenu);
	    editMenu.add(new JMenuItem("1dasdsad"));
	    editMenu.add(new JMenuItem("2dsadasdsa"));
	    editMenu.add(new JMenuItem("3hfdgdsgds"));
	    
	    frame.setJMenuBar(menuBar);
	    frame.setSize(350, 250);
	    frame.setVisible(true);
	  }

}
