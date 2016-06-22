package model;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;


public class JTreeGetModel {
	 public static void main(String args[]) {
		    JFrame f = new JFrame("JTree Demo");
		    f.setSize(260, 240);
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		    DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		    DefaultMutableTreeNode aNode = new DefaultMutableTreeNode("A");
		    root.add(aNode);

		    DefaultMutableTreeNode bNode = new DefaultMutableTreeNode("B");
		    aNode.add(bNode);

		    DefaultMutableTreeNode cNode = new DefaultMutableTreeNode("C");
		    aNode.add(cNode);

		    cNode.add(new DefaultMutableTreeNode("D"));
		    cNode.add(new DefaultMutableTreeNode("E"));

		    DefaultMutableTreeNode fNode = new DefaultMutableTreeNode("F");
		    root.add(fNode);

		    DefaultMutableTreeNode gNode = new DefaultMutableTreeNode("G");
		    fNode.add(gNode);
		    fNode.add(new DefaultMutableTreeNode("H"));
		    gNode.add(new DefaultMutableTreeNode("I"));

		    JTree jtree = new JTree(root);
		    jtree.setEditable(true);

		    TreeSelectionModel tsm = jtree.getSelectionModel();
		    tsm.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		    jtree.addTreeExpansionListener(new TreeExpansionListener() {
		      public void treeExpanded(TreeExpansionEvent tee) {
		        TreePath tp = tee.getPath();
		        System.out.println("Expansion: " + tp.getLastPathComponent());
		      }

		      public void treeCollapsed(TreeExpansionEvent tee) {
		        TreePath tp = tee.getPath();
		        System.out.println("Collapse: " + tp.getLastPathComponent());
		      }
		    });

		    jtree.addTreeSelectionListener(new TreeSelectionListener() {
		      public void valueChanged(TreeSelectionEvent tse) {
		        TreePath tp = tse.getPath();
		        System.out.println("Selection event: " + tp.getLastPathComponent());
		      }
		    });

		    jtree.getModel().addTreeModelListener(new TreeModelListener() {
		      public void treeNodesChanged(TreeModelEvent tme) {
		        TreePath tp = tme.getTreePath();
		        Object[] children = tme.getChildren();
		        DefaultMutableTreeNode changedNode;
		        if (children != null)
		          changedNode = (DefaultMutableTreeNode) children[0];
		        else
		          changedNode = (DefaultMutableTreeNode) tp.getLastPathComponent();

		        System.out.println("Model change path: " + tp + "New data: "
		            + changedNode.getUserObject());

		      }

		      public void treeNodesInserted(TreeModelEvent tme) {
		      }

		      public void treeNodesRemoved(TreeModelEvent tme) {
		      }

		      public void treeStructureChanged(TreeModelEvent tme) {
		      }
		    });

		    f.add(new JScrollPane(jtree));
		    f.setVisible(true);
		  }
}
