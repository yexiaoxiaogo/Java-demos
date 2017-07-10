package io.github.yexiaoxiaogo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test4
 */
@WebServlet("/Test4")
public class Test4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/hxml;charset=GB18030");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username="+username);
		
		response.getWriter().println("<html>");
		response.getWriter().println("<head>");
		response.getWriter().println("<title>d登录信息</title>");
		response.getWriter().println("</head>");
		response.getWriter().println("<body>");
		response.getWriter().println("欢迎"+username+"用户登录！");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
