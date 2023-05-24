package xyz.hello.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginAuthFailException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String id;
	
	public LoginAuthFailException() {
		// TODO Auto-generated constructor stub
	}

	public LoginAuthFailException(String message,String id) {
		super(message);
		this.id = id;
	}
	
	

}
