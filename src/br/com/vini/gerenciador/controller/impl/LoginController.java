package br.com.vini.gerenciador.controller.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vini.gerenciador.controller.AcaoImpl;

public class LoginController extends AcaoImpl{
	
	public LoginController(String method, HttpServletRequest request, HttpServletResponse response) {
		super(method,request,response);
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var login = request.getParameter("login");
		var senha = request.getParameter("senha");
		
		System.out.println("Logando : " + login);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/view/bem-vindo.html");
		dispacher.forward(request, response);
	}
}
