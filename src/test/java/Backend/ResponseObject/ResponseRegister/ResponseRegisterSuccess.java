package Backend.ResponseObject.ResponseRegister;

import Backend.ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class ResponseRegisterSuccess implements ResponseValidator {

    @JsonProperty("id")
    private Integer Id;

    @JsonProperty("token")
    private String Token;

    public void ValidateResponse(){
        Assert.assertNotNull(Token);
        Assert.assertNotNull(Id);
    }
}
