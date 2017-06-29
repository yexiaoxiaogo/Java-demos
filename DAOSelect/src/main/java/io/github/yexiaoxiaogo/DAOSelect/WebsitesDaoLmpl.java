package io.github.yexiaoxiaogo.DAOSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class WebsitesDaoLmpl implements WebsitesDao {
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
	List<Websites> websites;
	

	public Websites getWebsites(int id) {
		
		Websites websites = new Websites();
	
		// TODO Auto-generated method stub
		try {
			
			Class.forName(JDBC_DRIVER);//注册驱动
			conn = DriverManager.getConnection(DB_URL, USER, PASS);//连接数据库
			stmt = conn.createStatement();//实例化
			String sql;
			sql = "select * from websites where id = " + id;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				
			//	int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");
				int alexa = rs.getInt("alexa");
				String country = rs.getString("country");
				
				System.out.println("id:"+ id+" "+"名称:"+name+" "+"网址:"+url+" "+"地区排名："+alexa+" "+"国家："+country);
				System.out.println("\n");
				
				websites.setId(id );
				websites.setName(name);
				websites.setUrl(url);
				websites.setAlexa(alexa);
				websites.setCountry(country);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return websites;
	}

	public List<Websites> getAllWebsties() {
		// TODO Auto-generated method stub
		return websites;
	}

	public void updateWebsites(Websites websites) {
		// TODO Auto-generated method stub
		
	}

	public void deleteWebsites(Websites websites) {
		// TODO Auto-generated method stub
		
	}
	

}
