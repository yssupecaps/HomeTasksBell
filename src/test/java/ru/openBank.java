package ru;

import Service.Basis;
import com.page.object.GoogleSearchPO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class openBank extends Basis {

    private String selectorBuyDollar ="tr:nth-child(2)>td:nth-child(2) span";
    private String selectorSaleDollar ="tr:nth-child(2)>td:nth-child(4) span";

    @Test
    //just check efficiency
    //заведомо ложный тест
    public void firstTest(){
        driver.get(baseUrl);
        String title = driver.getTitle();
        System.out.println(title);
        Assertions.assertFalse(title.equals("Google"),"Условие выполнилось с ошибкой");
    }

    @Test
    public void dollarBuyMoreThanSale()  {
        driver.get(baseUrl);
      //  driver.navigate().to(baseUrl);
        GoogleSearchPO googleTest2 = new GoogleSearchPO(driver);
        googleTest2.findWord("Банк Открытие");
        googleTest2.getListElement();
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/div/cite")).click();
      //  driver.(openUrl);
        double dollarBuy = Double.parseDouble(driver.findElement(By.cssSelector(selectorBuyDollar))
                .getText().replace(",","."));
        double dollarSale = Double.parseDouble(driver.findElement(By.cssSelector(selectorSaleDollar))
                .getText().replace(",","."));
        Assertions.assertFalse(dollarBuy  > dollarSale );
    }
}
