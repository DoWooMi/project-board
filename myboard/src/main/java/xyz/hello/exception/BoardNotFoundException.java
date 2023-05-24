package xyz.hello.exception;

public class BoardNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BoardNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardNotFoundException(String message) {
		super(message);
	}

}
