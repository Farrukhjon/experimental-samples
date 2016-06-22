package formating;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class TimeZoneSpinners {

	private final String[]				zones	= { "Asia/Tokyo", "Asia/Hong_Kong", "Asia/Calcutta", "Europe/Paris", "Europe/London", "America/New_York", "America/Los_Angeles" };
	private final JLabel[]				labels	= new JLabel[zones.length];
	private final SimpleDateFormat[]	formats	= new SimpleDateFormat[zones.length];
	private JSpinner					spinner;
	private SpinnerDateModel			model;
	private SimpleDateFormat			format;
	private JPanel						panel;
	private JFrame						frame	= new JFrame();

	public void makeUI() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		model = new SpinnerDateModel();
		model.setValue(date);
		spinner = new JSpinner(model);
		spinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Date date = (Date) ((JSpinner) e.getSource()).getValue();
				for (int i = 0; i < labels.length; i++) {
					labels[i].setText(formats[i].format(date));
				}
			}
		});
		format = ((JSpinner.DateEditor) spinner.getEditor()).getFormat();
		format.setTimeZone(TimeZone.getTimeZone(zones[0]));
		format.applyPattern("yyyy-MM-dd HH:mm:ss");
		panel = new JPanel(new GridLayout(zones.length, 2, 10, 10));
		for (int i = 0; i < zones.length; i++) {
			formats[i] = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
			formats[i].setTimeZone(TimeZone.getTimeZone(zones[i]));
			JLabel label = new JLabel(zones[i]);
			labels[i] = new JLabel(formats[i].format(date));
			panel.add(label);
			panel.add(labels[i]);
		}
		frame.setLayout(new BorderLayout(10, 10));
		frame.add(spinner, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new TimeZoneSpinners().makeUI();
			}
		});
	}
}
