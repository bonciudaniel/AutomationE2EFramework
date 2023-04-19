package Frontend.HelpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageMethods {
    private WebDriver driver;

    public PageMethods(WebDriver driver) {
        this.driver = driver;
    }
    public void NavigateToPage(String url){
        driver.navigate().to(url);
        WebDriverWait WaitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10)) ;
        WaitExplicit.until(ExpectedConditions.urlToBe(url));
    }
}
