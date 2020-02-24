package br.com.vini.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vini.gerenciador.entities.Banco;
import br.com.vini.gerenciador.entities.Empresa;

@WebServlet(urlPatterns = "/updateEmpresa")
public class UpdateEmpresaServlet extends HttpServlet{
	private static final long serialVersionUID = -2960593995254331765L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Empresa empresa = Banco.getEmpresa(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("empresa", empresa);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("/formNovaEmpresa.jsp");
		dispacher.forward(request, response);
	}

	
}
