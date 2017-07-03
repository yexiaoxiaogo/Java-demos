package io.github.yexiaoxiaogo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class DBAccess
 */
@WebServlet("/DBAccess")
public class DBAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/yexx";
	static final String USER = "root";
	static final String PASS = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBAccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "servlet链接mysql测试";
		String docType = "<!DOCTYPE html>\n";
		out.println(docType +
		"<html>\n" +
		"<head><title>" + title + "</title></head>\n" +
		"<body bgcolor=\"#f0f0f0\">\n" +
		"<h1 align=\"center\">" + title + "</h1>\n");
		try {
			Class.forName(JDBC_DRIVER);//注册驱动
			//打开连接
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			//执行SQL查询
			stmt = (Statement) conn.createStatement();
			String sql;
			sql = "SELECT * FROM websites";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");
				int alexa = rs.getInt("alexa");
				String country = rs.getString("country");
				
				out.println("id:"+id+" "+"name:"+name+" "+"url:"+url+" "+"alexa:"+alexa+" "+"country:"+country);
				out.println("<br/>");
				
			}
			out.println("</body></html>");
			rs.close();
			stmt.close();
			conn.close();
			
//			//获取请求参数query
//			String query = request.getQueryString();
//		//	response.getWriter().print("<tr><td>" + query + "</td>\n");
//			Enumeration en = request.getParameterNames();
//			while(en.hasMoreElements()){
//				para = en.nextElement();
//				这个回来接着写。例如查询id=1的文章，是哪个国家的
			//获得的id=1，放在一个变量里，获得的country放在一个变量里、用id去查country，并且返回country
//			}
			
			} catch (SQLException se) {
			// 处理JDBC错误
			se.printStackTrace();
		}catch (Exception e) {
			// 处理Class.forName错误
			e.printStackTrace();
		}finally {
			//用于关闭资源的块
			try {
				if(stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				// TODO: handle exception
			}
			try {
				if (conn!=null)
					conn.close();
			} catch (SQLException se) {
				// TODO: handle exception
				se.printStackTrace();
			
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
