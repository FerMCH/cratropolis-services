package com.creatopolis.auth.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creatopolis.auth.servicesimp.AuthServicesImp;
import com.creatopolis.auth.servicesimp.UsuarioServicesImp;
import com.creatopolis.commons.dto.AuthResponse;
import com.creatopolis.commons.dto.LoginDto;
import com.creatopolis.commons.model.Usuario;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthServicesImp authServicesImp;
	
	@PostMapping(value = "/login")
	public ResponseEntity<AuthResponse> login(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(authServicesImp.login(usuario));
	}
	
	
	@PostMapping(value = "/register")
	public ResponseEntity<AuthResponse> register(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(authServicesImp.register(usuario));
		
	}

}
