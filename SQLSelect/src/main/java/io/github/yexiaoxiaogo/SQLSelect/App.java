package io.github.yexiaoxiaogo.SQLSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class App {
	//JDBC驱动名 
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    //连接数据库的url
    static final String DB_URL = "jdbc:mysql://localhost:3306/yex";
    //数据库的用户名和密码
	static final String USER = "root";
	//没有密码不要空格
	static final String PASS = "";
	//静态全局变量
	static Connection conn = null;
	static Statement stmt = null;
	
	public static void main(String[] args) {
		
		query();//查询数据库全部信息
		insert();//新增一条记录
		insert1();//新增一条记录，另一种方法
		updata();//更新某条记录
		delete();//删除某条信息
		
	}
	//查询数据库信息
	public static void query(){
		
		try {
			
			Class.forName(JDBC_DRIVER);//注册驱动
			conn = DriverManager.getConnection(DB_URL, USER, PASS);//连接数据库
			stmt = conn.createStatement();//实例化
			String sql;
			sql = "select * from websites";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");
				int alexa = rs.getInt("alexa");
				String country = rs.getString("country");
				
				System.out.println("id:"+ id+" "+"名称:"+name+" "+"网址:"+url+" "+"地区排名："+alexa+" "+"国家："+country);
				System.out.println("\n");
				
			}
			System.out.println("**********************************");
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//增加记录
	public static void insert(){
		
		try {
			
			Class.forName(JDBC_DRIVER);//注册驱动
			conn = DriverManager.getConnection(DB_URL, USER, PASS);//连接数据库
			String sql;	
			sql = "INSERT INTO websites (id,name,url,alexa,country)"+" VALUES (?,?,?,?,?)";
			PreparedStatement ptmt = conn.prepareStatement(sql);  //PreparedStatement接口重构增删改查、封装JDBC工具类 这个到时候查一下
			
			ptmt.setInt(1, 9);
			ptmt.setString(2, "3333");
			ptmt.setString(3, "xxx");
			ptmt.setInt(4, 888);
			ptmt.setString(5, "kkkkk");
			
			ptmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//增加记录
	public static void insert1(){
		
		try {
			
			Class.forName(JDBC_DRIVER);//注册驱动
			conn = DriverManager.getConnection(DB_URL, USER, PASS);//连接数据库
			stmt = (Statement )conn.createStatement();//实例化
			String sql;
			//增加一条信息id=1,name="网易云音乐",url=http://music.163.com/,alexa=666,country=CN
			sql = "INSERT INTO websites (id,name,url,alexa,country)"+" VALUES ('7','网易云音乐','http://music.163.com/','666','CN')";
			stmt.executeUpdate(sql);
			query();//插入信息后查询	
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//更新记录
	public static void updata(){
		
		try {
			
			Class.forName(JDBC_DRIVER);//注册驱动
			conn = DriverManager.getConnection(DB_URL, USER, PASS);//连接数据库
			stmt = conn.createStatement();//实例化
			String sql;
			//修改Google的排名
			sql = "UPDATE websites SET alexa = 1 WHERE name = 'google'";
			stmt.executeUpdate(sql);
			query();//查询更新后的表格
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	//删除记录
	public static void delete(){
		
		try {
			
			Class.forName(JDBC_DRIVER);//注册驱动
			conn = DriverManager.getConnection(DB_URL, USER, PASS);//连接数据库
			stmt = conn.createStatement();//实例化
			String sql;
			sql = "DELETE  FROM websites WHERE name = '网易云音乐'";
			stmt.executeUpdate(sql);
			query();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
