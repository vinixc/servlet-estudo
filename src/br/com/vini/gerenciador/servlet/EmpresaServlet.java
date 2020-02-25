package br.com.vini.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vini.gerenciador.controller.EmpresaController;

@WebServlet("/entrada")
public class EmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		if(paramAcao.equals("ListaEmpresas")) {
			EmpresaController acao = new EmpresaController();
			acao.listaEmpresa(request,response);
			
		}else if(paramAcao.equals("RemoveEmpresa")) {
			EmpresaController acao = new EmpresaController();
			acao.deleteEmpresa(request, response);
			
		}else if(paramAcao.equals("UpdateEmpresa")) {
			EmpresaController acao = new EmpresaController();
			acao.atualizaEmpresa(request, response);
		}else if(paramAcao.equals("criarEmpresa")) {
			EmpresaController acao = new EmpresaController();
			acao.criarEmpresa(request, response);
		}
	}

}
