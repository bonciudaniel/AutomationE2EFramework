package ShareData;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ShareData {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    //Folosim adnotarea de @before din TestNG

    public void  Setup() {
        String cicd = System.getProperty("ci_cd");
        ChromeOptions chromeOptions = new ChromeOptions();
        if(Boolean.parseBoolean(cicd)){
            chromeOptions.addArguments("--addheadless");

        }else{
            System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");

        }
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://demoqa.com/login");


        //Wait Implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

        //folosim @after

                public void Clear(){

        //inchidem un browser
            driver.quit();
            //Driver.quit = inchide browserul cu oricate taburi deschide
            //Close = inchide tabul curent
            //quit = inchide browserul cu oricate taburi deschise



        }
    }

