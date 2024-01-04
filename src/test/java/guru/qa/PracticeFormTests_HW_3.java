package guru.qa;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests_HW_3 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1300";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fill_PracticeFormTests() {
        open("/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("petrov@mail.ru");
        $("#genterWrapper").$(byText("Male")).click(); //RadioButton
        $("#userNumber").setValue("9031235577");

//******************Date from calendar****************************************************
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--026").click();
//****************************************************************************************

        $("#subjectsInput").setValue("English").pressEnter();//auto-complete string
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#subjectsInput").setValue("History").pressEnter();

//********************CheckBox************************************************************
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
//****************************************************************************************

//*********************UpLoad picture***************************************************
        $("#uploadPicture").uploadFromClasspath("snowman.jpg");
//****************************************************************************************

        $("#currentAddress").setValue("Moscow city");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();

        $("#submit").click();

//***********************Check*************************************************************
        $(".table").shouldHave(text("Alex Petrov"));
        $(".table").shouldHave(text("petrov@mail.ru"));
        $(".table").shouldHave(text("Male"));
        $(".table").shouldHave(text("9031235577"));
        $(".table").shouldHave(text("26 September,1995"));
        $(".table").shouldHave(text("English, Biology, History"));
        $(".table").shouldHave(text("Sports"));
        $(".table").shouldHave(text("Reading"));
        $(".table").shouldHave(text("Music"));
        $(".table").shouldHave(text("snowman.jpg"));
        $(".table").shouldHave(text("Moscow city"));
        $(".table").shouldHave(text("NCR Gurgaon"));

    }
}