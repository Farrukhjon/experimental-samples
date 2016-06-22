package components.JDesktopPane;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;

public class InternalFramePaletteSample {
	
	public static void main(final String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JDesktopPane desktop = new JDesktopPane();
		// desktop.scrollRectToVisible(new Rectangle());
		JInternalFrame palette = new JInternalFrame("Palette", true, true, true, true);
		palette.setBounds(350, 150, 100, 100);
		palette.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
		desktop.add(palette, JDesktopPane.PALETTE_LAYER);
		palette.setVisible(true);

		frame.add(desktop, BorderLayout.CENTER);
		frame.setSize(500, 300);
		frame.setVisible(true);
	}
}
