package ws.fipe.models;

import java.io.Serializable;
import java.util.ArrayList;

import ws.fipe.models.enumtypes.TipoVeiculo;

public class Referencia implements Serializable {
	private static final long serialVersionUID = 6516612760655829071L;
	
	private String codigo;
	private String nome;
	
	public Referencia() {
		this.codigo = "";
		this.nome = "";
	}
	
	@Override
	public String toString() {
		return "{Codigo=" + this.codigo + ";" +
			   "Nome=" + this.nome + "}";
	}
	
	public ArrayList<Marca> getMarcas(TipoVeiculo tipoVeiculo) {
		ArrayList<Marca> listMarcas = new ArrayList<Marca>();
		
		return listMarcas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
