package br.com.vini.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/oi")
public class OiServlet extends HttpServlet {
	private static final long serialVersionUID = 4073043421550529552L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Oi Rapazz");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("O Servlet foi chamado com sucesso!");

	}
	
	
}
