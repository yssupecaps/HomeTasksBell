
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PageFactoryYandex {
    private WebDriver driver;
    private String url = "https://market.yandex.ru/";

    @FindBy(how = How.XPATH, using = "//a[@class =\"_3Lwc_UVFq4\"][contains(.,\"Электроника\")]")
    WebElement goToElectronics;

    @FindBy(how = How.XPATH, using="//*[@class=\"_2qvOOvezty _2x2zBaVN-3 _9qbcyI_fyS\"][contains(.,'Смартфоны')]")
    WebElement goToSmartphones;

    @FindBy(how = How.XPATH, using="//span[contains(., 'Apple')]/ancestor::a")
    WebElement chooseApple;

    @FindBy(how = How.XPATH, using="//a[@class= 'button button_size_s button_theme_pseudo n-pager__button-next i-bem n-smart-link button_js_inited n-smart-link_js_inited']")
    WebElement goToNextPage;

    @FindAll(@FindBy(how = How.XPATH, using =" //*[@class='n-snippet-cell2__brand-n"))
    List<WebElement> listOfWebElement;

    public PageFactoryYandex(WebDriver driver){
        this.driver=driver;
        driver.get(url);
        waitToLoadPage(8);
    }

    public void goToPage(){
        goToElectronics.click();
        waitToLoadPage(8);
        goToSmartphones.click();
        waitToLoadPage(8);
        String checkBoxApple = chooseApple.getAttribute("@href");
        driver.get(checkBoxApple);
        waitToLoadPage(8);
    }

    public void goToNextPage() {
        goToNextPage.click();
        waitToLoadPage(8);
    }

    public List<WebElement> getListOfWebElement() {
        return listOfWebElement;
    }
    public static void waitToLoadPage(int i){
        try {
            Thread.sleep(i*1000);
        }  catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
