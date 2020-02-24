package br.com.vini.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vini.gerenciador.entities.Banco;

@WebServlet(urlPatterns = "/deleteEmpresa")
public class DeleteEmpresaServlet extends HttpServlet{
	private static final long serialVersionUID = -2814143366150261579L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var idEmpresa = request.getParameter("id");
		Banco.deleteEmpresa(Integer.parseInt(idEmpresa));
		response.sendRedirect("listaEmpresas");
	}

	
}
