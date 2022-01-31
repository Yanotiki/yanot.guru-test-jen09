package yanot.guru.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponents {
    private final SelenideElement
            dateInput = $("#dateOfBirthInput"),
            selectMonth = $(".react-datepicker__month-select"),
            selectYear = $(".react-datepicker__year-select");

    public void setDate(String month, String year, String day) {
        dateInput.click();
        selectMonth.selectOptionByValue(month);
        selectYear.selectOptionByValue(year);
        $$(".react-datepicker__day").find(text(day)).click();
    }
}
