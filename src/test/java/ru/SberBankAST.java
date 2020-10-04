package com.sberbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SberBankAST {

    private  WebDriver driver;
    private  WebElement menuBar;
    public WebElement topMenu;
    private  Map<String, Map<String, String>> menu = new HashMap<>();


    private String sberUrl="https://www.sberbank-ast.ru/";
    private String selectorMasterMenu="//*[@class='master_open_menu']";
    private String selectorElementsMenu="//li//span";

    public SberBankAST(WebDriver driver) {
        this.driver = driver;
        this.driver.get(sberUrl);
        this.menuBar = driver.findElement(By.xpath(selectorMasterMenu));
    }
    //навигация по элементам меню
    public void goPage(String mainMenu,String subMenu) {
        driver.findElements(By.xpath("//span[contains(text(),'" + mainMenu + "')]//parent::li"));
        String pageLink= topMenu.findElement(By.xpath("//a[contains(text(), '" + subMenu + "')]")).getText();
        driver.get(pageLink);
    }
    //сборка меню
    public void collectMenu() {
        Map<String, List<WebElement>> masterMenu = new HashMap<>();
        menuBar.findElements(By.xpath(selectorElementsMenu))
                .forEach(x -> masterMenu.put(x.getText(), x.findElements(By.xpath
                        ("//*[contains(text(), '" + x.getText() + "')]//parent::li//a[@href]"))));

        masterMenu.forEach((top, sub) -> {
            Map<String, String> temp = sub.stream()
                    .collect(Collectors.toConcurrentMap
                            (x -> x.getAttribute("innerHTML"), x -> x.getAttribute("href")));
            menu.put(top, temp);
        });
     //отображение пунктов меню и подменю
        for (Map.Entry<String, Map<String, String>> entry : menu.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
            }
        }

}
