package br.com.vini.gerenciador.entities;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();
	
	static {
		empresas.add(new Empresa(1, "MBC", LocalDate.of(2005, Month.FEBRUARY, 15)));
		empresas.add(new Empresa(2, "ViniCarv", LocalDate.of(2018, Month.JANUARY, 2)));
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(empresas.size() + 1);
		empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.empresas;
	}
}
