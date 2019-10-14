package com.restful.controller.healthcheck;

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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restful.vo.HealthcheckFullResult;
import com.restful.vo.HealthcheckResult;
import com.restful.vo.HealthcheckShortResult;

@RestController
class HealthcheckController {

	@GetMapping(value = "/healthcheck", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> healthcheckGet(@RequestParam(value = "format") String format) {

		String status = "OK"; // Assume result is Ok;
		String shortFormatValue = "short";
		String fullFormatValue = "full";
		String jsonResponse = "";
		HealthcheckResult healthcheckResult;

		if (format.toUpperCase().equals(shortFormatValue.toUpperCase())
				|| format.toUpperCase().equals(fullFormatValue.toUpperCase())) {

			if (format.toUpperCase().equals(shortFormatValue.toUpperCase())) {
				healthcheckResult = new HealthcheckShortResult(status);
			} else {
				healthcheckResult = new HealthcheckFullResult(status);
			}

			try {
				jsonResponse = convertJavaToJson(healthcheckResult);

			} catch (JsonProcessingException e) {
				System.out.println("JsonProcessingException occured" + e.getMessage());
			}
			return new ResponseEntity<String>(jsonResponse, HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Bad Request", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/healthcheck")
	@ResponseBody
	public ResponseEntity<String> healthcheckPut() {
		return new ResponseEntity<String>("Method Not Allowed", HttpStatus.METHOD_NOT_ALLOWED);
	}

	@PostMapping(value = "/healthcheck")
	@ResponseBody
	public ResponseEntity<String> healthcheckPost() {
		return new ResponseEntity<String>("Method Not Allowed", HttpStatus.METHOD_NOT_ALLOWED);
	}

	@DeleteMapping(value = "/healthcheck")
	@ResponseBody
	public ResponseEntity<String> healthcheckDelete() {
		return new ResponseEntity<String>("Method Not Allowed", HttpStatus.METHOD_NOT_ALLOWED);
	}

	// Static method to convert object to json string
	static String convertJavaToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResult = "";
		jsonResult = objectMapper.writeValueAsString(obj);
		return jsonResult;
	}
}