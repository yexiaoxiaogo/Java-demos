package io.github.yexiaoxiaogo.SQLSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
	
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/yex";
	static final String USER = "root";
	static final String PASS = "";
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql;
			sql = "select id,name from websites";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				System.out.println("id:"+ id);
				System.out.println("name:"+ name );
				System.out.println("\n");
				
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
