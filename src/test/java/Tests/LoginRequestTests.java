package Tests;

import Backend.RequestObject.RequestLogin.RequestPostUser;
import Backend.RequestObject.RequestMethodType;
import Backend.RequestObject.RequestURLType;
import Backend.ResponseObject.ResponseBodyType;
import Backend.ResponseObject.ResponseCodeType;
import Backend.ResponseObject.ResponseHelper;
import ShareData.Hooks;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LoginRequestTests extends Hooks {



    @Test(priority = 1)
    public void postLoginSuccesfulTest(){

        RequestPostUser requestPostUserSuccess = new RequestPostUser.RequestLoginBuilder().Email("eve.holt@reqres.in").Password("cityslicka").build();

        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD,baseURL+ RequestURLType.POST_Login, requestPostUserSuccess);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_LOGIN_SUCCESS,ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();

    }

    @Test(priority = 2)
    public void postLoginUnSuccesfulTest(){

        RequestPostUser requestPostUserFailed = new RequestPostUser.RequestLoginBuilder().Email("peter@klaven").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD,baseURL+ RequestURLType.POST_Login, requestPostUserFailed);

        String expectedError = "Missing password" ;
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponseCode(ResponseCodeType.STATUS_400);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_LOGIN_SUCCESS,ResponseCodeType.STATUS_400,expectedError);
        responseHelper.printResponseBody();

    }
}
