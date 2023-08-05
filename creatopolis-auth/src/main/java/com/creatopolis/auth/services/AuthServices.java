package com.creatopolis.auth.services;

import com.creatopolis.commons.dto.AuthResponse;
import com.creatopolis.commons.model.Usuario;

public interface AuthServices {

	public AuthResponse login(Usuario usuario);
	
	public AuthResponse register(Usuario usuario);
}
