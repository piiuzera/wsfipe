package ws.fipe.models.enumtypes;

/**
 * Tipo de Combustível como valores fixos.
 * @author Matheus Amaro
 *
 */
public enum TipoCombustivel {
	NENHUM("0"),
	GASOLINA("1"),
	ALCOOL("2"),
	DIESEL("3");
	
	private String value;
	
	TipoCombustivel(String value) {
		this.value = value;
	}
	
    public static TipoCombustivel getEnumByValue(String value) {
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
