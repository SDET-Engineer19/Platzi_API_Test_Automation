package com.platzi.api.restclients.baseRestClient;

import com.platzi.api.constants.Constants;

import com.platzi.api.utility.utility;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BaseAPIRestClient {

	protected static RequestSpecification httpRequest;
	protected static PropertyManager properties;
	protected static RequestSpecification authenticate;
	protected static RequestEndPoints endPoints;
	protected static Constants constant;
	protected static JsonPath jsonPath;
    protected static Response response;
	protected static ProductAPIOperations productOperations;
	protected static String access_token = null;
	protected static utility utils = null;
	protected static CategoryAPIOperations categoryOperations = null;
	protected static HashMap<Object,Object> dataMap = new HashMap<Object,Object>();
	protected static LinkedHashMap<String,String> headerMap = new LinkedHashMap<String,String>();

	public void setPrerequisiteAPI() {

		properties = new PropertyManager();
		endPoints = new RequestEndPoints();
		constant = new Constants();
		jsonPath = new JsonPath(new String());
		productOperations = new ProductAPIOperations();
		utils = new utility();
		categoryOperations = new CategoryAPIOperations();

	}

	public RequestSpecification setRequest() {

		return RestAssured.given();
	}

	 public String getJsonInputValue(String input) {

		 return jsonPath.get(input);
	 }

	public LinkedHashMap<String, String> getHeaders(LinkedHashMap<String,String> data){

		LinkedHashMap<String,String> headerMap = new LinkedHashMap<String,String>();
		headerMap.put("Content-Type",data.get("Content-Type"));
		headerMap.put("access_token",data.get("access_token"));

		return headerMap;
	}

	public String create_authorization_request(){

		Map<String,String> authMap = new HashMap<String,String>();
		Map<String,String> headerMap = new HashMap<String,String>();

		authMap.put("email",properties.getInputFromPropertyFile("username"));
		authMap.put("password",properties.getInputFromPropertyFile("password"));

		headerMap.put("Content-Type","application/json");
		headerMap.put("Authorization","Basic Y2FuZGlkYXRleDpxYS1pcy1jb29s");

		return httpRequest.given().body(authMap).headers(headerMap).when().post("https://api.escuelajs.co/api/v1/auth/login").getBody().jsonPath().get("access_token");

	}




}
