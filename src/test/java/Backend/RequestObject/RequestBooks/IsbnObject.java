package Backend.RequestObject.RequestBooks;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IsbnObject {
    public IsbnObject(String isbn) {
        this.isbn = isbn;
    }

    @JsonProperty("isbn")
    private String isbn;
}
