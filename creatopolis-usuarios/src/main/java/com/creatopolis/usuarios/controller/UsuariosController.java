package com.creatopolis.usuarios.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creatopolis.commons.dto.UsuarioDto;
import com.creatopolis.commons.model.Usuario;
import com.creatopolis.usuarios.serviceimp.UsuarioServicesImp;


@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuariosController.class);
	
	@Autowired
	private UsuarioServicesImp usuarioServices;

	
	@GetMapping(value = "") 
	public List<Usuario> getUsuario() {
		UsuarioDto user = new UsuarioDto();
		user.setNombre("Fer");
		return this.usuarioServices.getAllUsers();
	}
	
	@GetMapping(value = "/{id}") 
	public Optional<Usuario> getUsuario(@PathVariable long id) {
		UsuarioDto user = new UsuarioDto();
		user.setNombre("Fer");
		return this.usuarioServices.getUserById(id);
	}
	
	@PostMapping(value = "/guardar") 
	public Usuario guardarUsuario(@RequestBody UsuarioDto user) {
		logger.info(user.getNombre());
		return this.usuarioServices.guardarUsuario(new Usuario(user));
	}
	
	@DeleteMapping(value = "/{id}") 
	public void deleteById(@PathVariable Long id) {
		this.usuarioServices.delete(id);
	}
	
	
}
