package layout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class SpringLayoutDemo extends JFrame {

	public SpringLayoutDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 320);
		setLayout(new SpringLayout());
		final JLabel lblName = new JLabel("name");
		add(lblName);
		final JLabel lblSurname = new JLabel("surname");
		add(lblSurname);
		final JLabel lblPatronimic = new JLabel("patronymic");
		add(lblPatronimic);
		final JLabel lblAge = new JLabel("age");
		add(lblAge);
		final JTextField fldName = new JTextField(1);
		add(fldName);
		final JTextField fldSurname = new JTextField(2);
		add(fldSurname);
		final JTextField fldPatronymic = new JTextField(3);
		add(fldPatronymic);
		final JTextField fldAge = new JTextField(4);
		add(fldAge);
		lblName.setLabelFor(fldName);
		lblSurname.setLabelFor(fldSurname);
		lblPatronimic.setLabelFor(fldPatronymic);
		lblAge.setLabelFor(fldAge);
		SpringUtilities.makeGrid(this, 2, 2, 100, 300, 20, 20);
		// pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new SpringLayoutDemo();
	}

}
