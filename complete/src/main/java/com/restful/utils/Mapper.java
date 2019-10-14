package com.restful.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {

	public static ObjectMapper mapper = new ObjectMapper();

	public static String convertObjToJsonString(Object obj) throws JsonProcessingException {

		String jsonString = mapper.writeValueAsString(obj);
		return jsonString;
	}

	public static Object convertJsonStringToObj(String jsonString, Class<?> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		return mapper.readValue(jsonString, clazz.getClass());
	}
}