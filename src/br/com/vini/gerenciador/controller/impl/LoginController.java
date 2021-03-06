package br.com.vini.gerenciador.controller.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.vini.gerenciador.controller.AcaoImpl;
import br.com.vini.gerenciador.entities.Banco;
import br.com.vini.gerenciador.entities.Usuario;

public class LoginController extends AcaoImpl{
	
	public LoginController() {
		
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispacher = null;
		var login = request.getParameter("login");
		var senha = request.getParameter("senha");
		
		System.out.println("Logando : " + login);
		
		Usuario usuario = Banco.existeUsuario(login, senha);
		
		if(usuario != null) {
			System.out.println("Usuario existe");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
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
	
	public void formLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Indo para Tela de Login");
		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/view/formLogin.jsp");
		dispacher.forward(request, response);
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sessao = request.getSession();
		sessao.invalidate();
		response.sendRedirect("entradaLogin?acao=formLogin&class=LoginController");
		
	}
}
