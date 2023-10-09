package io.testomat.web.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class TestSuitePage extends BasePage {

    String firstTestSuiteSelector = "[placeholder='%s']";

    public TestSuitePage isLoaded() {
        findElement("[placeholder='First Suite']").shouldBe(Condition.visible);
        return this;
    }
    public TestSuitePage closeReadmeModal() {
        findElement(".back").click();
        return this;
    }

    public TestSuitePage fillFirstTestSuiteName(String targetTestSuite) {
        $(String.format(firstTestSuiteSelector, "First Suite")).setValue(targetTestSuite);
        return null;
    }


}
