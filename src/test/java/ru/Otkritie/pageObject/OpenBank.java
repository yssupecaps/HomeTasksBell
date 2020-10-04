package ru.otkritie.pageObject;

import Service.Basis;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenBank extends Basis {

    private String selectorExchangeRates = "//*[@class='main-page-exchange main-page-info__card']";
    private String selectorTableHeaders=".//tbody/tr[contains(@class,'header')]/td";
    private String selectorTableRows = ".//tbody/tr[contains(@class,'row')]";

    private WebDriver driver;

    private WebElement exchangeRates;
    private List<Map<String,String>> collectExchangeRates = new ArrayList<>();

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getExchangeRates() {
        return exchangeRates;
    }

    private String openURL="https://www.open.ru/";

    public OpenBank(WebDriver driver){
        this.driver=driver;
        if(!driver.getTitle().contains("Открытие"))
            driver.get(openURL);
        exchangeRates= driver.findElement(By.xpath(selectorExchangeRates));

    }

    public List<Map<String, String>> getCollectExchangeRates() {
        List<WebElement> tableHeaders = exchangeRates.findElements(By.xpath(selectorTableHeaders));
        List<WebElement> tableRows = exchangeRates.findElements(By.xpath(selectorTableRows));

        for(int i=0;i<tableRows.size();++i){
            Map<String,String> collectRow = new HashMap<>();
            for (int j=0;j<tableHeaders.size();++j){
                collectRow.put(
                        tableHeaders.get(j).getText(),
                        tableRows.get(i).findElement(By.xpath("./td["+(j+1)+"]")).getText()
                );
            }
            collectExchangeRates.add(collectRow);
        }

        return collectExchangeRates;
    }

}

