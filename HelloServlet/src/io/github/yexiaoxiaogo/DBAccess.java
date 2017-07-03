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
		String title = "servlet����mysql����";
		String docType = "<!DOCTYPE html>\n";
		out.println(docType +
		"<html>\n" +
		"<head><title>" + title + "</title></head>\n" +
		"<body bgcolor=\"#f0f0f0\">\n" +
		"<h1 align=\"center\">" + title + "</h1>\n");
		try {
			Class.forName(JDBC_DRIVER);//ע������
			//������
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			//ִ��SQL��ѯ
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
			
//			//��ȡ�������query
//			String query = request.getQueryString();
//		//	response.getWriter().print("<tr><td>" + query + "</td>\n");
//			Enumeration en = request.getParameterNames();
//			while(en.hasMoreElements()){
//				para = en.nextElement();
//				�����������д�������ѯid=1�����£����ĸ����ҵ�
			//��õ�id=1������һ���������õ�country����һ���������idȥ��country�����ҷ���country
//			}
			
			} catch (SQLException se) {
			// ����JDBC����
			se.printStackTrace();
		}catch (Exception e) {
			// ����Class.forName����
			e.printStackTrace();
		}finally {
			//���ڹر���Դ�Ŀ�
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
