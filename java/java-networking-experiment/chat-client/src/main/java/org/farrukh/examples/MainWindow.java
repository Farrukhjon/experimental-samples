package org.farrukh.examples;

import javax.swing.*;
import java.awt.*;

public final class MainWindow {

    private static MainWindow instance;

    public static MainWindow getInstance() {
        return (instance != null) ? instance : (instance = new MainWindow());
    }

    private MainWindow() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        //frame.add(new MainPanel(), BorderLayout.CENTER);
        frame.add(new LeftPanel(), BorderLayout.WEST);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize().getSize();
        int height = size.height / 2;
        int width = size.width / 2;
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class MainPanel extends JPanel {
        public MainPanel() {
            super();
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add(new JTextArea());
            add(new JLabel("Message box:"));
            add(new JTextField());
        }
    }

    private class LeftPanel extends JPanel {

        private DefaultListModel listModel;

        public LeftPanel() {
            super();
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            listModel = new DefaultListModel();
            listModel.addElement("1");
            listModel.addElement("1");
            listModel.addElement("1");
            listModel.addElement("1");
            JList<String> contactList = new JList<>(listModel);
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.add(contactList);
            add(scrollPane);
        }
    }

}
