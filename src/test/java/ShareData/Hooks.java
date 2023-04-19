package ShareData;

import Backend.RequestObject.RequestHelper;
import Backend.ResponseObject.ResponseHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hooks extends ShareData{

    public RequestHelper requestHelper;
    public ResponseHelper responseHelper;

    public String baseURL = "https://bookstore.toolsqa.com";


    @BeforeMethod
    public void prepareEnviroment(){
        Setup();
        requestHelper=new RequestHelper();




    }
    @AfterMethod
    public void clearEnviroment(){

        //Clear();

    }
}
