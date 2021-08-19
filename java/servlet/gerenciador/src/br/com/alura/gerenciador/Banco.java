package br.com.alura.gerenciador;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	//static eh atributo da class, sem static, eh do objeto!
	private static List<Empresa> lista = new ArrayList<>();
	
	static { //codigo estatico, eh executado qnd a maquina virtual carrega a classe.
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		Banco.lista.add(empresa);
		Banco.lista.add(empresa2);
		Banco.lista.add(empresa2);
	}
	public void adiciona(Empresa empresa) {
		lista.add(empresa);
	}
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

}
