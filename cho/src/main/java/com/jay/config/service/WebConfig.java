package com.jay.config.service;

import java.security.Key;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jay.config.filter.JWTInterceptor;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

	private final JWTInterceptor jwtInterceptor;

	private String[] excludePath = {
		"/createToken"
	};

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.info("안녕");
		log.info(excludePath.toString());
		registry.addInterceptor(jwtInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns(excludePath);
	}
}
