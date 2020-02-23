package br.com.vini.gerenciador.entities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Empresa {
	
	private Integer id;
	private String nome;
	private LocalDate dataAbertura;
	
	public Empresa(Integer id, String nome, LocalDate dataAbertura) {
		this.id = id;
		this.nome = nome;
		this.dataAbertura = dataAbertura;
	}
	
	public Empresa() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataAbertura() {
		return Date.from(dataAbertura.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
}
