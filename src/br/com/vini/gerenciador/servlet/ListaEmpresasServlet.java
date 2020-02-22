package br.com.vini.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vini.gerenciador.entities.Banco;
import br.com.vini.gerenciador.entities.Empresa;

/**
 * Servlet implementation class ListaEmpresasServlet
 */
@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> listaEmpresas = banco.getEmpresas();
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<ul>");
		
		for(Empresa empresa : listaEmpresas) {
			out.println("<li>" + empresa.getNome() + "</li>");
		}
		
		out.println("</ul>");
		out.println("</body></html>");
	}

}
