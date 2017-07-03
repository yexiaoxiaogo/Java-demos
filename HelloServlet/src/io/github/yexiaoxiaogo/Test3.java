package io.github.yexiaoxiaogo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test3
 */
@WebServlet("/Test3")
public class Test3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;Charset=UTF-8");
	//	response.getWriter().writer("返回请求方式，请求URL，请求参数");
		String title = "返回请求方式，请求URL，请求参数";
		String docType =
			"<!DOCTYPE html> \n";
			response.getWriter().println(docType +
			"<html>\n" +
			"<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n"+
			"<body bgcolor=\"#f0f0f0\">\n" +
			"<h1 align=\"center\">" + title + "</h1>\n" +
			"<table width=\"100%\" border=\"1\" align=\"center\">\n" +
			"<tr bgcolor=\"#949494\">\n"+//"<th>请求方式</th><th>请求url</th><th>请求参数</th>\n"+
			"</tr>\n");
		String method = request.getMethod();
		response.getWriter().print("<tr><td>" + method + "</td>\n");

		
		String query = request.getQueryString();
		response.getWriter().print("<tr><td>" + query + "</td>\n");



	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
