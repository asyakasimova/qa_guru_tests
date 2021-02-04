package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;


public class FormTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }


    @Test
    void checkFormFillTest() {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Asia");
        $("#lastName").setValue("Beta");
        $("#userEmail").setValue("a@a.com");
        $("#genterWrapper").find(byText("Male")).click();
        $("#userNumber").setValue("1111111111");
        //Calendar
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("January")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1991")).click();
        $(".react-datepicker__month").find(byText("25")).click();

        $("#subjectsInput").setValue("Mat");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").find(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("./src/test/resources/1.jpg"));
        $("#currentAddress").setValue("Test street 15");

        $("#state").click();
        $("#state").find(byText("Rajasthan")).click();
        $("#city").click();
        $("#city").find(byText("Jaipur")).click();
        $("#submit").click();


        $(".modal-content").shouldHave(text("Thanks for submitting the form"),
                text("Asia Beta"),
                text("a@a.com"),
                text("Male"),
                text("1111111111"),
                text("25 January,1991"),
                text("Math"),
                text("Reading"),
                text("Test street 15"),
                text("Rajasthan Jaipur"));


    }
}
