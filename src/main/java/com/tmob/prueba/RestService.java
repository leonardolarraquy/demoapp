package com.tmob.prueba;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
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
		String id = request.getParameter("id");
		
		System.out.println("processing request: " + request.getMethod() + " id=" + id + " from: " + request.getRemoteAddr());
		
		
		response.setContentType("application/json");
		
		PrintWriter writer = response.getWriter();
		writer.append("{ \n");
		
		StringBuffer ips    = new StringBuffer();
		StringBuffer hnames = new StringBuffer();
		StringBuffer cnames = new StringBuffer();
		
		Enumeration e = NetworkInterface.getNetworkInterfaces();
		while(e.hasMoreElements()){
		    NetworkInterface n = (NetworkInterface) e.nextElement();
		    Enumeration ee = n.getInetAddresses();
		    while (ee.hasMoreElements()){
		        InetAddress i = (InetAddress) ee.nextElement();
		        
		        ips.append(i.getHostAddress());
		        cnames.append(i.getCanonicalHostName());
		        hnames.append(i.getHostName());
		        
		        ips.append(",");
		        cnames.append(",");
		        hnames.append(",");

		    }
		}
		
		writer.append("\"local_ip\" : \"" + ips.toString() + "\" ,\n");
		writer.append("\"local_name\" : \"" + cnames.toString() + "\" ,\n");
		writer.append("\"host_name\" : \"" + hnames.toString() + "\" ,\n");
				

		writer.append("\"remote_ip\" : \"" + request.getRemoteAddr() + "\" ,\n");
		writer.append("\"remote_host\" : \"" + request.getRemoteHost() + "\" ,\n");

		int i = 0;
		Set set = System.getProperties().entrySet();
		Iterator<Map.Entry> it = set.iterator();
		while(it.hasNext() && i < 6) {
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
