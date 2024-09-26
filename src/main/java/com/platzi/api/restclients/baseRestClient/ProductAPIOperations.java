package com.platzi.api.restclients.baseRestClient;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ProductAPIOperations extends BaseAPIRestClient {

    public Response create_new_product_api_request(HashMap<Object,Object> dataMap, LinkedHashMap<String,String> headerMap){


        return httpRequest.
                baseUri(properties.getInputFromPropertyFile("baseURI")).
                headers(getHeaders(headerMap)).
                body(dataMap).
                when().
                post(String.valueOf(dataMap.get("endpoints")));

    }

    public Response retrieve_product_api_request(HashMap<Object,Object> dataMap, LinkedHashMap<String,String> headerMap){

       return httpRequest.
                baseUri(properties.getInputFromPropertyFile("baseURI")).
                headers(getHeaders(headerMap)).
                get(String.valueOf(dataMap.get("get_product_endPoint")));

    }
}
