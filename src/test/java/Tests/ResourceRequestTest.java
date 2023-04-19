package Tests;

import Backend.RequestObject.RequestMethodType;
import Backend.RequestObject.RequestURLType;
import Backend.ResponseObject.ResponseBodyType;
import Backend.ResponseObject.ResponseCodeType;
import Backend.ResponseObject.ResponseHelper;
import ShareData.Hooks;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ResourceRequestTest extends Hooks {


    @Test(priority = 1)
    public void getListResourceTest(){


        Response response=requestHelper.performRequest(RequestMethodType.GET_METHOD,baseURL+ RequestURLType.GET_ListResource,null);
        responseHelper = new ResponseHelper(response);
       responseHelper.validateResponse(ResponseBodyType.RESPONSE_RESOURCES,ResponseCodeType.STATUS_200);
       responseHelper.printResponseBody();


    }
    @Test(priority = 2)
    public void getListSingleResourceTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD,baseURL+RequestURLType.GET_ListSingleResource,null);

         responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_RESOURCE,ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();


    }
    @Test(priority = 3)
     public void getSingleResourceNotFound(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD,baseURL+RequestURLType.GET_SingleResourceNotFound,null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_RESOURCE,ResponseCodeType.STATUS_404);
        responseHelper.printResponseBody();

    }


}
