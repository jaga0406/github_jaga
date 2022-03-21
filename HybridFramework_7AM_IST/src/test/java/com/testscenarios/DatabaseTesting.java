package com.testscenarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DatabaseTesting {
  @Test
  public void f() throws Exception {
	  String dbUrl = "jdbc:mysql://localhost:3306/jaga";					

		//Database Username		
		String username = "root";	
      
		//Database Password		
		String password = "Sql@8.0.28jaga";				

		//Query to Execute		
		String query = "select * from LOCATION;";	
       
	    //Load mysql jdbc driver		
 	    Class.forName("com.mysql.jdbc.Driver");			
 
 		//Create Connection to DB		
  	Connection con = DriverManager.getConnection(dbUrl,username,password);

		//Create Statement Object		
	   Statement stmt = con.createStatement();					

			// Execute the SQL Query. Store results in ResultSet		
		ResultSet rs = stmt.executeQuery(query);							

		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        	  String Location_ID = rs.getString(1);								        
                  String Regional_Group = rs.getString(2);
                  System.out.println(Location_ID+"  "+Regional_Group);		
          }		
		 // closing DB Connection		
		con.close();		
	  
  }
}
