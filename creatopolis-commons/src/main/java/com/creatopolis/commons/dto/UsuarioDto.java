package com.creatopolis.commons.dto;

import java.io.Serializable;
import java.util.List;

import com.creatopolis.commons.model.Usuario;
import com.creatopolis.commons.utils.Categoria;
import com.creatopolis.commons.utils.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UsuarioDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private String descripcion;
	
	private String password;

	@Enumerated(EnumType.STRING)
	private List<Role> role;
	
	@Enumerated(EnumType.STRING)
	private List<Categoria> categorias;
	
	
	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> Role) {
		this.role = Role;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
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
		this.categorias = user.getCategorias();
		this.role = user.getRole();
	}


}
