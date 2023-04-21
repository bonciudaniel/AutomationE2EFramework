package Frontend.Pages;

import Backend.RequestObject.RequestUser.RequestPostUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "userName")
    private WebElement username;

    @FindBy(id= "password")
    private WebElement parola;

    @FindBy(id ="login")
    private WebElement Login;
    @FindBy(xpath ="//h5")
    private WebElement LoginMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void LoginValid(RequestPostUser requestPostUser){

        elementMethods.FilleElement(username, requestPostUser.getUsername());

        elementMethods.FilleElement(parola, requestPostUser.getPassword());

        elementMethods.ClickElement(Login);


    }
    public void validateLoginMessage() {

        elementMethods.ValidateElementText(LoginMessage, "Login in book store");
    }
}
