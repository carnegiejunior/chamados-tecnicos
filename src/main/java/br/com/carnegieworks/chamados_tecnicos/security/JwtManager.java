package br.com.carnegieworks.chamados_tecnicos.security;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.carnegieworks.chamados_tecnicos.domain.dto.user.UserLoginResponseDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtManager {
	public UserLoginResponseDTO createToken(String email, List<String> roles) {
		
		Calendar expirationTime = Calendar.getInstance();
		expirationTime.add(Calendar.DAY_OF_MONTH, SecurityConstants.JWT_EXP_DAYS);
		 
		String jwt = Jwts.builder()
				.setSubject(email)
				.setExpiration(expirationTime.getTime())
				.claim(SecurityConstants.JWT_ROLE_KEY,roles)
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.API_KEY.getBytes())
				.compact();
				
				Long expireIn = expirationTime.getTimeInMillis();
		
		
		
		return new UserLoginResponseDTO(jwt, expireIn,SecurityConstants.JWT_PROVIDER);
	}
	
	public Claims parseToken(String token) throws JwtException {
		
		Claims claims = 
				
				Jwts
					.parser()
					.setSigningKey(SecurityConstants.API_KEY.getBytes())
					.parseClaimsJws(token)
					.getBody();
		
		return claims;
	}
}
