package ru;

import Service.Basis;
import com.page.object.GoogleSearchPO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class openBank extends Basis {

    @Test
    public void openTest() {
        GoogleSearch googleSearch = new GoogleSearch(driver, "Открытие");
        List<Map<String, Object>> resultSearch = googleSearch.getCollectResults();
        //resultSearch.stream().forEach(x-> System.out.println(x.get("DESCRIPTION").toString()));
        googleSearch.goPage("Банк «Открытие» — вклады, кредитные и дебетовые");
        OpenBank open = new OpenBank(driver);
        List<Map<String, String>> collectExchangeRates = open.getCollectExchangeRates();
        System.out.println(collectExchangeRates.size());
        System.out.println(collectExchangeRates);

        Assertions.assertTrue(
                Double.parseDouble(
                        collectExchangeRates.stream()
                                .filter(x -> x.get("Валюта обмена").contains("USD"))
                                .findFirst()
                                .get().get("Банк покупает").replace(",", "."))
                        <
                        Double.parseDouble(
                                collectExchangeRates.stream()
                                        .filter(x -> x.get("Валюта обмена").contains("USD"))
                                        .findFirst()
                                        .get().get("Банк продает").replace(",", "."))
        );

    }

    @Test
    public void openTestWithSteps() {
        GoogleSearch googleSearch = new GoogleSearch(driver, "Открытие");
        List<Map<String, Object>> resultSearch = googleSearch.getCollectResults();
        Steps.checkContainsName(resultSearch, "Банк «Открытие» — вклады, кредитные и дебетовые", driver);
        Steps.goPageText(googleSearch, "Банк «Открытие» — вклады, кредитные и дебетовые");
    }
}
