package com.platzi.api.baseAPITestSuite;

import com.platzi.api.restclients.baseRestClient.BaseAPIRestClient;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PlatziBaseAPITestSuite extends BaseAPIRestClient {


    @BeforeMethod
    public void setUp() {

        setPrerequisiteAPI();
        httpRequest = setRequest();
        access_token = create_authorization_request();
    }

    @AfterMethod
    public void tearDown(){


    }
}
