package br.com.vini.gerenciador.controller;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AcaoImpl implements Acao{
	
	private String metodo;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public AcaoImpl(String method, HttpServletRequest request, HttpServletResponse response) {
		this.metodo = method;
		this.request = request;
		this.response = response;
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
