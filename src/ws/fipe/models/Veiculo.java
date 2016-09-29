package ws.fipe.models;

import java.io.Serializable;

import ws.fipe.models.enumtypes.TipoVeiculo;

public class Veiculo implements Serializable {
	private static final long serialVersionUID = -1451365434049487125L;
	
	private String codigoFipe;
	private double valor;
	private Referencia referencia;
	private Marca marca;
	private Modelo modelo;
	private AnoModelo anoModelo;
	private String autenticacao;
	private TipoVeiculo tipoVeiculo;
	private String dataConsulta;
	
	public Veiculo() {
		this.codigoFipe = "";
		this.valor = 0;
		this.referencia = new Referencia();
		this.marca = new Marca();
		this.modelo = new Modelo();
		this.anoModelo = new AnoModelo();
		this.autenticacao = "";
		this.tipoVeiculo = TipoVeiculo.NENHUM;
		this.dataConsulta = "";
	}
	
	@Override
	public String toString() {
		return "{Codigo Fipe=" + this.codigoFipe +
			   ";Valor=" + this.valor +
			   ";Referencia=" + this.referencia +
			   ";Marca=" + this.marca +
			   ";Modelo=" + this.modelo +
			   ";Ano Modelo=" + this.anoModelo +
			   ";Autênticação=" + this.autenticacao +
			   ";Tipo Veículo=" + this.tipoVeiculo +
			   ";Data Consulta=" + this.dataConsulta + "}";
	}

	public String getCodigoFipe() {
		return codigoFipe;
	}

	public void setCodigoFipe(String codigoFipe) {
		this.codigoFipe = codigoFipe;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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

	public AnoModelo getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(AnoModelo anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getAutenticacao() {
		return autenticacao;
	}

	public void setAutenticacao(String autenticacao) {
		this.autenticacao = autenticacao;
	}

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	
}
