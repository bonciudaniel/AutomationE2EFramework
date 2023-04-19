package Backend.ResponseObject.ResponseRegister;

import Backend.ResponseObject.ResponseSpecificValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class ResponseRegisterFailed implements ResponseSpecificValidator {

    @JsonProperty("error")
    private String Error;

    public void ValidateResponse(String expected){
        Assert.assertEquals(Error,expected);
    }
}
