package ru.netology.web;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

import java.time.*;
import java.time.temporal.*;
import java.util.Date;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class CardDeliveryTest {


    @Test
    void shouldHappyPath() {
        String dateMeeting = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        open("http://localhost:9999");
        $(" [data-test-id='city'] input").setValue("Пермь");
        $(" [data-test-id='date'] input")
                .sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $(" [data-test-id='date'] input").setValue(dateMeeting);
        //$(" [data-test-id='date'] input,[type=\"tel\"]").val("java.sql.Date.valueOf(now)");
        $("[data-test-id='name'] input").setValue("Павел Савин");
        $("[name=\"phone\"]").setValue("+12345678901");
        $("[data-test-id=\"agreement\"]").click();
        $$("[type='button']").findBy(cssClass("button")).click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
        $(".notification__content")
                .shouldHave(text("Встреча успешно забронирована на "+ dateMeeting));
    }
}
