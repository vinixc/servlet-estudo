package br.com.vini.gerenciador.servlet;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/entrada", "/entradaLogin"})
public class MonitoramentoFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Instant agora = Instant.now();
		
		//executa acao
		chain.doFilter(request, response);
		
		Instant fim = Instant.now();
		Duration duracao = Duration.between(agora, fim);
		long duracaoSegundos = duracao.getSeconds();
		if(duracaoSegundos > 1)
			System.out.println("Tempo de execução: " + duracaoSegundos + " segundos.");
		
	}

}
