package Frontend.Pages;

import Backend.RequestObject.RequestUser.RequestPostUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePages extends BasePage{



    public ProfilePages(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "userName-value")
    private WebElement username;

    @FindBy(xpath = "//button[text()='Log out']")
    private WebElement logOut;

    public void validateLogin(RequestPostUser postUser){
       elementMethods.ValidateElementText(username,postUser.getUserName());

    }
    public void logOut(){
        elementMethods.ClickElement(logOut);
    }

}
