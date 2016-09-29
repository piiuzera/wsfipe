package ws.fipe.models;

import java.io.Serializable;

public class Modelo implements Serializable {
	private static final long serialVersionUID = 816960009760335757L;
	
	private String codigo;
	private String nome;
	private Referencia referencia;
	private Marca marca;
	
	public Modelo() {
		this.codigo = "";
		this.nome = "";
		this.referencia = new Referencia();
		this.marca = new Marca();
	}
	
	@Override
	public String toString() {
		return "{Codigo=" + this.codigo + ";" +
				"Nome=" + this.nome + ";" +
				"Referência=" + this.referencia + ";" +
				"Marca=" + this.marca + ";" +
				"}";
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

	public Referencia getReferencia() {
		return referencia;
	}

	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
}
