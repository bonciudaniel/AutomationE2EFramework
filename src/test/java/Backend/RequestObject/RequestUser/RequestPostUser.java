package Backend.RequestObject.RequestUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class RequestPostUser {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String Password;




    public static class RequestPostUserBuilder{
        public RequestPostUserBuilder() {
        }
    }


}
