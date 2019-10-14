package com.restful.controller.greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.restful.utils.Mapper;
import com.restful.vo.Greeting;

@RestController
public class GreetingController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping(value = "/greeting", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> greetingGet(@RequestParam(name = "name", defaultValue = "World") String name) {

		Greeting greetingMessage = new Greeting(counter.incrementAndGet(), name);
		String jsonString = "";

		try {
			jsonString = Mapper.convertObjToJsonString(greetingMessage);

		} catch (JsonProcessingException e) {
			jsonString = "System Error";
		}
		return new ResponseEntity<String>(jsonString, HttpStatus.OK);
	}

	@PostMapping("/greeting")
	@ResponseBody
	public ResponseEntity<String> greetingPost() {

		return new ResponseEntity<String>("Method Not Allowed", HttpStatus.METHOD_NOT_ALLOWED);
	}

	@DeleteMapping("/greeting")
	@ResponseBody
	public ResponseEntity<String> greetingDelete() {
		return new ResponseEntity<String>("Method Not Allowed", HttpStatus.METHOD_NOT_ALLOWED);
	}

	@PutMapping("/greeting")
	@ResponseBody
	public ResponseEntity<String> greetingPut() {
		return new ResponseEntity<String>("Method Not Allowed", HttpStatus.METHOD_NOT_ALLOWED);
	}
}