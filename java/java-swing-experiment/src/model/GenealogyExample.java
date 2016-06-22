package model;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

@SuppressWarnings("serial")
public class GenealogyExample extends JPanel implements ActionListener {
	GenealogyTree tree;
	  private static String SHOW_ANCESTOR_CMD = "showAncestor";

	  public GenealogyExample() {
	    super(new BorderLayout());

	    // Construct the panel with the toggle buttons.
	    JRadioButton showDescendant = new JRadioButton("Show descendants", true);
	    final JRadioButton showAncestor = new JRadioButton("Show ancestors");
	    ButtonGroup bGroup = new ButtonGroup();
	    bGroup.add(showDescendant);
	    bGroup.add(showAncestor);
	    showDescendant.addActionListener(this);
	    showAncestor.addActionListener(this);
	    showAncestor.setActionCommand(SHOW_ANCESTOR_CMD);
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.add(showDescendant);
	    buttonPanel.add(showAncestor);

	    // Construct the tree.
	    tree = new GenealogyTree(getGenealogyGraph());
	    JScrollPane scrollPane = new JScrollPane(tree);
	    scrollPane.setPreferredSize(new Dimension(200, 200));

	    // Add everything to this panel.
	    add(buttonPanel, BorderLayout.PAGE_START);
	    add(scrollPane, BorderLayout.CENTER);
	  }

	  /**
	   * Required by the ActionListener interface. Handle events on the
	   * showDescendant and showAncestore buttons.
	   */
	  public void actionPerformed(ActionEvent ae) {
	    if (ae.getActionCommand() == SHOW_ANCESTOR_CMD) {
	      tree.showAncestor(true);
	    } else {
	      tree.showAncestor(false);
	    }
	  }

	  /**
	   * Constructs the genealogy graph used by the model.
	   */
	  public Person getGenealogyGraph() {
	    // the greatgrandparent generation
	    Person a1 = new Person("Jack (great-granddaddy)");
	    Person a2 = new Person("Jean (great-granny)");
	    Person a3 = new Person("Albert (great-granddaddy)");
	    Person a4 = new Person("Rae (great-granny)");
	    Person a5 = new Person("Paul (great-granddaddy)");
	    Person a6 = new Person("Josie (great-granny)");

	    // the grandparent generation
	    Person b1 = new Person("Peter (grandpa)");
	    Person b2 = new Person("Zoe (grandma)");
	    Person b3 = new Person("Simon (grandpa)");
	    Person b4 = new Person("James (grandpa)");
	    Person b5 = new Person("Bertha (grandma)");
	    Person b6 = new Person("Veronica (grandma)");
	    Person b7 = new Person("Anne (grandma)");
	    Person b8 = new Person("Renee (grandma)");
	    Person b9 = new Person("Joseph (grandpa)");

	    // the parent generation
	    Person c1 = new Person("Isabelle (mom)");
	    Person c2 = new Person("Frank (dad)");
	    Person c3 = new Person("Louis (dad)");
	    Person c4 = new Person("Laurence (dad)");
	    Person c5 = new Person("Valerie (mom)");
	    Person c6 = new Person("Marie (mom)");
	    Person c7 = new Person("Helen (mom)");
	    Person c8 = new Person("Mark (dad)");
	    Person c9 = new Person("Oliver (dad)");

	    // the youngest generation
	    Person d1 = new Person("Clement (boy)");
	    Person d2 = new Person("Colin (boy)");

	    Person.linkFamily(a1, a2, new Person[] { b1, b2, b3, b4 });
	    Person.linkFamily(a3, a4, new Person[] { b5, b6, b7 });
	    Person.linkFamily(a5, a6, new Person[] { b8, b9 });
	    Person.linkFamily(b3, b6, new Person[] { c1, c2, c3 });
	    Person.linkFamily(b4, b5, new Person[] { c4, c5, c6 });
	    Person.linkFamily(b8, b7, new Person[] { c7, c8, c9 });
	    Person.linkFamily(c4, c7, new Person[] { d1, d2 });

	    return a1;
	  }

	  /**
	   * Create the GUI and show it. For thread safety, this method should be
	   * invoked from the event-dispatching thread.
	   */
	  private static void createAndShowGUI() {
	    // Create and set up the window.
	    JFrame frame = new JFrame("GenealogyExample");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    // Create and set up the content pane.
	    GenealogyExample newContentPane = new GenealogyExample();
	    newContentPane.setOpaque(true); // content panes must be opaque
	    frame.setContentPane(newContentPane);

	    // Display the window.
	    frame.pack();
	    frame.setVisible(true);
	  }

	  public static void main(String[] args) {
	    // Schedule a job for the event-dispatching thread:
	    // creating and showing this application's GUI.
	    javax.swing.SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        createAndShowGUI();
	      }
	    });
	  }
	}

	/*
	 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc. All rights reserved.
	 * 
	 * Redistribution and use in source and binary forms, with or without
	 * modification, are permitted provided that the following conditions are met:
	 *  - Redistributions of source code must retain the above copyright notice,
	 * this collection.list of conditions and the following disclaimer.
	 *  - Redistributions in binary form must reproduce the above copyright notice,
	 * this collection.list of conditions and the following disclaimer in the documentation
	 * and/or other materials provided with the distribution.
	 *  - Neither the name of Sun Microsystems nor the names of its contributors may
	 * be used to endorse or promote products derived from this software without
	 * specific prior written permission.
	 * 
	 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
	 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
	 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
	 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
	 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
	 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
	 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
	 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
	 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
	 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
	 * POSSIBILITY OF SUCH DAMAGE.
	 */

	class Person {
	  Person father;
	  Person mother;
	  Vector<Person> children;
	  private String name;

	  public Person(String name) {
	    this.name = name;
	    mother = father = null;
	    children = new Vector<Person>();
	  }

	  /**
	   * Link together all members of a family.
	   * 
	   * @param pa
	   *            the father
	   * @param ma
	   *            the mother
	   * @param kids
	   *            the children
	   */
	  public static void linkFamily(Person pa, Person ma, Person[] kids) {
	    for (Person kid : kids) {
	      pa.children.addElement(kid);
	      ma.children.addElement(kid);
	      kid.father = pa;
	      kid.mother = ma;
	    }
	  }

	  // / getter methods ///////////////////////////////////

	  public String toString() {
	    return name;
	  }

	  public String getName() {
	    return name;
	  }

	  public Person getFather() {
	    return father;
	  }

	  public Person getMother() {
	    return mother;
	  }

	  public int getChildCount() {
	    return children.size();
	  }

	  public Person getChildAt(int i) {
	    return (Person) children.elementAt(i);
	  }

	  public int getIndexOfChild(Person kid) {
	    return children.indexOf(kid);
	  }
	}

	/*
	 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc. All rights reserved.
	 * 
	 * Redistribution and use in source and binary forms, with or without
	 * modification, are permitted provided that the following conditions are met:
	 *  - Redistributions of source code must retain the above copyright notice,
	 * this collection.list of conditions and the following disclaimer.
	 *  - Redistributions in binary form must reproduce the above copyright notice,
	 * this collection.list of conditions and the following disclaimer in the documentation
	 * and/or other materials provided with the distribution.
	 *  - Neither the name of Sun Microsystems nor the names of its contributors may
	 * be used to endorse or promote products derived from this software without
	 * specific prior written permission.
	 * 
	 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
	 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
	 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
	 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
	 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
	 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
	 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
	 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
	 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
	 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
	 * POSSIBILITY OF SUCH DAMAGE.
	 */

	@SuppressWarnings("serial")
	class GenealogyTree extends JTree {
	  GenealogyModel model;

	  public GenealogyTree(Person graphNode) {
	    super(new GenealogyModel(graphNode));
	    getSelectionModel().setSelectionMode(
	        TreeSelectionModel.SINGLE_TREE_SELECTION);
	    DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
	    Icon personIcon = null;
	    renderer.setLeafIcon(personIcon);
	    renderer.setClosedIcon(personIcon);
	    renderer.setOpenIcon(personIcon);
	    setCellRenderer(renderer);
	  }

	  /**
	   * Get the selected item in the tree, and call showAncestor with this item on
	   * the model.
	   */
	  public void showAncestor(boolean b) {
	    Object newRoot = null;
	    TreePath path = getSelectionModel().getSelectionPath();
	    if (path != null) {
	      newRoot = path.getLastPathComponent();
	    }
	    ((GenealogyModel) getModel()).showAncestor(b, newRoot);
	  }
	}

	/*
	 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc. All rights reserved.
	 * 
	 * Redistribution and use in source and binary forms, with or without
	 * modification, are permitted provided that the following conditions are met:
	 *  - Redistributions of source code must retain the above copyright notice,
	 * this collection.list of conditions and the following disclaimer.
	 *  - Redistributions in binary form must reproduce the above copyright notice,
	 * this collection.list of conditions and the following disclaimer in the documentation
	 * and/or other materials provided with the distribution.
	 *  - Neither the name of Sun Microsystems nor the names of its contributors may
	 * be used to endorse or promote products derived from this software without
	 * specific prior written permission.
	 * 
	 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
	 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
	 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
	 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
	 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
	 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
	 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
	 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
	 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
	 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
	 * POSSIBILITY OF SUCH DAMAGE.
	 */
	class GenealogyModel implements TreeModel {
	  private boolean showAncestors;
	  private Vector<TreeModelListener> treeModelListeners = new Vector<TreeModelListener>();
	  private Person rootPerson;

	  public GenealogyModel(Person root) {
	    showAncestors = false;
	    rootPerson = root;
	  }

	  /**
	   * Used to toggle between show ancestors/show descendant and to change the
	   * root of the tree.
	   */
	  public void showAncestor(boolean b, Object newRoot) {
	    showAncestors = b;
	    Person oldRoot = rootPerson;
	    if (newRoot != null) {
	      rootPerson = (Person) newRoot;
	    }
	    fireTreeStructureChanged(oldRoot);
	  }

	  // ////////////// Fire events //////////////////////////////////////////////

	  /**
	   * The only event raised by this model is TreeStructureChanged with the root
	   * as path, i.e. the whole tree has changed.
	   */
	  @SuppressWarnings("unused")
	protected void fireTreeStructureChanged(Person oldRoot) {
	    int len = treeModelListeners.size();
	    TreeModelEvent e = new TreeModelEvent(this, new Object[] { oldRoot });
	    for (TreeModelListener tml : treeModelListeners) {
	      tml.treeStructureChanged(e);
	    }
	  }

	  // ////////////// TreeModel interface implementation ///////////////////////

	  /**
	   * Adds a listener for the TreeModelEvent posted after the tree changes.
	   */
	  public void addTreeModelListener(TreeModelListener l) {
	    treeModelListeners.addElement(l);
	  }

	  /**
	   * Returns the child of parent at index index in the parent's child arrays.
	   */
	  public Object getChild(Object parent, int index) {
	    Person p = (Person) parent;
	    if (showAncestors) {
	      if ((index > 0) && (p.getFather() != null)) {
	        return p.getMother();
	      }
	      return p.getFather();
	    }
	    return p.getChildAt(index);
	  }

	  /**
	   * Returns the number of children of parent.
	   */
	  public int getChildCount(Object parent) {
	    Person p = (Person) parent;
	    if (showAncestors) {
	      int count = 0;
	      if (p.getFather() != null) {
	        count++;
	      }
	      if (p.getMother() != null) {
	        count++;
	      }
	      return count;
	    }
	    return p.getChildCount();
	  }

	  /**
	   * Returns the index of child in parent.
	   */
	  public int getIndexOfChild(Object parent, Object child) {
	    Person p = (Person) parent;
	    if (showAncestors) {
	      int count = 0;
	      Person father = p.getFather();
	      if (father != null) {
	        count++;
	        if (father == child) {
	          return 0;
	        }
	      }
	      if (p.getMother() != child) {
	        return count;
	      }
	      return -1;
	    }
	    return p.getIndexOfChild((Person) child);
	  }

	  /**
	   * Returns the root of the tree.
	   */
	  public Object getRoot() {
	    return rootPerson;
	  }

	  /**
	   * Returns true if node is a leaf.
	   */
	  public boolean isLeaf(Object node) {
	    Person p = (Person) node;
	    if (showAncestors) {
	      return ((p.getFather() == null) && (p.getMother() == null));
	    }
	    return p.getChildCount() == 0;
	  }

	  /**
	   * Removes a listener previously added with addTreeModelListener().
	   */
	  public void removeTreeModelListener(TreeModelListener l) {
	    treeModelListeners.removeElement(l);
	  }

	  /**
	   * Messaged when the user has altered the value for the item identified by
	   * path to newValue. Not used by this model.
	   */
	  public void valueForPathChanged(TreePath path, Object newValue) {
	    System.out
	        .println("*** valueForPathChanged : " + path + " --> " + newValue);
	  }

}
