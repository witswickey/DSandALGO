package JavaBasic;

public class CustomException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String message;
	
	public String getMessage() {
		
		int i=10/0;
		assert false;
		return message;
	}
	
	public CustomException(String message) {
		this.message=message;
	}
	
	
}
