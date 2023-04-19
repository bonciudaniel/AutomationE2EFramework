package Backend.ResponseObject;

import Backend.ResponseObject.ResponseLogin.ResponseLoginFailed;
import Backend.ResponseObject.ResponseLogin.ResponseLoginSuccess;
import Backend.ResponseObject.ResponseRegister.ResponseRegisterFailed;
import Backend.ResponseObject.ResponseRegister.ResponseRegisterSuccess;
import Backend.ResponseObject.ResponseResource.ResponseResourceSuccess;
import Backend.ResponseObject.ResponseResources.ResponseResourcesSuccess;
import Backend.ResponseObject.ResponseUser.ResponsePostUser;
import Backend.ResponseObject.ResponseUser.ResponsePutPatchUser;
import Backend.ResponseObject.ResponseUsers.ResponseUsersSuccess;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;

public class ResponseHelper {


    private Response response;

    public ResponseHelper(Response response) {
        this.response = response;
    }

    public void validateResponseCode(Integer expected) {
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), expected);

    }

    public void validateResponse(String ResponseType, Integer ResponseCode,String expected){
        validateResponseCode(ResponseCode);
        if (ResponseType.equals(ResponseBodyType.RESPONSE_LOGIN_SUCCESS)) {
            switch (ResponseCode) {
                case 400:
                    ResponseLoginFailed ResponseLoginFailed = response.getBody().as(Backend.ResponseObject.ResponseLogin.ResponseLoginFailed.class);
                    ResponseLoginFailed.ValidateResponse(expected);
                    break;
            }
        }
        if (ResponseType.equals(ResponseBodyType.RESPONSE_REGISTER)) {
            switch (ResponseCode) {
                case 400:
                    ResponseRegisterFailed ResponseRegisterFailed = response.getBody().as(Backend.ResponseObject.ResponseRegister.ResponseRegisterFailed.class);
                    ResponseRegisterFailed.ValidateResponse(expected);
                    break;
            }

        }

    }

    public void validateResponse(String ResponseType, Integer ResponseCode) {
        validateResponseCode(ResponseCode);
        if (ResponseType.equals(ResponseBodyType.RESPONSE_LOGIN_SUCCESS)) {
            switch (ResponseCode) {
                case 200:
                    ResponseLoginSuccess ResponseLoginSuccess = response.getBody().as(Backend.ResponseObject.ResponseLogin.ResponseLoginSuccess.class);
                    ResponseLoginSuccess.ValidateResponse();
                    break;

            }
        }
        if (ResponseType.equals(ResponseBodyType.RESPONSE_REGISTER)) {
            switch (ResponseCode) {
                case 200:
                    ResponseRegisterSuccess ResponseRegisterSuccess = response.getBody().as(Backend.ResponseObject.ResponseRegister.ResponseRegisterSuccess.class);
                    ResponseRegisterSuccess.ValidateResponse();
                    break;
            }

        }

        if (ResponseType.equals(ResponseBodyType.RESPONSE_RESOURCES)) {
            switch (ResponseCode) {
                case 200:
                    ResponseResourcesSuccess responseResourcesSuccess = response.getBody().as(ResponseResourcesSuccess.class);
                    responseResourcesSuccess.ValidateResponse();
                    break;

            }
            if (ResponseType.equals(ResponseBodyType.RESPONSE_RESOURCE)) {
                switch (ResponseCode) {
                    case 200:
                        ResponseResourceSuccess responseResourceSuccess = response.getBody().as(ResponseResourceSuccess.class);
                        responseResourceSuccess.ValidateResponse();
                        break;
                    case 400:
                        Assert.assertNotNull(response);
                        break;
                }

            }
            if (ResponseType.equals(ResponseBodyType.RESPONSE_USER)) {
                switch (ResponseCode) {
                    case 201:
                        ResponsePostUser responsePostUser = response.getBody().as(ResponsePostUser.class);
                        responsePostUser.ValidateResponse();
                        break;
                    case 200:
                        ResponsePutPatchUser responsePutPatch = response.getBody().as(ResponsePutPatchUser.class);
                        responsePutPatch.ValidateResponse();
                        break;
                    case 204:
                       Assert.assertNotNull(response.getBody());
                        break;
                }

            }
            if (ResponseType.equals(ResponseBodyType.RESPONSE_USERS)){
                switch (ResponseCode){
                    case 200:
                        ResponseUsersSuccess responseUsersSuccess = response.getBody().as(ResponseUsersSuccess.class);
                        responseUsersSuccess.ValidateResponse();
                        break;
                    case 404:
                    Assert.assertNotNull(response.getBody());
                    break;

                }
            }
        }
    }

    public void printResponseBody(){
        ResponseBody Body = response.getBody();
        System.out.println(Body.asString());

        }
    }

