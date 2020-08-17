package br.com.carnegieworks.chamados_tecnicos.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		String hash = DigestUtils.sha256Hex(rawPassword.toString());
		return hash;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String hash = DigestUtils.sha256Hex(rawPassword.toString());
		return hash.equals(encodedPassword);
	}

	
	
}
