package org.farrukh.examples.patterns.behavioral.memento.ch1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Client extends JFrame {

	private JButton		saveBtn, undoBtn, redoBtn;
	private JTextArea	textArticle	= new JTextArea(40, 60);

	CareTaker			careTaker	= new CareTaker();
	Originator			originator	= new Originator();
	int					saveFiles	= 0, currentArticle = 0;

	public Client() {
		setSize(750, 780);
		setTitle("Momento Design Pattern");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("theArticle"));

		ButtonListener saveListener = new ButtonListener();
		ButtonListener undoListener = new ButtonListener();
		ButtonListener redoListener = new ButtonListener();

		saveBtn = new JButton("Save");
		saveBtn.addActionListener(saveListener);

		undoBtn = new JButton("Undo");
		undoBtn.addActionListener(undoListener);

		redoBtn = new JButton("Redo");
		redoBtn.addActionListener(redoListener);

		panel1.add(textArticle);
		panel1.add(saveBtn);
		panel1.add(undoBtn);
		panel1.add(redoBtn);

		add(panel1);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Client();
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == saveBtn) {

				String textInTextArea = textArticle.getText();
				originator.setArticle(textInTextArea);
				careTaker.addMomnto(originator.storeInMomento());
				saveFiles++;
				currentArticle++;
				System.out.println("Save Files" + saveFiles);
				undoBtn.setEnabled(true);

			} else if (e.getSource() == undoBtn) {
				if (currentArticle >= 1) {
					currentArticle--;
					String textBoxString = originator.restoreFromMomento(careTaker.getMomento(currentArticle));
					textArticle.setText(textBoxString);
					redoBtn.setEnabled(true);
				} else {
					undoBtn.setEnabled(false);
				}
			} else if (e.getSource() == redoBtn) {
				if ((saveFiles - 1) > currentArticle) {
					currentArticle++;
					String textBoxString = originator.restoreFromMomento(careTaker.getMomento(currentArticle));
					textArticle.setText(textBoxString);
					undoBtn.setEnabled(true);
				} else {
					redoBtn.setEnabled(false);
				}
			}
		}
	}

}
