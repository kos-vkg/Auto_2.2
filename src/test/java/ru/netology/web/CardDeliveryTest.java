package ru.netology.web;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import  java.time.*;
import java.time.temporal.*;
import java.util.Date;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class CardDeliveryTest {


    @Test
    void shouldHappyPath() {
        LocalDate now = LocalDate.now();
        Date date = java.sql.Date.valueOf(now);
        open("http://localhost:9999");
        $(" [data-test-id='city'] input").setValue("Пермь");
        $(" [data-test-id='date'] input").setValue("21022021");
        $(" [data-test-id='date'] input,[type=\"tel\"]").val("java.sql.Date.valueOf(now)");
        $("[data-test-id='name'] input").setValue("Павел Савин");
        $("[name=\"phone\"]").setValue("+12345678901");
        $("[data-test-id=\"agreement\"]").click();
        $$("[type='button']").findBy(cssClass("button") ).click();
        $(withText("Успешно!")) .shouldBe(visible, Duration.ofSeconds(15));
    }
}
