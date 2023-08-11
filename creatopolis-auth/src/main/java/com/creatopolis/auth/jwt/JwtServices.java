package com.creatopolis.auth.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServices {
	
	private static final String SECRET_KEY = "1234567890987654321QWERTYUIOPLKJHGFDSA1234567890987654321QWERTYUIOPLKJHGFDSA1234567890987654321QWERTYUIOPLKJHGFDSA";
	
	public String getToken(UserDetails user) {
		return this.getToken(new HashMap<>(), user);
	}

	private String getToken(Map<String, Object> extraClaim, UserDetails user) {
		return Jwts.builder()
				.setClaims(extraClaim)
				.setSubject(user.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
				.signWith(this.getKey(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	private SecretKey getKey() {
		byte[]  keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return  Keys.hmacShaKeyFor(keyBytes);
	}

	public String getToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Claims getAllClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(this.getKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
		
		 Claims claims = this.getAllClaims(token);
		return claimsResolver.apply(claims);
		
	}
	
	public String getUsernameFromToken(String token) {
		return this.getClaim(token, Claims::getSubject);
	}
	
	public Date getExpirateDate(String token) {
		return this.getClaim(token, Claims::getExpiration);
	}
	
	public boolean isTokenExpirate(String token) {
		return this.getExpirateDate(token).before(new Date());
	}
	
}
