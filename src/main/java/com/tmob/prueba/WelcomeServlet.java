package com.tmob.prueba;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WelcomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		String path = request.getContextPath() + "/images/";

		writer.append("<html>");
		writer.append("<img src=\"" + path + "chewbacca.png\" width=\"150\" height=\"150\">");
		writer.append("<img src=\"" + path + "yoda.png\" width=\"150\" height=\"150\">");
		writer.append("<img src=\"" + path + "obiwan.png\" width=\"150\" height=\"150\">");
		writer.append("<img src=\"" + path + "darthvader.png\" width=\"150\" height=\"150\">");
		writer.append("<img src=\"" + path + "jabba.png\" width=\"150\" height=\"150\">");

		Set set = System.getenv().entrySet();
		Iterator<Map.Entry> it = set.iterator();
		while(it.hasNext()) {
			Map.Entry next = it.next();
			
			writer.append("<p>property: " + next.getKey() + " value: " + next.getValue() + "</p>\n");

		}

		set = System.getProperties().entrySet();
		it = set.iterator();
		while(it.hasNext()) {
			Map.Entry next = it.next();
			
			writer.append("<p>property: " + next.getKey() + " value: " + next.getValue() + "</p>\n");

		}

		writer.append("</html>");
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
