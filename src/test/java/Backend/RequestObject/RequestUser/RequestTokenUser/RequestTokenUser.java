package Backend.RequestObject.RequestUser.RequestTokenUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder

public class RequestTokenUser {

    @JsonProperty("email")
    private String Email;

    @JsonProperty("password")
    private String Password;

    public static class RequestTokenUserBuilder{
        public RequestTokenUserBuilder(){

        }
    }
}
