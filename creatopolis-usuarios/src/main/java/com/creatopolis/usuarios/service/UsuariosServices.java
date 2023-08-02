package com.creatopolis.usuarios.service;

import java.util.List;
import java.util.Optional;

import com.creatopolis.commons.model.Usuario;

public interface UsuariosServices {
	
	public Usuario guardarUsuario(Usuario user);
	
	public List<Usuario> getAllUsers();
	
	public Usuario updateUsuario(Usuario user);
	
	public void delete(Long id);
	
	public Optional<Usuario> getUserById(Long id);

}
