package com.jay.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/getTest")
	public String getTest(@RequestParam String userId) throws Exception {
		return userId;
	}

	@PostMapping("/postTest")
	public Map postTest(@RequestBody Map<String, String> userInfoMap) throws Exception {
		return userInfoMap;
	}
}
