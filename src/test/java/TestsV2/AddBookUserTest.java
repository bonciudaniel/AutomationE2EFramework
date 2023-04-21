package TestsV2;

import Backend.RequestObject.RequestBooks.IsbnObject;
import Backend.RequestObject.RequestBooks.RequestPostBooks;
import Backend.RequestObject.RequestUser.RequestPostUser;
import Backend.RequestObject.RequestMethodType;
import Backend.RequestObject.RequestURLType;
import Backend.RequestObject.RequestUser.RequestTokenUser.RequestTokenUser;
import Backend.ResponseObject.ResponseBodyType;
import Backend.ResponseObject.ResponseCodeType;
import Backend.ResponseObject.ResponseHelper;
import Backend.ResponseObject.ResponseToken.ResponseTokenSuccess;
import Backend.ResponseObject.ResponseUsers.ResponseUsersSuccess;
import Frontend.Pages.LoginPage;
import ShareData.Hooks;
import io.restassured.response.Response;
import lombok.var;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AddBookUserTest extends Hooks {

    public static String userId;
    public static  String Token;


    @Test
    public void addBooks(){

        String username = "probaItSchool" + System.currentTimeMillis(); //preia timpul curent si il transforma in milisecunde
        String password = "cityslicka" ;
        var RequestObject=GetPostUser(username,password);
        PostTokenUser(username,password);
        PostBooksUser(Arrays.asList(new IsbnObject("9781449325862"),new IsbnObject("9781449331818")));

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginValid(RequestObject);


    }

    public   RequestPostUser GetPostUser(String username, String password){


        RequestPostUser requestPostUserSuccess = new RequestPostUser.RequestPostUserBuilder().userName(username).Password(password).build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, RequestURLType.POST_USER, requestPostUserSuccess);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_201);
        responseHelper.printResponseBody();
        var responseObject= responseHelper.getSpecificObject(ResponseUsersSuccess.class);
        userId= responseObject.getUserID();
        return loginSuccess;
    }
    public void PostTokenUser(String username,String password){


        RequestTokenUser.tokenSuccess= new  RequestTokenUser.RequestTokenUserBuilder().userName(username).Password(password).build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, RequestURLType.POST_Token, tokenSuccess);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_TOKEN, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();

        var responseObject= responseHelper.getSpecificObject(ResponseTokenSuccess.class);
        Token=responseObject.getToken();
    }
    public void PostBooksUser(List<IsbnObject> ISBNS){


        RequestPostBooks booksSuccess= new  RequestPostBooks.RequestPostBooksBuilder().userId(userId).collectionOfIsbns(ISBNS).build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, RequestURLType.POST_Books,Token);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_BOOKS, ResponseCodeType.STATUS_201);
        responseHelper.printResponseBody();
    }
}
