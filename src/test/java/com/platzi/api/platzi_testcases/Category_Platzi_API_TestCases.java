package com.platzi.api.platzi_testcases;

import com.platzi.api.baseAPITestSuite.PlatziBaseAPITestSuite;
import com.platzi.api.restclients.baseRestClient.RequestEndPoints;
import com.platzi.api.utility.utility;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Category_Platzi_API_TestCases extends PlatziBaseAPITestSuite {



    @Test
    public void category_platzi_api_tc001(){


        dataMap.put("name", utility.getCategoryNames());
        dataMap.put("image", "https://placeimg.com/640/480/any");
        dataMap.put("create_category_endpoint", RequestEndPoints.create_new_category_URI);

        headerMap.put("Content-Type","application/json");
        headerMap.put("access-token",access_token);


        response = categoryOperations.create_category_api_request(dataMap,headerMap);
        response.prettyPrint();
        Assert.assertEquals(constant.HTTP_RESPONSE_CODE_201,response.statusCode());

    }
    @Test
    public void category_platzi_api_tc002(){

        headerMap.put("Content-Type","application/json");
        headerMap.put("access-token",access_token);

        dataMap.put("get_category_endpoint", RequestEndPoints.get_category_endpoint_URI);
        response = categoryOperations.retrieve_category_api_request(dataMap,headerMap);
        response.prettyPrint();
        Assert.assertEquals(constant.HTTP_RESPONSE_CODE_200,response.statusCode());
    }
}
