package com.rmgyantra.genericutils;

import io.restassured.response.Response;

public class JsonUtility {

public String getJsonResponseValue(Response response, String jsonPath) {
		
		String responseJsonValue = response.jsonPath().get(jsonPath);
		return responseJsonValue;
	}
}
