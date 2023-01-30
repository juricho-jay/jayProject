package com.jay.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jay.config.service.JWTService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TestController {

	private final JWTService jwtService;

	@GetMapping("/getTest")
	public String getTest(@RequestParam String userId) throws Exception {
		return userId;
	}

	@PostMapping("/postTest")
	public Map postTest(@RequestBody Map<String, String> userInfoMap) throws Exception {
		log.info(userInfoMap.get("userId"));
		return userInfoMap;
	}

	@PostMapping("/createToken")
	public String createToken() throws Exception {
		return "생성 완료" + jwtService.createToken();
	}


}
