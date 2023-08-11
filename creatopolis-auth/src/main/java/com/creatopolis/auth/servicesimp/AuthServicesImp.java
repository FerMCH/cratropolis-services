package com.creatopolis.auth.servicesimp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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
	
	@Autowired
	private AuthenticationManager authenticationManager;
	

	@Override
	public AuthResponse login(Usuario usuario) {
		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario, usuario));
		UserDetails userDetails = this.usuarioServices.findByEmail(usuario.getEmail()).get();
		Optional<Usuario> user = this.usuarioServices.findByEmail(usuario.getEmail());	
		AuthResponse authResponse = new AuthResponse();
		
		if (user.isPresent() && user.get().getEmail().equalsIgnoreCase(usuario.getEmail()) && user.get().getPassword().equalsIgnoreCase(usuario.getPassword())) {
			authResponse.setToken(this.jwtServices.getToken(usuario));
		}
		
		return authResponse;
	}

	@Override
	public AuthResponse register(Usuario usuario) {
		 this.usuarioServices.save(usuario);
		 AuthResponse authResponse = new AuthResponse();
		 authResponse.setToken(this.jwtServices.getToken(usuario));
		 return authResponse;
	}

}
