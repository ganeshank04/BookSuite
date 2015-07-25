package com.book.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.book.reader.PropertyReader;

/*  Creation of Connections Class to Establish the
 *  Connection between Database and DBProperties File.
 *  
 */
public class DBConnectionFactory {
	public static Connection con;
	/*
	 * Creation of Method getConnection for Reading the Properties File.
	 */
	public static Connection getConnection() throws Exception {
		Properties prop;

		prop = PropertyReader
				.getPropertyInstance("src/com/book/properties/DBProperty.properties");
		Class.forName(prop.getProperty("db.driverclass"));
		Connection con = DriverManager.getConnection(prop.getProperty("db.url"),
				prop.getProperty("db.username"), prop.getProperty("db.password"));

		return con;
	}
	
	public static void closeConnection(){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
