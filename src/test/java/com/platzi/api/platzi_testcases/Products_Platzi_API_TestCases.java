package com.platzi.api.platzi_testcases;

import com.platzi.api.baseAPITestSuite.PlatziBaseAPITestSuite;
import com.platzi.api.restclients.baseRestClient.RequestEndPoints;
import com.platzi.api.utility.utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Products_Platzi_API_TestCases  extends PlatziBaseAPITestSuite  {

    HashMap<Object,Object> dataMap = new HashMap<Object,Object>();
    LinkedHashMap<String,String> headerMap = new LinkedHashMap<String,String>();

    @Test(description = "Create New Product and Validate Status Code")
    public void products_platzi_api_tc001(){

        String images[] = {"https://placeimg.com/640/480/any"};

        dataMap.put("endpoints", RequestEndPoints.create_new_products_URI);
        dataMap.put("title", utility.generateRandomString());
        dataMap.put("price",utility.generateRandomInteger());
        dataMap.put("description",utility.generateRandomString());
        dataMap.put("categoryId",1);
        dataMap.put("images", images);

        headerMap.put("Content-Type","application/json");
        headerMap.put("access-token",access_token);

         response = productOperations.create_new_product_api_request(dataMap,headerMap);
         response.prettyPrint();
         Assert.assertEquals(constant.HTTP_RESPONSE_CODE_201,response.statusCode());

    }

    @Test(description = "Validate New Product is Displayed in the response ")
    public void products_platzi_api_tc002(){


        headerMap.put("Content-Type","application/json");
        headerMap.put("access-token",access_token);

        dataMap.put("get_product_endPoint",RequestEndPoints.get_products_endpoint_URI);
        response = productOperations.retrieve_product_api_request(dataMap,headerMap);
        Assert.assertEquals(constant.HTTP_RESPONSE_CODE_200,response.statusCode());

    }

}
