package Backend.ResponseObject.ResponseUsers;

import Backend.ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class UsersSupport implements ResponseValidator {
    @JsonProperty("url")
    private String url;
    @JsonProperty("text")
    private String text;

    @Override
    public void ValidateResponse() {
        Assert.assertNotNull(url);
        Assert.assertNotNull(text);
    }
}
