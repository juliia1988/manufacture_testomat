package io.testomat.web.pages;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{

    public LoginPage isLoaded(){
        findElement("h2").shouldHave(Condition.text("Sign in"));
        return this;
    }

    private void loginUser(String mail, String password) {
        fillEmail(mail);
        fillPassword(password);
        submitLogin();
    }

    public LoginPage submitLogin() {
        findElement(" [name='commit']").click();
        return this;
    }

    public LoginPage fillPassword(String password) {
        findElement(" #user_password").setValue(password);
        return this;
    }

    public LoginPage fillEmail(String mail) {
        findElement(" #user_email").setValue(mail);
        return this;
    }

    public void preloaderIsHidden(){
        $("app-loader").shouldBe(Condition.disappear, Duration.ofSeconds(10));
    }

}