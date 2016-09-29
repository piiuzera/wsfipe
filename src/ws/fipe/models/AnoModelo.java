package ws.fipe.models;

import java.io.Serializable;

import ws.fipe.models.enumtypes.TipoCombustivel;

public class AnoModelo implements Serializable {
	private static final long serialVersionUID = 3139807563606898396L;
	
	private String anoModelo;
	private TipoCombustivel tipoCombustivel;
	private Referencia referencia;
	private Marca marca;
	private Modelo modelo;
	
	public AnoModelo() {
		this.anoModelo = "";
		this.tipoCombustivel = TipoCombustivel.NENHUM;
		this.referencia = new Referencia();
		this.marca = new Marca();
		this.modelo = new Modelo();
	}
	
	@Override
	public String toString() {
		return "{Ano=" + this.anoModelo + ";" +
				"Tipo Combustível=" + this.tipoCombustivel + ";" +
				"Referência=" + this.referencia + ";" +
				"Marca=" + this.marca + ";" +
				"Modelo=" + this.modelo + ";" +
				"}";
	}

	public String getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
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

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
}
