package test;

import java.sql.ResultSet;
import java.sql.SQLException;

import controll.Database;

public class TestDatabase {
	
	private static final String HOST = "sql6.freemysqlhosting.net/sql689509";
	private static final String USERNAME = "sql689509";
	private static final String PASSWORD = "lA7*wL7!";

	public static void main(String[] args) {
		
		Database database = new Database(HOST, USERNAME, PASSWORD);
		System.out.println("Is Connected: " + database.isConnected);
		System.out.println("Has Errors: " + database.error);
		System.out.println("get Table: " + database.getTable("employees"));
		System.out.println("Print table:");
		ResultSet table = database.getTable("employees");
		try {
			while (table.next()) {
				System.out.println("ID: " + table.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
