package com.gpl.concurrent.ThreadLocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static ThreadLocal<Connection> connectionHolder=new ThreadLocal<Connection>(){
		@Override
		protected Connection initialValue(){
			Connection conn=null;
			try {
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "user", "password");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
	};
	
	public static Connection getConnection(){
		return connectionHolder.get();
	}
	 public static void setConnection(Connection conn) {  
	        connectionHolder.set(conn);  
	 }  
}
