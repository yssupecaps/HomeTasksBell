package ru.yandex;

import Service.Basis;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class yandexMarketTests extends Basis {
@Test
    public void testYandexWithPageFactory() {
        PageFactoryYandex yandex = PageFactory.initElements(driver, PageFactoryYandex.class);
        yandex.goToPage();
        //выбираем фильтр по производителю
        yandex.checkBoxVendors("Apple",driver);
        //заранее после выбора фильтра открываем все возможные страницы
        yandex.goToNextPagesOfList();
        //cравнение полученного с искомым(памятка для правильного сравнения из-за чувствительности к регистру: Apple, iPhone)
        Assertions.assertTrue(yandex.getListOfWebElement().stream().allMatch(x->x.getText().contains("Apple")),"Неправильно отфильтрованно");

    }
}
