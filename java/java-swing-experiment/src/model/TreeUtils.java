package model;

import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class TreeUtils {
	public static void expandAll(JTree tree, TreePath parent, boolean expand) {
	    // Traverse children
	    TreeNode node = (TreeNode) parent.getLastPathComponent();
	    if (node.getChildCount() >= 0) {
	      for (@SuppressWarnings("rawtypes")
		Enumeration e = node.children(); e.hasMoreElements();) {
	        TreeNode n = (TreeNode) e.nextElement();
	        TreePath path = parent.pathByAddingChild(n);
	        expandAll(tree, path, expand);
	      }
	    }

	    // Expansion or collapse must be done bottom-up
	    if (expand) {
	      tree.expandPath(parent);
	    } else {
	      tree.collapsePath(parent);
	    }
	  }
}
