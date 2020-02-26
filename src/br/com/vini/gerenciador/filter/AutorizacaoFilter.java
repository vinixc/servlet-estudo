package br.com.vini.gerenciador.filter;

import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.vini.gerenciador.listener.UsuarioDuplicadoListener;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter({ "/entrada", "/entradaLogin" })
public class AutorizacaoFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String acao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		Object usuarioLogado = (Object) sessao.getAttribute("usuarioLogado");
		Set<Object> usuarios = UsuarioDuplicadoListener.getUsuariosLogados();
		
		if(!usuarios.contains(usuarioLogado)
				&& !acao.equals("formLogin") && !acao.equals("login")) {
			response.sendRedirect("entradaLogin?acao=formLogin&class=LoginController");
			return;
		}
		
		if (usuarioLogado == null
				&& !acao.equals("formLogin") && !acao.equals("login")) {
			System.out.println("Não autenticado");
			response.sendRedirect("entradaLogin?acao=formLogin&class=LoginController");
			return;
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
}
