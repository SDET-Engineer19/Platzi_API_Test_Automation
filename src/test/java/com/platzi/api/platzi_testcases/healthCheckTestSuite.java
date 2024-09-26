package com.platzi.api.platzi_testcases;

import com.platzi.api.baseAPITestSuite.PlatziBaseAPITestSuite;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

public class healthCheckTestSuite extends PlatziBaseAPITestSuite {

    @Test
    public void health_check_validate_statuscode(){

               int status_code_200 = httpRequest.baseUri(properties.getInputFromPropertyFile("baseURI"))
                                                     .get(endPoints.get_products_endpoint_URI).statusCode();

        Assert.assertEquals(status_code_200,constant.HTTP_RESPONSE_CODE_200);

    }

    @Test
    public void health_check_validate_response_time(){

        response = httpRequest
                .baseUri(properties.getInputFromPropertyFile("baseURI"))
                .get(endPoints.get_products_endpoint_URI);
       Assert.assertTrue(response.getTime()>0);
     }


}
