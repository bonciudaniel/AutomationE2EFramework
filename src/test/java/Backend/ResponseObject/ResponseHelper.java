package Backend.ResponseObject;

import Backend.ResponseObject.ResponseBooks.ResponseBooksSuccess;
import Backend.ResponseObject.ResponseLogin.ResponseUserSuccess;
import Backend.ResponseObject.ResponseToken.ResponseTokenSuccess;
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

    public void validateResponse(String ResponseType, Integer ResponseCode) {
        validateResponseCode(ResponseCode);
        if (ResponseType.equals(ResponseBodyType.RESPONSE_USER)) {
            switch (ResponseCode) {
                case 201:
                    ResponseUserSuccess ResponseUserSuccess = response.getBody().as(Backend.ResponseObject.ResponseLogin.ResponseUserSuccess.class);
                    ResponseUserSuccess.ValidateResponse();
                    break;

            }

        }
        if (ResponseType.equals(ResponseBodyType.RESPONSE_TOKEN)) {
            switch (ResponseCode) {
                case 200:
                    ResponseTokenSuccess ResponseTokenSuccess = response.getBody().as(ResponseTokenSuccess.class);
                    ResponseTokenSuccess.ValidateResponse();
                    break;

            }
        }
        if (ResponseType.equals(ResponseBodyType.RESPONSE_BOOKS)) {
            switch (ResponseCode) {
                case 201:
                    ResponseBooksSuccess ResponseBooksSuccess = response.getBody().as( ResponseBooksSuccess.class);
                    ResponseBooksSuccess.ValidateResponse();
                    break;

            }
        }
    }
    public <T> T getSpecificObject(Class<T>Klass){
        return  response.getBody().as(Klass);

    }

        public void printResponseBody() {
            ResponseBody Body = response.getBody();
            System.out.println(Body.asString());

        }
    }


