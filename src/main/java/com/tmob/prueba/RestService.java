package com.tmob.prueba;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/RestService")
public class RestService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RestService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		PrintWriter writer = response.getWriter();
		writer.append("{ \n");
		writer.append("\"remote_ip\" : \"" + request.getRemoteAddr() + "\" ,\n");
		writer.append("\"remote_host\" : \"" + request.getRemoteHost() + "\" ,\n");
		writer.append("\"local_ip\" : \"" + InetAddress.getLocalHost().getHostAddress() + "\" ,\n");
		writer.append("\"local_name\" : \"" + InetAddress.getLocalHost().getHostName() + "\" ,\n");
				
		
		int i = 0;
		Set set = System.getProperties().entrySet();
		Iterator<Map.Entry> it = set.iterator();
		while(it.hasNext() && i < 8) {
			Map.Entry next = it.next();
			
			if(next.getKey().equals("line.separator") || next.getKey().equals("common.loader"))
				continue;
			
			writer.append("\"" + next.getKey() + "\" : \"" + next.getValue() + "\"");

			i++;

			if(i < 8)
				writer.append(", \n");
		}
		
		writer.append("} \n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
