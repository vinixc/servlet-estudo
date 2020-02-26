package br.com.vini.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vini.gerenciador.controller.AcaoImpl;

/**
 * 
 * Class depreciada para evitar a criação de varios servlet. 
 * Utilizar ControllerFilter para mapeamento de novos endpoints.
 * Configurando os mesmos no arquivo web.xml.
 * 
 * 
 * @author vinicius de carvalho
 *
 */

//@WebServlet("/entradaLogin")
@Deprecated
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AcaoImpl controller;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(controller == null) {
//			controller = new LoginController(request.getParameter("acao"),request,response);
		}else {
			controller.setMethod(request.getParameter("acao"));
			controller.setRequest(request);
			controller.setResponse(response);
		}
		controller.acao();
	}

}
