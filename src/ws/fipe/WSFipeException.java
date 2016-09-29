package ws.fipe;
/**
 * Classe de controle de exce��o.
 * @author Matheus Amaro
 *
 */
public class WSFipeException extends Exception {
	private static final long serialVersionUID = 2842436620349190518L;
	
	private String code;
	private String details;
	
	public WSFipeException(String message) {
		super(message);
		this.code = "";
		this.details = "";
	}
	
	public WSFipeException(String message, String code) {
		super(message);
		this.code = code;
		this.details = "";
	}
	
	public WSFipeException(String message, String code, String details) {
		super(message);
		this.code = code;
		this.details = details;
	}
	
	public String getFullMessage() {
		if(this.code.isEmpty()) {
			return super.getMessage();
		}
		return this.code + " - " + super.getMessage();
	}

	public String getCode() {
		return code;
	}

	public String getDetails() {
		return details;
	}
}
