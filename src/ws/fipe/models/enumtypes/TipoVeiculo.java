package ws.fipe.models.enumtypes;

/**
 * Tipo de Veículo como valores fixos.
 * @author Matheus Amaro
 *
 */
public enum TipoVeiculo {
	NENHUM("0"),
	CARRO("1"),
	MOTO("2"),
	CAMINHAO("3");
	
	private String value;
	
	TipoVeiculo(String value) {
		this.value = value;
	}
	
    public static TipoVeiculo getEnumByValue(String value) {
        for (int i = 0; i < values().length; i++) {
            if (value.equals(values()[i].value)) {
                return values()[i];	
            }
        }
        return null;
    }
	
	public String getValue() {
		return value;
	}
}
