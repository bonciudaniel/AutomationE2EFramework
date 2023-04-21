package TestsV2;

import Backend.RequestObject.RequestUser.RequestPostUser;
import Backend.RequestObject.RequestMethodType;
import Backend.RequestObject.RequestURLType;
import Backend.ResponseObject.ResponseBodyType;
import Backend.ResponseObject.ResponseCodeType;
import Backend.ResponseObject.ResponseHelper;
import Frontend.Pages.LoginPage;
import Frontend.Pages.ProfilePages;
import ShareData.Hooks;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateUserTest extends Hooks {

    @Test
    public void postLoginSuccesfulTest(){

        String username = "probaItSchool" + System.currentTimeMillis(); //preia timpul curent si il transforma in milisecunde

        RequestPostUser requestPostUserSuccess = new RequestPostUser.RequestPostUserBuilder().userName(username).Password("cityslicka").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, RequestURLType.POST_USER, requestPostUserSuccess);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_201);
        responseHelper.printResponseBody();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.LoginValid(requestPostUserSuccess);

        ProfilePages profilePages = new ProfilePages(getDriver());
        profilePages.validateLogin(requestPostUserSuccess);
        profilePages.logOut();

        loginPage.validateLoginMessage();
    }
}
