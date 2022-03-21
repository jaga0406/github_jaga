package com.testscenarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DatabaseTesting2 {
	
	private Connection connection;
	private static Statement statement;
	private static ResultSet rs;

	@BeforeClass
	public void connectingToDatabase() {
		String databaseURL = "jdbc:mysql://localhost:3306/jaga";
		String username = "root";
		String password = "Sql@8.0.28jaga";
		connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to Database...");
			connection = DriverManager.getConnection(databaseURL, username, password);
			if (connection != null) {
				System.out.println("Connected to the Database...");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void getDataFromDataBase() {
		try {
			String query = "select * from location;";
			statement = connection.createStatement();
			rs = statement.executeQuery(query);

			while (rs.next()) {
				String Location_ID = rs.getString(1);
				String Regional_Group = rs.getString(2);

				System.out.println(Location_ID + "\t" + Regional_Group + "\t");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@AfterClass
	public void closingDatabaseConnection() {
		if (connection != null) {
			try {
				System.out.println("Closing Database Connection...");
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}

