package Tests;

import Backend.RequestObject.RequestMethodType;
import Backend.RequestObject.RequestURLType;
import Backend.ResponseObject.ResponseBodyType;
import Backend.ResponseObject.ResponseCodeType;
import Backend.ResponseObject.ResponseHelper;
import ShareData.Hooks;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class UsersRequestTest extends Hooks {

    @Test(priority = 1)
    public void getListUsersTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD,baseURL+ RequestURLType.GET_ListUsers,null);
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();




    }
    @Test(priority = 2)
    public void getSingleUserTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD,baseURL+RequestURLType.GET_SingleUser,null
        );
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();




    }
    @Test(priority = 3)
    public void getSingleUserNotFound (){


        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD,baseURL+RequestURLType.GET_SingleUserNotFound,null);
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_404);
        responseHelper.printResponseBody();




    }
    @Test(priority = 4)
    public void getDelayResponseTest(){


        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD,baseURL+RequestURLType.GET_DelayResponse,null
        );


        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();


    }
}
