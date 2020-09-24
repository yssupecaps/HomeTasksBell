package Service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Basis {

    protected String baseUrl="http://google.com/";
    protected String openUrl="http://open.ru/";

    public WebDriver driver;

    @BeforeEach
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver","/Users/suckme/Applications/chromedriver");
        //System.setProperty("webdriver.chrome.driver",System.getenv("CHROME_DRIVER");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @AfterEach
    void afterTest()  {
        driver.close();
        //driver.quit(); to close the window
    }
}
