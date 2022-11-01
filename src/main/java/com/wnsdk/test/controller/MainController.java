package com.wnsdk.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wnsdk.test.Model.TestDto;

@RestController
public class MainController {
	
	@PostMapping("/post")
	public ResponseEntity<?> post(@RequestBody TestDto testDto) {
		return new ResponseEntity<TestDto>(testDto, HttpStatus.OK);
	}
}
