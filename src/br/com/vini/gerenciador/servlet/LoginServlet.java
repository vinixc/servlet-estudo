package br.com.vini.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vini.gerenciador.controller.AcaoImpl;
import br.com.vini.gerenciador.controller.impl.LoginController;

@WebServlet("/entradaLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AcaoImpl controller;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(controller == null) {
			controller = new LoginController(request.getParameter("acao"),request,response);
		}else {
			controller.setMethod(request.getParameter("acao"));
			controller.setRequest(request);
			controller.setResponse(response);
		}
		controller.acao();
	}

}
