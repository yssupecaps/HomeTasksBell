package com.page.object;

import Service.Basis;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPO extends Basis {

  private  WebElement inputField;
//  private WebElement searchButton;
    private List<WebElement> result;


    private String selectorInputField = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input";
//  private String selectorInputButton = "//*[@id=\\\"tsf\\\"]/div[2]/div[1]/div[3]/center/input[1]";
    private String selectorListElement = "h3.LC20lb.DKV0Md";





    public List<WebElement> getSearchResult() {
        return result;
    }

    public GoogleSearchPO(WebDriver driver) {
        this.driver = driver;
        driver.get(baseUrl);
        inputField = driver.findElement(By.xpath(selectorInputField));
     //   searchButton = driver.findElement(By.xpath(selectorSearchButton));
    }

    public void findWord(String word) {
        inputField.click();
        inputField.sendKeys(word);
        inputField.submit();
        // to emulate Button also could use searchButton.click();
    }

    public void getListElement() {
        result = driver.findElements(By.cssSelector(selectorListElement));
    }
}

