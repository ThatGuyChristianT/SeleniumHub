import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;

public class Sandbox {

    @FindBy(xpath = "//a[@role = 'button' and text() = 'Create New Account']")
    private static SelenideElement btnGoogleSearch;
    @FindBy(xpath = "//input[@placeholder = 'First name' or @aria-label = 'First name']")
    private static SelenideElement inFirstName;
    @FindBy(xpath = "//input[@placeholder = 'Last name' or @aria-label = 'Last name']")
    private static SelenideElement inLastName;
    @FindBy(xpath = "//input[@placeholder = 'New password' or @aria-label = 'New password']")
    private static SelenideElement inNewPassword;
    @FindBy(xpath = "//input[@placeholder = 'Mobile number or email' or @aria-label = 'Mobile number or email']")
    private static SelenideElement inEmail;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver.exe");
        open("https://www.facebook.com/");
        Sandbox sandBox = page(Sandbox.class);

        btnGoogleSearch.shouldBe(Condition.enabled, Duration.ofMillis(5000)).click();
        inFirstName.shouldBe(Condition.enabled, Duration.ofMillis(5000)).sendKeys("Christian");
        inLastName.shouldBe(Condition.enabled, sandBox.getMilliseconds(5)).sendKeys("Test123");
        inNewPassword.shouldBe(Condition.enabled, sandBox.getMilliseconds(5)).sendKeys("123GuessMe");
        inEmail.shouldBe(Condition.enabled, sandBox.getMilliseconds(5)).sendKeys("ChristianTest@gmail.com");

        sleep(10000);

        closeWindow();
    }

//
//    private void waitUntilConditionIsMet(SelenideElement selenideElement, Duration secondsToWait, String... strOfExpectedConditions) {
//        for (String expectedCondition : Arrays.asList(strOfExpectedConditions) {
//            Condition convertedCondition = convertToConditions(expectedCondition);
//            selenideElement.shouldBe(convertToConditions(expectedCondition), secondsToWait);
//        }
//
//    }
//
//    @NotNull
//    public Condition convertToConditions(@NotNull String condition) throws IllegalAccessException {
//        switch (condition.toUpperCase(Locale.ENGLISH)) {
//            case ENABLED:
//                return Condition.enabled;
//            case DISABLED:
//                return Condition.disabled;
//            case VISIBLE:
//                return Condition.visible;
//
//            default:
//                throw new IllegalAccessException("You dumb");
//        }
//    }

    private Duration getMilliseconds(int seconds) {
        return Duration.ofSeconds(seconds);
    }
}
