package com.creatopolis.auth.servicesimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creatopolis.auth.jwt.JwtServices;
import com.creatopolis.auth.services.AuthServices;
import com.creatopolis.commons.dto.AuthResponse;
import com.creatopolis.commons.model.Usuario;

@Service
public class AuthServicesImp implements AuthServices {
	
	@Autowired
	private UsuarioServicesImp usuarioServices;
	
	@Autowired
	private JwtServices jwtServices;
	

	@Override
	public AuthResponse login(Usuario usuario) {
		return null;
	}

	@Override
	public AuthResponse register(Usuario usuario) {
		 this.usuarioServices.save(usuario);
		 AuthResponse authResponse = new AuthResponse();
		 authResponse.setToken(this.jwtServices.getToken(usuario));
		 return authResponse;
	}

}
