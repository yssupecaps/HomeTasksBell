
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
 
    @FindBy(how = How.XPATH, using="//button[contains(text(),'Показать ещё')]")
    WebElement goToNextPage;
    
    @FindAll(@FindBy(how = How.XPATH,using = "//a[@class='_27nuSZ19h7 wwZc93J2Ao cia-cs']//span"))
     List<WebElement> listOfWebElement;
    
    
    //переход на первичную страницу
    public PageFactoryYandex(WebDriver driver) {
        this.driver = driver;
        driver.get(url);
        waitToLoadPage(6);
    }
    //переход по разделам :Электроника->Смартфоны
    public void goToPage(){
        goToElectronics.click();
        waitToLoadPage(6);
        goToSmartphones.click();
        waitToLoadPage(6);
    }
  
  //выбираем фильтрацию по производителю(в любом другом случае показывает ошибку, что элемент не кликабелен)
    public void checkBoxVendors(String name, WebDriver driver){
        String checkBoxXpath = "//input[@name=\"Производитель " + name + "\"]";
            WebElement selectElement = driver.findElement(By.xpath(checkBoxXpath));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", selectElement);
    }
    
     //открываем всевозможные страницы
    public void goToNextPagesOfList() {
        goToNextPage.click();
        waitToLoadPage(6);
    }
      //cобираем в список названия
    public List<WebElement> getListOfWebElement() {
        return listOfWebElement;
    }
    
  
    //ожиданием пока страница полностью загрузится
    public static void waitToLoadPage(int i){
        try {
            Thread.sleep(i*1000);
        }  catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
