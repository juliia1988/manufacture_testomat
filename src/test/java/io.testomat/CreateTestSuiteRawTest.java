package io.testomat;

import asserts.TestSuitesPageAsserts;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.testomat.web.pages.LoginPage;
import io.testomat.web.pages.ProjectsPage;
import io.testomat.web.pages.TestSuitesPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class CreateTestSuiteRawTest {

    Faker faker = new Faker();

    private final LoginPage loginPage = new LoginPage();

    static {
        Configuration.baseUrl = "https://uat.testomat.io";
    }

    @Test
    @DisplayName("Should be possible test suite for new project")
    void shouldBePossibleToCreateNewProject() {
        Selenide.open("/users/sign_in");
        loginPage
                .isLoaded()
                .loginUser(LoginPage.Creds.mail, LoginPage.Creds.password);

        var targetProjectTitle = faker.commerce().department();
        new ProjectsPage()
                .isLoaded()
                .clickOnNewProjectButton()
                .fillProjectTitle(targetProjectTitle)
                .submitProjectCreation();

        preloaderIsHidden();

        String targetTestSuite = faker.commerce().productName();

        new TestSuitesPage()
                .isLoaded()
                .closeReadmeModal()
                .fillFirstTestSuite(targetTestSuite);

        new TestSuitesPageAsserts()
                .listShouldHaveSize(1)
                .firstTestSuiteInListShouldHaveText(targetTestSuite);
    }

    private void preloaderIsHidden() {
        $("#app-loader").shouldBe(Condition.disappear, Duration.ofSeconds(30));
    }
}

