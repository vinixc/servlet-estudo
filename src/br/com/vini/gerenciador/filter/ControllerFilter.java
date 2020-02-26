package br.com.vini.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vini.gerenciador.controller.AcaoImpl;

//@WebFilter(urlPatterns = {"/entrada", "/entradaLogin"})
public class ControllerFilter implements Filter{
	
	private AcaoImpl controller;

	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
		
		System.out.println("PASSANDO PELO CONTROLLER FILTER");
			
		String nameClasse = request.getParameter("class");
		Class classe = Class.forName("br.com.vini.gerenciador.controller.impl."+nameClasse);

			controller = (AcaoImpl) classe.newInstance();
			controller.setMethod(request.getParameter("acao"));
			controller.setRequest((HttpServletRequest)request);
			controller.setResponse((HttpServletResponse)response);

		controller.acao();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
