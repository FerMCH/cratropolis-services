package com.creatopolis.auth.servicesimp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creatopolis.auth.repository.UsuarioRepository;
import com.creatopolis.auth.services.UsuarioServices;
import com.creatopolis.commons.model.Usuario;

@Service
public class UsuarioServicesImp implements UsuarioServices {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Optional<Usuario> findByEmail(String email) {
		return this.usuarioRepository.findByEmail(email);
	}

	@Override
	public void save(Usuario usuario) {
		this.usuarioRepository.save(usuario);
	}

}
