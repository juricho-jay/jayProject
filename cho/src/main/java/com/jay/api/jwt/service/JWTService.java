package com.jay.api.jwt.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class JWTService {

	@Value("${jwt.token.key}")
	private String secretKey;
	private SignatureAlgorithm signatureAlgorithm;
	private Key signingKey;

	@PostConstruct
	public void init() throws Exception {
		// 암호화 기법 설정
		signatureAlgorithm = SignatureAlgorithm.HS512;

		// 암호 키 설정 (보안상 프로퍼티에 설정)
		byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(secretKey);
		signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());

		new Thread(() -> {
			int i = 0;
			while (i < 10000) {
				i++;
				log.info("안녕 나는 따로 빠진 로그얌");
			}
		}).start();
	}

	public String createToken() throws Exception {
		log.info("####createToken 탔음");
		// claims  넣을 값 생성
		Map<String, Object> claims = new HashMap<>();
		claims.put("userId", "jayri");
		claims.put("birth", "0428");
		claims.put("email", "jayri@gmail.com");

		// 1시간 짜리 토큰 생성
		JwtBuilder jwtBuilder = Jwts.builder()
			.setClaims(claims)
			.signWith(signatureAlgorithm, signingKey)
			.setExpiration(new Date(System.currentTimeMillis() + (3600 * 1000)));

		return jwtBuilder.compact();
	}

	public String checkToken(String token) throws Exception {
		Map<String, Object> claims = Jwts.parser()
			.setSigningKey(signingKey)
			.parseClaimsJws(token)
			.getBody();

		return claims.toString();
	}
}
