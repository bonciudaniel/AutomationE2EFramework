package Backend.RequestObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class RequestHelper {

    private RequestSpecification Request;
    private Response response;

    public RequestHelper() {
        Request = RestAssured.given();
        Request.header("Content-Type","application/json");

    }
    public Response performRequest(String requestType,String endpoint,Object body){

        String baseUrl = "https://bookstore.toolsqa.com";
        Request.baseUri(baseUrl);

        switch (requestType){
            case "get" :
                response = Request.get(endpoint);
                break;
            case "post" :
                Request.body(body);
                response = Request.post(endpoint);
                break;
            case "put" :
                Request.body(body);
                response = Request.put(endpoint);
                break;
            case "patch" :
                Request.body(body);
                response = Request.patch(endpoint);
                break;
            case "delete" :
                response = Request.delete(endpoint);
                break;

        }
        Assert.assertNotNull(response,"Request was not performed");
       return response;
    }
    public Response performRequest(String requestType,String endpoint,Object body,String Token){

        String baseUrl = "https://bookstore.toolsqa.com";
        Request.baseUri(baseUrl);
        Request.headers("Authorization","Bearer"+Token);


        switch (requestType){
            case "post" :
                Request.body(body);
                response = Request.post(endpoint);
                break;


        }
        Assert.assertNotNull(response,"Request was not performed");
        return response;
    }

}

