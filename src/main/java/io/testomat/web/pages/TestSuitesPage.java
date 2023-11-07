package io.testomat.web.pages;

import asserts.TestSuitesPageAsserts;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TestSuitesPage extends BasePage {

    String firstTestSuiteSelector = "[placeholder='%s']";
    private SelenideElement firstTestSuite = $("[placeholder='First Suite']");
    protected String suitesListItem = ".list-group-wrapper .dragSortItem";


    public TestSuitesPage isLoaded() {
        firstTestSuite.shouldBe(Condition.visible, Duration.ofSeconds(30));
        return this;
    }

    public TestSuitesPage closeReadmeModal() {
        $(".back").click();
        return this;
    }

    public TestSuitesPage fillFirstTestSuite(String targetTestSuite) {
        firstTestSuite.setValue(targetTestSuite).pressEnter();
        return null;
    }

    //just for exapmle
    public TestSuitesPage fillSecondTestSuiteName(String targetTestSuite) {
        $(String.format(firstTestSuiteSelector, "First Suite")).setValue(targetTestSuite);
        return null;
    }

    //just for exapmle
    public TestSuitesPage fillThirdTestSuiteName(String targetTestSuite) {
        $(Selectors.by("[placeholder", "First Suite")).setValue(targetTestSuite);
        return null;
    }
}
