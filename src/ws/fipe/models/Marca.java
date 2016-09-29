package ws.fipe.models;

import java.io.Serializable;

public class Marca implements Serializable {
	private static final long serialVersionUID = 9131909742301725403L;
	
	private String codigo;
	private String nome;
	private Referencia referencia;
	
	public Marca() {
		this.codigo = "";
		this.nome = "";
		this.referencia = new Referencia();
	}
	
	@Override
	public String toString() {
		return "{Codigo=" + this.codigo + ";" +
				"Nome=" + this.nome + ";" +
				"Referência=" + this.referencia + ";" +
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
}
