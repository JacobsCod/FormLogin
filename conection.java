package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class conection{
	
	Connection conn;
	
    public conection() {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/usuarios","root","123456");
            Statement stmt=conn.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
		
    } 
    
    public Connection getConnection() {
		// TODO Auto-generated method stub
		return conn;
	}

	public PreparedStatement prepareStatement(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	
}