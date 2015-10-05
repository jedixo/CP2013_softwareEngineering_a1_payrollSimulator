
package controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Database {
	
	private Connection connection = null;
	public boolean isConnected = true;
	public boolean error = false;
	
	public Database(String host, String user, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://" + host, user, password);
			System.out.println("connected");
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to connect to databse:\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
			connection = null;
			isConnected = false;
		}
	}

	public ResultSet getTable(String table) {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
			return rs;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Failed to get table from database: " + table + "\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
			error = true;
			return null;
		}
	}
	


	public void addEmpData(Employee employee) {
		try {
			String sql = "INSERT INTO `employees`(`id`, `first_name`, `last_name`, `Address`, `pay_type`, `pay_delivery`, `Emp_Union`, `Salary`, `commision_rate`) VALUES " + 
		"(?,?,?,?,?,?,?,?,?);";
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, employee.getId());
			statement.setString(2, employee.getFirstName());
			statement.setString(3, employee.getLastName());
			statement.setString(4, employee.getAddress());
			statement.setInt(5, employee.getPayType());
			statement.setInt(6, employee.getPayDelivery());
			statement.setString(7, employee.getUnion());
			statement.setInt(8, employee.getSalary());
			statement.setFloat(9, employee.getCommisionRateFloat());
			statement.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Failed to get add employee to database: " + employee.firstName + " " + employee.lastName + "\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
			error = true;
		}
		
	}

	public void deleteEmp(int id) {
		try {
			String sql = "DELETE FROM employees WHERE id=?";
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,id);
			System.out.println(statement.toString());
			statement.executeUpdate();
			
		}catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Failed to delete employee from database: " + id + "\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
			error = true;
		}
	}


	public void updateEmp(Employee employee) {
		try {
			String sql = "UPDATE employees SET first_name = ?, last_name = ?, Address = ?, pay_type = ?, pay_delivery = ?, `Emp_Union` = ?, Salary = ?, commision_rate = ?" 
						+ " WHERE id = ?;";
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getAddress());
			statement.setInt(4, employee.getPayType());
			statement.setInt(5, employee.getPayDelivery());
			statement.setString(6, employee.getUnion());
			statement.setInt(7, employee.getSalary());
			statement.setInt(8, employee.getId());
			statement.setFloat(9, employee.getCommisionRateFloat());
			System.out.println(statement.toString());
			statement.executeUpdate();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Failed to update employee in database: " + employee.getFirstName() + " " + employee.getLastName() + "\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
			error = true;
		}
		
	}

	public void addTimeCard(Timecard tc) {
		// TODO Auto-generated method stub
		
	}
}
