package com.creatopolis.usuarios.serviceimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creatopolis.commons.model.Usuario;
import com.creatopolis.usuarios.repository.UsuarioRepository;
import com.creatopolis.usuarios.service.UsuariosServices;

@Service
public class UsuarioServicesImp implements UsuariosServices {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario guardarUsuario(Usuario user) {
		return this.usuarioRepository.saveAndFlush(user);
	}

	@Override
	public List<Usuario> getAllUsers() {
		return this.usuarioRepository.findAll();
	}
	
	@Override
	public Optional<Usuario> getUserById(Long id) {
		return this.usuarioRepository.findById(id);
	}

	@Override
	public Usuario updateUsuario(Usuario user) {
		return this.usuarioRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		this.usuarioRepository.deleteById(id);

	}

	@Override
	public Usuario findAllByEmail(String email) {
		return this.usuarioRepository.findByEmail(email);
	}

	@Override
	public List<Usuario> findByCategoria(String categorias) {
		List<Usuario> listaUsuarios = this.usuarioRepository.findAll();
		List<Long> listaCategorias = new ArrayList<>();
		for (String cat : categorias.split(",")) {
			listaCategorias.add(Long.parseLong(cat));
		}
		return listaUsuarios.stream().filter(usuario -> usuario.getCategorias().stream().anyMatch(listaCategorias::contains)).collect(Collectors.toList());
	}

}
