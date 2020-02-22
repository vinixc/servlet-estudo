package br.com.vini.gerenciador.entities;

public class Empresa {
	
	private Integer id;
	private String nome;
	
	public Empresa(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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
}
