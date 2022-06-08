package br.serratec.backend.projeto04.security;

import java.io.Serializable;

public class UsuarioAuthenticationResponse {
	
	
	private static final long serialVersionUID = 1L;
	
	private final String token;
	
	
	public UsuarioAuthenticationResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}
	
	
	
}
