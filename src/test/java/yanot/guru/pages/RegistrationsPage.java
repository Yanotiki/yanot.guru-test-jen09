package yanot.guru.pages;

import com.codeborne.selenide.SelenideElement;
import yanot.guru.pages.components.CalendarComponents;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationsPage {
    public CalendarComponents calendar = new CalendarComponents();

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            fromTitle = $(".practice-form-wrapper"),
            firstNameInput = $("[id=firstName]"),
            lastNameInput = $("[id=lastName]"),
            userEmailInput = $("#userEmail"),
            userUserNumber = $("#userNumber"),
            genderRadioButton = $("[for=gender-radio-2]"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckboxInput = $("[for=hobbies-checkbox-3]"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            sityInput = $("#react-select-4-input"),
            pressSubmit = $("#submit"),
            resultsTable = $(".table-responsive");



    //открытие формы
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        fromTitle.shouldHave(text(FORM_TITLE));
    }
    //заполнение имени
    public RegistrationsPage tapeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    //заполнение фамилии
    public RegistrationsPage tapeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    //заполнение email
    public RegistrationsPage tapeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    //выбор пола
    public RegistrationsPage tapeGender() {
        genderRadioButton.click();
        return this;
    }
    //заполнение имени
    public RegistrationsPage tapeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    //выбор субъекта
    public RegistrationsPage tapeSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    //выбор хобби
    public RegistrationsPage tapeHobbiesCheckBox() {
        hobbiesCheckboxInput.click();
        return this;
    }
    //загрузка файла
    public RegistrationsPage tapeUploadPicture() {
        uploadPicture.uploadFromClasspath("error.jpg");
        return this;
    }
    //заполнение адреса
    public RegistrationsPage tapeAddress(String value) {
        addressInput.setValue(value);
        return this;
    }
    //выбор штата
    public RegistrationsPage tapeState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }
    //выбор города
    public RegistrationsPage tapeSity(String value) {
        sityInput.setValue(value).pressEnter();
        return this;
    }
    //нажатие кнопки "Подтвердить"
    public RegistrationsPage tapeSubmit() {
        pressSubmit.pressEnter();
        return this;
    }
    //проверка результатов
    public RegistrationsPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
}
