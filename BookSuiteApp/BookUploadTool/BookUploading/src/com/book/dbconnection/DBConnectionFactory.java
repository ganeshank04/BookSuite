package com.book.dbconnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*  Creation of Connections Class to Establish the
 *  Connection between Database and DBProperties File.
 *  
 */
public class DBConnectionFactory
{
	    static Properties prop;
	  
	    static
	    {
	        prop = new Properties();
	        try {
	            prop.load(new FileInputStream("src/DBProperty.properties"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
	    }
/*
 * Creation of Method getConnection for Reading the 
 *  Properties File.
 */
    public static Connection getConnection() throws Exception
    {
             
        //Class.forName(prop.getProperty("driverclass"));
        Connection con = DriverManager.getConnection(
                prop.getProperty("url"),
                prop.getProperty("user"),
                prop.getProperty("password"));
        
        System.out.println(con.getCatalog());
		System.out.println(con.getCatalog());
		

        return con;
            
    }
}
