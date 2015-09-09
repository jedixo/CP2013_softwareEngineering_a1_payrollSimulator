
package controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Database {
	
	Connection connection = null;
	
	public Database(String host, String user, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://" + host, user, password);
			System.out.println("connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ResultSet getEmployees() {
		// TODO Auto-generated method stub
		ArrayList<String> employees = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
			return rs;
//			while (rs.next()) {
//				String id = rs.getString("id");
//				String firstName = rs.getString("first_name");
//				String lastName = rs.getString("last_name");
//				System.out.println("ID: " + id + ", First Name: " + firstName
//						+ ", Last Name: " + lastName);
//				
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	
	}

}
