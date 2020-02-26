package br.com.vini.gerenciador.entities;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	
	static {
		empresas.add(new Empresa(1, "MBC", LocalDate.of(2005, Month.FEBRUARY, 15)));
		empresas.add(new Empresa(2, "ViniCarv", LocalDate.of(2018, Month.JANUARY, 2)));
		usuarios.add(new Usuario("vini", "123"));
		usuarios.add(new Usuario("yas", "123"));
	}
	
	public void adiciona(Empresa empresa) {
		if(!empresas.isEmpty()) {
			if(empresa.getId() == null) {
				empresa.setId(empresas.get(empresas.size() -1).getId() + 1);
			}else {
				empresas.remove(empresa);
			}
		}else {
			empresa.setId(1);
		}
		empresas.add(empresa);	
	}
	
	public static void deleteEmpresa(Integer empresaId) {
		empresas.removeIf(e -> e.getId() == empresaId);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.empresas;
	}
	
	public static Empresa getEmpresa(Integer id) {
		Empresa empresa = empresas.stream().filter(e -> e.getId() == id).findFirst().get();
		return empresa;
	}
	
	public static Usuario existeUsuario(String login, String senha) {
		Usuario usuario = new Usuario(login, senha);
		if(usuarios.contains(usuario)) {
			return usuario;
		}
		return null;
	}
}
