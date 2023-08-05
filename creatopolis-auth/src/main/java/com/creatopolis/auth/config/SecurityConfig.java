package com.creatopolis.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.creatopolis.auth.jwt.JwtAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

import java.security.AuthProvider;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private AuthenticationProvider authProvider;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
					.csrf(csrf -> 
					csrf
					.disable())
					.authorizeHttpRequests(authRequest ->
						authRequest
						.requestMatchers("/auth/**")
							.permitAll().anyRequest().permitAll())
								.sessionManagement(sessionManager -> 
								sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
								.authenticationProvider(authProvider)
								.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
								.build();
	
	}
}
