package io.testomat.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    public final String baseContent = System.getProperty("isMobile") == null ? "#content-desktop " : "#content-mobile ";

    protected SelenideElement findElement(String selector){
        return $(baseContent + selector);
    }

}

