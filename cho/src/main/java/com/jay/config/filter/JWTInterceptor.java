package com.jay.config.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jay.config.service.JWTService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JWTInterceptor implements HandlerInterceptor {

	private final JWTService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		Exception {
		String token = request.getHeader("Authorization");
		if (token != null) {
			jwtService.checkToken(token);
			return true;
		} else {
			throw new Exception("JWT 토큰이 없습니다.");
		}
	}
}
