package components.JTbale;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class UserTableModel extends AbstractTableModel {

	private List<List<User>>	usersData;
	private String[]			columnsName	= { "ID", "NAME", "SURNAME", "LOGIN", "PASSWORD" };

	public UserTableModel() {
		User user = new User();
		this.usersData = user.getUsersData();
	}

	@Override
	public int getRowCount() {
		return usersData.size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public String getColumnName(int column) {
		return columnsName[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		List<User> rowUser = this.usersData.get(rowIndex);
		return rowUser.get(columnIndex);
	}

}
