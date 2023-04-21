package Backend.ResponseObject.ResponseBooks;

import Backend.ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

import java.util.List;

public class ResponseBooksSuccess implements ResponseValidator {
    @JsonProperty("books")
    private List<IsbnObject>books;

    @Override
    public void ValidateResponse() {
        Assert.assertNotNull(books);
    }
}
