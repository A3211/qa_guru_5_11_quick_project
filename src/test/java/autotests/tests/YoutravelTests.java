package autotests.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class YoutravelTests extends TestBase {

    @Test
    @DisplayName("Successful open youtravel.me")
    void openMainPageTest() {
        step("Open https://youtravel.me/", () -> {
            open("https://youtravel.me/");
            $("body").shouldHave(Condition.text("GROUP TOURING AS PERSONAL AS NEVER BEFORE"));
        });
    }

    @Test
    @DisplayName("Successful change language to Russian")
    void changeLanguageTest() {
        step("Open https://youtravel.me/", () -> {
            open("https://youtravel.me/");
            $("body").shouldHave(Condition.text("GROUP TOURING AS PERSONAL AS NEVER BEFORE"));
        });

        step("Change language to Russian", () -> {
            SelenideElement languageMenu = $(byText("Language"));
            actions().moveToElement(languageMenu).perform();
            $(byText("Russian (Русский)")).click();
            $("body").shouldHave(Condition.text("АВТОРСКИЕ ТУРЫ — НОВЫЙ ФОРМАТ НАСЫЩЕННЫХ ПУТЕШЕСТВИЙ"));
        });
    }

    @Test
    @DisplayName("Successful find a tour")
    void findTourTest() {
        Configuration.startMaximized = true;

        step("Open https://youtravel.me/", () -> {
            open("https://youtravel.me/");
            $("body").shouldHave(Condition.text("GROUP TOURING AS PERSONAL AS NEVER BEFORE"));
        });

        step("Choosing Arizona", () -> {
            $(byText("Where")).scrollIntoView(true).click();
            $(byText("Arizona")).scrollIntoView(true).click();
        });

        step("Choosing date", () -> {
            $(byText("When")).scrollIntoView(true).click();
            $(byText("Sep")).scrollIntoView(true).click();
        });

        step("Click find", () -> {
            $(".filter-main__send-btn").click();
        });

        step("Check Successful open page", () -> {
            $("body").shouldHave(Condition.text("Arizona"));
        });
    }

    @Test
    @DisplayName("Successful open youtravel.me")
    void openToursPageTest() {
        step("Open https://youtravel.me/", () -> {
            open("https://youtravel.me/");
            $("body").shouldHave(Condition.text("GROUP TOURING AS PERSONAL AS NEVER BEFORE"));
        });

        step("Open tours page", () -> {
            $(".header").$(byText("Tours")).click();
        });

        step("Check open tours page", () -> {
            $("body").shouldHave(Condition.text("My tours"));
        });
    }
}
