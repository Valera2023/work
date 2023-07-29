package guru.qa;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class FirstTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void StudentRegistrationForm() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivan@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $("select.react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day.react-datepicker__day--031").click();

        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("Panda.jpg");
        $("#currentAddress").setValue("Moscow 111");
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-0").click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("Ivan@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("31 May,1990"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("Panda.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Moscow 111"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Agra"));

        $("#closeLargeModal").click();

    }
}
