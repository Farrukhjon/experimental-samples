package components.JTree;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
public class JTreeStructure extends JFrame {

	public JTreeStructure() throws Exception {

		super("Получение данных с базы...");
		ArrayList<Object> list = new ArrayList<Object>();
		list.add("Счета:");
		try {
			String sql = "Select * from accounts";

			Statement st = getConnectToMySQLDB().createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Object value[] = {
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5) };
				list.add(value);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		Object hierarchy[] = list.toArray();

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultMutableTreeNode root = processHierarchy(hierarchy);
		JTree tree = new JTree(root);
		getContentPane().add(new JScrollPane(tree), BorderLayout.CENTER);
		setSize(275, 300);
		setLocation(300, 100);
		setVisible(true);
	}

	public static void main(String args[]) throws Exception {
		new JTreeStructure();
	}

	private Connection getConnectToMySQLDB() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/finindex?characterEncoding = UTF-8&useUnicode = true",
							"userfin", "userfin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	private DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(hierarchy[0]);
		DefaultMutableTreeNode child;
		for (int i = 1; i < hierarchy.length; i++) {
			Object nodeSpecifier = hierarchy[i];
			if (nodeSpecifier instanceof Object[]) // Ie node with children
			{
				child = processHierarchy((Object[]) nodeSpecifier);
			} else {
				child = new DefaultMutableTreeNode(nodeSpecifier); // Ie Leaf
			}
			node.add(child);
		}
		return (node);
	}
}