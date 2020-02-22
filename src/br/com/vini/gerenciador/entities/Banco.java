package br.com.vini.gerenciador.entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();
	
	public void adiciona(Empresa empresa) {
		empresa.setId(empresas.size() + 1);
		empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.empresas;
	}
}
