import PageModels.PageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.closeWindow;

public class FacebookTestSample extends PageObject {

    @FindBy(xpath = "//a[@role = 'button' and text() = 'Create New Account']")
    private static SelenideElement btnGoogleSearch;

    public FacebookTestSample(){
        super(FacebookTestSample.class, "https://www.facebook.com/");
        btnGoogleSearch.shouldBe(Condition.enabled, Duration.ofMillis(5000)).click();

        closeWindow();
    }
}
