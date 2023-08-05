package com.creatopolis.auth.services;

import java.util.Optional;

import com.creatopolis.commons.model.Usuario;

public interface UsuarioServices {
	
	public Optional<Usuario> findByEmail(String email);
	
	public void save(Usuario usuario);

}
