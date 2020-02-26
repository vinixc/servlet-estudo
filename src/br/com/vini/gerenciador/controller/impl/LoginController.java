package br.com.vini.gerenciador.controller.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vini.gerenciador.controller.AcaoImpl;
import br.com.vini.gerenciador.entities.Banco;
import br.com.vini.gerenciador.entities.Usuario;

public class LoginController extends AcaoImpl{
	
	public LoginController(String method, HttpServletRequest request, HttpServletResponse response) {
		super(method,request,response);
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispacher = null;
		var login = request.getParameter("login");
		var senha = request.getParameter("senha");
		
		System.out.println("Logando : " + login);
		
		Usuario usuario = Banco.existeUsuario(login, senha);
		
		if(usuario != null) {
			System.out.println("Usuario existe");
			dispacher = request.getRequestDispatcher("/WEB-INF/view/bem-vindo.html");
		}else {
			dispacher = request.getRequestDispatcher("/WEB-INF/view/formLogin.jsp");
		}
		
		
		dispacher.forward(request, response);
	}
	
	public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Indo para Home");
		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/view/bem-vindo.html");
		dispacher.forward(request, response);
	}
}
