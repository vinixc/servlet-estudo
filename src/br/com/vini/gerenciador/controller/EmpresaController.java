package br.com.vini.gerenciador.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vini.gerenciador.entities.Banco;
import br.com.vini.gerenciador.entities.Empresa;

public class EmpresaController implements Acao{
	
	private String metodo;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public EmpresaController(String method, HttpServletRequest request, HttpServletResponse response) {
		this.metodo = method;
		this.request = request;
		this.response = response;
	}
	
	public void listaEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("listando empresa");
		Banco banco = new Banco();
		List<Empresa> listaEmpresas = banco.getEmpresas();
		request.setAttribute("empresas", listaEmpresas);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/listaEmpresas.jsp");
		rd.forward(request, response);
	}
	
	public void deleteEmpresa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("removendo empresa");
		var idEmpresa = request.getParameter("id");
		Banco.deleteEmpresa(Integer.parseInt(idEmpresa));
		response.sendRedirect("entrada?acao=listaEmpresa");
	}
	
	public void atualizaEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("atualizando empresa");
		Empresa empresa = Banco.getEmpresa(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("empresa", empresa);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/view/formNovaEmpresa.jsp");
		dispacher.forward(request, response);
	}
	
	public void criarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("criando empresa");
		var nomeEmpresa = request.getParameter("nome");		//java 10, utilizando o var hu3
		var paramDataAbertura = request.getParameter("data");
		var id = request.getParameter("id");
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			dataAbertura = sdf.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(LocalDate.ofInstant(dataAbertura.toInstant(), ZoneId.systemDefault()));
		if(id != null) {
			empresa.setId(Integer.parseInt(id));
		}
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		response.sendRedirect("entrada?acao=listaEmpresa");
	}
	
	public void formNovaEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("form nova empresa");
		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/view/formNovaEmpresa.jsp");
		dispacher.forward(request, response);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void acao(){
		try {
		Class classe = Class.forName(this.getClass().getName());
		Method method = classe.getMethod(this.metodo, new Class[] { HttpServletRequest.class, HttpServletResponse.class});	
		method.invoke(this, this.request, this.response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setMethod(String method) {
		this.metodo = method;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
}
