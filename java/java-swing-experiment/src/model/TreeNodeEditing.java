package model;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

public class TreeNodeEditing {
	public static void main(String[] args) {
		MutableTreeNode root = new DefaultMutableTreeNode("A");
		MutableTreeNode beams = new DefaultMutableTreeNode("B");
		MutableTreeNode gears = new DefaultMutableTreeNode("C");
		root.insert(beams, 0);
		root.insert(gears, 1);
		beams.insert(new DefaultMutableTreeNode("4 "), 0);
		beams.insert(new DefaultMutableTreeNode("6 "), 1);
		beams.insert(new DefaultMutableTreeNode("8 "), 2);
		beams.insert(new DefaultMutableTreeNode("12 "), 3);
		gears.insert(new DefaultMutableTreeNode("8t"), 0);
		gears.insert(new DefaultMutableTreeNode("24t"), 1);
		gears.insert(new DefaultMutableTreeNode("40t"), 2);

		final DefaultTreeModel model = new DefaultTreeModel(root);
		final JTree tree = new JTree(model);

		final JTextField nameField = new JTextField("16t");
		final JButton button = new JButton("Add a part");
		button.setEnabled(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreePath tp = tree.getSelectionPath();
				MutableTreeNode insertNode = (MutableTreeNode) tp.getLastPathComponent();
				int insertIndex = 0;
				if (insertNode.getParent() != null) {
					MutableTreeNode parent = (MutableTreeNode) insertNode.getParent();
					insertIndex = parent.getIndex(insertNode) + 1;
					insertNode = parent;
				}
				MutableTreeNode node = new DefaultMutableTreeNode(nameField.getText());
				model.insertNodeInto(node, insertNode, insertIndex);
			}
		});
		JPanel addPanel = new JPanel(new GridLayout(2, 1));
		addPanel.add(nameField);
		addPanel.add(button);

		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				TreePath tp = e.getNewLeadSelectionPath();
				button.setEnabled(tp != null);
			}
		});

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.getContentPane().add(new JScrollPane(tree));
		frame.getContentPane().add(addPanel, BorderLayout.SOUTH);
		frame.setVisible(true);
	}
}
