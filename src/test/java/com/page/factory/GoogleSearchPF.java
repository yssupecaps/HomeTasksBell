package com.page.factory;

import Service.Basis;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class GoogleSearchPF extends Basis {


    @FindBy(how = How.XPATH, using = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")
    WebElement inputField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")
    WebElement searchButton;

    @FindAll(@FindBy(how = How.XPATH, using = "//*[@class=\"LC20lb DKV0Md\"]"))
    List<WebElement> searchResult;

    public GoogleSearchPF(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getSearchResult() {
        return searchResult;
    }

    public void findWord(String word) {
        inputField.click();
        inputField.sendKeys(word);
        searchButton.click();
    }
}