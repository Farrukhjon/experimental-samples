package model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class ImplementsTreeModel implements TreeModel {
	DefaultTreeModel		innerModel;

	DefaultMutableTreeNode	rootNode	= new DefaultMutableTreeNode(
												"UIDefaults");

	DefaultMutableTreeNode	colorNode	= new DefaultMutableTreeNode(
												"Color Resources");

	DefaultMutableTreeNode	borderNode	= new DefaultMutableTreeNode(
												"Border Resources");

	DefaultMutableTreeNode	fontNode	= new DefaultMutableTreeNode(
												"Font Resources");

	DefaultMutableTreeNode	iconNode	= new DefaultMutableTreeNode(
												"Icon Resources");

	DefaultMutableTreeNode	otherNode	= new DefaultMutableTreeNode(
												"Other Resources");

	@SuppressWarnings("rawtypes")
	public ImplementsTreeModel() {
		innerModel = new DefaultTreeModel(rootNode);
		innerModel.insertNodeInto(colorNode, rootNode, 0);
		innerModel.insertNodeInto(borderNode, rootNode, 1);
		innerModel.insertNodeInto(fontNode, rootNode, 2);
		innerModel.insertNodeInto(iconNode, rootNode, 3);
		innerModel.insertNodeInto(otherNode, rootNode, 4);
		UIDefaults defaults = UIManager.getDefaults();
		Enumeration elems = defaults.keys();
		String keyName;
		Object valueForKey;
		while (elems.hasMoreElements()) {
			DefaultMutableTreeNode newKeyNode;
			DefaultMutableTreeNode newValueNode;
			try {
				keyName = elems.nextElement().toString();
				valueForKey = defaults.get(keyName);

				newKeyNode = new DefaultMutableTreeNode(keyName);
				newValueNode = new DefaultMutableTreeNode(valueForKey);

				if (valueForKey instanceof java.awt.Color) {
					innerModel.insertNodeInto(newKeyNode, colorNode, 0);
				} else if (valueForKey instanceof javax.swing.border.Border) {
					innerModel.insertNodeInto(newKeyNode, borderNode, 0);
				} else if (valueForKey instanceof java.awt.Font) {
					innerModel.insertNodeInto(newKeyNode, fontNode, 0);
				} else if (valueForKey instanceof javax.swing.Icon) {
					innerModel.insertNodeInto(newKeyNode, iconNode, 0);
				} else {
					innerModel.insertNodeInto(newKeyNode, otherNode, 0);
				}
				innerModel.insertNodeInto(newValueNode, newKeyNode, 0);
			} catch (NullPointerException e) {
			}
		}
	}

	public Object getRoot() {
		return innerModel.getRoot();
	}

	public Object getChild(Object parm1, int parm2) {
		return innerModel.getChild(parm1, parm2);
	}

	public int getChildCount(Object parm1) {
		return innerModel.getChildCount(parm1);
	}

	public boolean isLeaf(Object parm1) {
		return innerModel.isLeaf(parm1);
	}

	public void valueForPathChanged(TreePath parm1, Object parm2) {
		innerModel.valueForPathChanged(parm1, parm2);
	}

	public int getIndexOfChild(Object parm1, Object parm2) {
		return innerModel.getIndexOfChild(parm1, parm2);
	}

	public void addTreeModelListener(TreeModelListener parm1) {
		innerModel.addTreeModelListener(parm1);
	}

	public void removeTreeModelListener(TreeModelListener parm1) {
		innerModel.removeTreeModelListener(parm1);
	}

	public static void main(String[] args) {
		JFrame treeFrame1 = new JFrame();

		JScrollPane jScrollPane1 = new JScrollPane();
		JTree jTree1 = new JTree(new ImplementsTreeModel());

		treeFrame1.setSize(new Dimension(400, 300));
		treeFrame1.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
		});
		treeFrame1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		treeFrame1.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
		jScrollPane1.getViewport().add(jTree1, null);

		treeFrame1.setVisible(true);
	}
}
