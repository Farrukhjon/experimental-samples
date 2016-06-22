package components.JMenuBar;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JMenuBar;

public class VerticalMenuBar extends JMenuBar {

	private static final long			serialVersionUID	= 1L;
	private static final LayoutManager	grid				= new GridLayout(0, 1);

	public VerticalMenuBar() {
		setLayout(grid);
	}
}
