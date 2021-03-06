package yanot.guru.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import yanot.guru.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {
        String browser = System.getProperty("browser", "firefox");
        String version = System.getProperty("version", "90");
        String remoteUrl = System.getProperty("remoteUrl", "selenoid.autotests.cloud/wd/hub");
        String login = System.getProperty("login", "user1");
        String password = System.getProperty("password", "1234");

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = browser;
        Configuration.browserVersion = version;

        String url = "https://" + login + ":" + password + "@" + remoteUrl;

        Configuration.remote = url;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        getWebDriver().close();
    }
}
