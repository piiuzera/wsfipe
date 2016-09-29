package ws.fipe;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ashttp.AsHttpException;
import ashttp.request.HttpParameters;
import ashttp.request.HttpRequest;
import ashttp.response.HttpResponse;
import ws.fipe.models.AnoModelo;
import ws.fipe.models.Marca;
import ws.fipe.models.Modelo;
import ws.fipe.models.Referencia;
import ws.fipe.models.Veiculo;
import ws.fipe.models.enumtypes.TipoCombustivel;
import ws.fipe.models.enumtypes.TipoVeiculo;

public class WSFipe implements Serializable {
	private static final long serialVersionUID = -7653748318484148545L;

	private ArrayList<Referencia> referencias;
	
	public WSFipe() throws WSFipeException {
		try {			
			HttpRequest request = new HttpRequest();
			request.setUrl("http://veiculos.fipe.org.br/api/veiculos/ConsultarTabelaDeReferencia");
			request.setMethod("POST");
			
			HttpResponse response = request.getResponse();
			
			JSONParser json = new JSONParser();
			JSONArray listJson = (JSONArray)json.parse(response.getResponseStream().toString());
			
			this.referencias = new ArrayList<Referencia>();
			for(int i = 0; i < listJson.size(); i++) {
				JSONObject objJson = (JSONObject)listJson.get(i);
				Referencia referencia = new Referencia();
				referencia.setCodigo(objJson.get("Codigo").toString().trim());
				referencia.setNome(objJson.get("Mes").toString().trim());
				
				this.referencias.add(referencia);
			}
			
		} catch(AsHttpException ex) {
			throw new WSFipeException("Problemas ao acessar servidor, Verifique sua conexão com a internet.",
					"WSFIPE8x10", ex.getMessage());
		} catch (ParseException ex) { 
			throw new WSFipeException("Problemas ao retornar dados do servidor.",
					"WSFIPE8x11", ex.getMessage());
		}
	}
	
	public ArrayList<Marca> getMarcas(Referencia referencia, TipoVeiculo tipoVeiculo) throws WSFipeException {
		ArrayList<Marca> listMarca = new ArrayList<Marca>();
		try {			
			HttpRequest request = new HttpRequest();
			request.setUrl("http://veiculos.fipe.org.br/api/veiculos/ConsultarMarcas");
			request.setMethod("POST");
			
			request.getParameters().add(new HttpParameters("codigoTabelaReferencia", referencia.getCodigo()));
			request.getParameters().add(new HttpParameters("codigoTipoVeiculo", tipoVeiculo.getValue()));
			
			HttpResponse response = request.getResponse();
			
			JSONParser json = new JSONParser();
			JSONArray listJson = (JSONArray)json.parse(response.getResponseStream().toString());
			
			for(int i = 0; i < listJson.size(); i++) {
				JSONObject objJson = (JSONObject)listJson.get(i);
				Marca marca = new Marca();
				marca.setCodigo(objJson.get("Value").toString().trim());
				marca.setNome(objJson.get("Label").toString().trim());
				marca.setReferencia(referencia);
				
				listMarca.add(marca);
			}
			
			return listMarca;
			
		} catch(AsHttpException ex) {
			throw new WSFipeException("Problemas ao acessar servidor, Verifique sua conexão com a internet.",
					"WSFIPE8x12", ex.getMessage());
		} catch (ParseException ex) { 
			throw new WSFipeException("Problemas ao retornar dados do servidor.",
					"WSFIPE8x13", ex.getMessage());
		}
	}
	
	public ArrayList<Modelo> getModelos(Referencia referencia, TipoVeiculo tipoVeiculo, Marca marca) throws WSFipeException {
		ArrayList<Modelo> listModelo = new ArrayList<Modelo>();
		try {			
			HttpRequest request = new HttpRequest();
			request.setUrl("http://veiculos.fipe.org.br/api/veiculos/ConsultarModelos");
			request.setMethod("POST");
			
			request.getParameters().add(new HttpParameters("codigoTabelaReferencia", referencia.getCodigo()));
			request.getParameters().add(new HttpParameters("codigoTipoVeiculo", tipoVeiculo.getValue()));
			request.getParameters().add(new HttpParameters("codigoMarca", marca.getCodigo()));
			
			HttpResponse response = request.getResponse();
			
			JSONParser json = new JSONParser();
			JSONObject objModelos = (JSONObject)json.parse(response.getResponseStream().toString());
			JSONArray listJson = (JSONArray)objModelos.get("Modelos");
			
			for(int i = 0; i < listJson.size(); i++) {
				JSONObject objJson = (JSONObject)listJson.get(i);
				Modelo modelo = new Modelo();
				modelo.setCodigo(objJson.get("Value").toString().trim());
				modelo.setNome(objJson.get("Label").toString().trim());
				modelo.setReferencia(referencia);
				modelo.setMarca(marca);
				
				listModelo.add(modelo);
			}
			
			return listModelo;
			
		} catch(AsHttpException ex) {
			throw new WSFipeException("Problemas ao acessar servidor, Verifique sua conexão com a internet.",
					"WSFIPE8x12", ex.getMessage());
		} catch (ParseException ex) { 
			throw new WSFipeException("Problemas ao retornar dados do servidor.",
					"WSFIPE8x13", ex.getMessage());
		}
	}
	
	public ArrayList<AnoModelo> getAnosModelo(Referencia referencia, TipoVeiculo tipoVeiculo, Marca marca,
			Modelo modelo) throws WSFipeException {
		ArrayList<AnoModelo> listAnoModelo = new ArrayList<AnoModelo>();
		try {			
			HttpRequest request = new HttpRequest();
			request.setUrl("http://veiculos.fipe.org.br/api/veiculos/ConsultarAnoModelo");
			request.setMethod("POST");
			
			request.getParameters().add(new HttpParameters("codigoTabelaReferencia", referencia.getCodigo()));
			request.getParameters().add(new HttpParameters("codigoTipoVeiculo", tipoVeiculo.getValue()));
			request.getParameters().add(new HttpParameters("codigoMarca", marca.getCodigo()));
			request.getParameters().add(new HttpParameters("codigoModelo", modelo.getCodigo()));
			
			HttpResponse response = request.getResponse();
			
			JSONParser json = new JSONParser();
			JSONArray listJson = (JSONArray)json.parse(response.getResponseStream().toString());
			
			for(int i = 0; i < listJson.size(); i++) {
				JSONObject objJson = (JSONObject)listJson.get(i);
				
				String [] objStr = objJson.get("Value").toString().trim().split("-");
				
				AnoModelo anoModelo = new AnoModelo();
				anoModelo.setAnoModelo(objStr[0]);
				anoModelo.setTipoCombustivel(TipoCombustivel.getEnumByValue(objStr[1]));
				anoModelo.setReferencia(referencia);
				anoModelo.setMarca(marca);
				anoModelo.setModelo(modelo);
				
				listAnoModelo.add(anoModelo);
			}
			
			return listAnoModelo;
			
		} catch(AsHttpException ex) {
			throw new WSFipeException("Problemas ao acessar servidor, Verifique sua conexão com a internet.",
					"WSFIPE8x12", ex.getMessage());
		} catch (ParseException ex) { 
			throw new WSFipeException("Problemas ao retornar dados do servidor.",
					"WSFIPE8x13", ex.getMessage());
		}
	}
	
	public Veiculo getVeiculo(Referencia referencia, TipoVeiculo tipoVeiculo, Marca marca,
			Modelo modelo, AnoModelo anoModelo) throws WSFipeException {
		try {			
			HttpRequest request = new HttpRequest();
			request.setUrl("http://veiculos.fipe.org.br/api/veiculos/ConsultarValorComTodosParametros");
			request.setMethod("POST");
			
			request.getParameters().add(new HttpParameters("codigoTabelaReferencia", referencia.getCodigo()));
			request.getParameters().add(new HttpParameters("codigoTipoVeiculo", tipoVeiculo.getValue()));
			request.getParameters().add(new HttpParameters("codigoMarca", marca.getCodigo()));
			request.getParameters().add(new HttpParameters("codigoModelo", modelo.getCodigo()));
			request.getParameters().add(new HttpParameters("anoModelo", anoModelo.getAnoModelo()));
			request.getParameters().add(new HttpParameters("codigoTipoCombustivel", anoModelo.getTipoCombustivel().getValue()));
			request.getParameters().add(new HttpParameters("tipoConsulta", "tradicional"));
			
			HttpResponse response = request.getResponse();
			
			JSONParser json = new JSONParser();
			JSONObject objJson = (JSONObject)json.parse(response.getResponseStream().toString());
			
			Veiculo veiculo = new Veiculo();
			veiculo.setCodigoFipe(objJson.get("CodigoFipe").toString().replace("-", "").trim());
			veiculo.setValor(Double.parseDouble(objJson.get("Valor").toString().replace("R$", "").replace(".", "").replace(",", ".").trim()));
			veiculo.setReferencia(referencia);
			veiculo.setMarca(marca);
			veiculo.setModelo(modelo);
			veiculo.setAnoModelo(anoModelo);
			veiculo.setAutenticacao(objJson.get("Autenticacao").toString().trim());
			veiculo.setTipoVeiculo(TipoVeiculo.getEnumByValue(objJson.get("TipoVeiculo").toString().trim()));
			veiculo.setDataConsulta(objJson.get("DataConsulta").toString().trim());
			
			return veiculo;
			
		} catch(AsHttpException ex) {
			throw new WSFipeException("Problemas ao acessar servidor, Verifique sua conexão com a internet.",
					"WSFIPE8x12", ex.getMessage());
		} catch (ParseException ex) { 
			throw new WSFipeException("Problemas ao retornar dados do servidor.",
					"WSFIPE8x13", ex.getMessage());
		}
	}

	public ArrayList<Referencia> getReferencias() {
		return referencias;
	}
}
