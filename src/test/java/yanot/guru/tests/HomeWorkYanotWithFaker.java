package yanot.guru.tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import com.github.javafaker.Faker;
import java.util.Locale;

public class HomeWorkYanotWithFaker extends TestBase {

    Faker faker = new Faker(new Locale("ru"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String streetAddress = faker.address().streetAddress();
    String userEmail = faker.internet().emailAddress("en");
    String userNumber = faker.phoneNumber().subscriberNumber(10);

    @Test
    void fillFormTest() {
        // Заполнение формы
        registrationsPage.openPage();
        registrationsPage.tapeFirstName(firstName)
                .tapeLastName(lastName)
                .tapeUserEmail(userEmail)
                .tapeGender()
                .tapeUserNumber(userNumber)
                .calendar.setDate("3", "1986", "16");
        registrationsPage.tapeSubjectsInput("Hindi")
                .tapeHobbiesCheckBox()
                .tapeUploadPicture()
                .tapeAddress(streetAddress)
                .tapeState("NCR")
                .tapeSity("Delhi")
                .tapeSubmit();

        // Валидация
        registrationsPage
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", userEmail)
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", userNumber)
                .checkResultsValue("Date of Birth", "16 April,1986")
                .checkResultsValue("Subjects", "Hindi")
                .checkResultsValue("Hobbies", "Music")
                .checkResultsValue("Picture", "error.jpg")
                .checkResultsValue("Address", streetAddress)
                .checkResultsValue("State and City", "NCR Delhi");
    }
}
