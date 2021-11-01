package PageModels;


import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class PageObject {

    public PageObject(@NotNull Object pageClass, String url){
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver.exe");
        page(pageClass.getClass());
        open(url);
    }
}
