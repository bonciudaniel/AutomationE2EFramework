package Tests;

import Backend.RequestObject.RequestUser.RequestTokenUser.RequestTokenUser;
import Backend.RequestObject.RequestMethodType;
import Backend.RequestObject.RequestURLType;
import Backend.ResponseObject.ResponseBodyType;
import Backend.ResponseObject.ResponseCodeType;
import Backend.ResponseObject.ResponseHelper;
import ShareData.Hooks;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class RegisterRequestTests extends Hooks {

    @Test(priority = 1)
    public void postRegisterSuccessTest(){

        RequestTokenUser RequestSuccess = new RequestTokenUser.RequestRegisterBuilder().Email("eve.holt@reqres.in").Password("pistol").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD,baseURL+ RequestURLType.POST_Register,RequestSuccess);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_REGISTER, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();



    }

    @Test(priority = 2)
    public void postRegisterUnsuccesfulTest(){

        RequestTokenUser RequestFailed = new RequestTokenUser.RequestRegisterBuilder().Email("sydney@fife").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, baseURL+RequestURLType.POST_Register,RequestFailed);

        String expectedError = "Missing password";
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_REGISTER, ResponseCodeType.STATUS_400,expectedError);
        responseHelper.printResponseBody();



    }


}
