package com.platzi.api.restclients.baseRestClient;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CategoryAPIOperations extends BaseAPIRestClient {


    public Response create_category_api_request(HashMap<Object,Object> dataMap, LinkedHashMap<String,String> headerMap){

        return httpRequest.
                baseUri(properties.getInputFromPropertyFile("baseURI")).
                headers(getHeaders(headerMap)).
                body(dataMap).
                when().
                post(String.valueOf(dataMap.get("create_category_endpoint")));


    }

    public Response retrieve_category_api_request(HashMap<Object,Object> dataMap, LinkedHashMap<String,String> headerMap){

        return httpRequest.
                baseUri(properties.getInputFromPropertyFile("baseURI")).
                headers(getHeaders(headerMap)).
                get(String.valueOf(dataMap.get("get_category_endpoint")));
    }
}
