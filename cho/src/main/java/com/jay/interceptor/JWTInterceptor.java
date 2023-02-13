package com.jay.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jay.api.jwt.service.JWTService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JWTInterceptor implements HandlerInterceptor {

	private final JWTService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		Exception {

		return true;

		// 토큰 체크 잠시 막아둠
		// String token = request.getHeader("Authorization"); // postman > Headers에서 설정한 Key값
		// if (token != null) {
		// 	jwtService.checkToken(token);
		// 	return true;
		// } else {
		// 	throw new Exception("JWT 토큰이 없습니다.");
		// }
	}
}
