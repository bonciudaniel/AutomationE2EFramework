package Backend.ResponseObject.ResponseUsers;

import Backend.ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.testng.Assert;

import java.util.List;
@Getter
public class ResponseUsersSuccess implements ResponseValidator {

    @JsonProperty("page")
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    @JsonProperty("data")
    private List<UsersData> data;
    @JsonProperty("support")
    private UsersSupport support;
    @JsonProperty("userID")
    private String userID;
    @JsonProperty("username")
    private String username;
    @JsonProperty("books")
    private String books;



    @Override
    public void ValidateResponse() {
        Assert.assertNotNull(page);
        Assert.assertNotNull(perPage);
        Assert.assertNotNull(total);
        Assert.assertNotNull(totalPages);
        Assert.assertNotNull(data);
        Assert.assertNotNull(userID);
        Assert.assertNotNull(username);
        Assert.assertNotNull(books);
        for (Integer index = 0;index < data.size() ; index++){
            data.get(index).ValidateResponse();

        }
        Assert.assertNotNull(support);
        support.ValidateResponse();

    }
}
