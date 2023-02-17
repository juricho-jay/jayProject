package com.jay.api.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class HelloWorldController {

	@GetMapping("/api/hello")
	public String helloTest() {
		return "Hello, world!";
	}
}
