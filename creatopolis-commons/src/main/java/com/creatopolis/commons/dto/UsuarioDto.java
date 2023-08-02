package com.creatopolis.commons.dto;

import java.io.Serializable;

import com.creatopolis.commons.model.Usuario;

public class UsuarioDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private String descripcion;
	
	private String password;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UsuarioDto() {
		
	}
	
	public UsuarioDto(Usuario user) {
		this.apellido = user.getApellido();
		this.descripcion = user.getDescripcion();
		this.email = user.getEmail();
		this.id = user.getId();
		this.nombre = user.getNombre();
		this.password = user.getPassword();
	}


}
