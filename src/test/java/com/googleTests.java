package com;

import Service.Basis;
import com.page.factory.GoogleSearchPF;
import com.page.object.GoogleSearchPO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class googleTests extends Basis {

    @Test
    public void GoogleSearchTest() {
        // to check efficiency
        driver.get(baseUrl);
        String tittle = driver.getTitle();
        Assertions.assertTrue(tittle.equals("Google"));
    }



    @Test
    public void googleTestPF() {
        driver.get(baseUrl);
        GoogleSearchPF googleTest1 = PageFactory.initElements(driver,GoogleSearchPF.class);
        googleTest1.findWord("гладиолус");
        Assertions.assertTrue(googleTest1.getSearchResult().stream().anyMatch(x->x.getText().contains("Шпажник — Википедия")),
                "Информация по запросу не найден");

    }

    @Test
    public void goggleTestPO() {
        driver.get(baseUrl);
        GoogleSearchPO googleTest2 = new GoogleSearchPO(driver);
        googleTest2.findWord("гладиолус");
        googleTest2.getListElement();
        Assertions.assertTrue(googleTest2.getSearchResult().stream().anyMatch(x -> x.getText().contains("Шпажник — Википедия")),
                "Информация по запросу не найден");
    }
}

