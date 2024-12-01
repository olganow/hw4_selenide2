import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class GitHubTest {

    @BeforeEach
    void beforeEach() {
        open("https://github.com/");
    }

    @Test
    void successfulNavigationToEnterprizePageWithCssTest() {
        $$("button").findBy(text("Solution")).hover();
        $("a[href='https://github.com/enterprise']").click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" +
                "developer platform"));
    }

    @Test
    void successfulNavigationToEnterprizePageWithXpathTest() {
        $x("//button[contains(text(),'Solution')]").hover();
        $x("//a[@href='https://github.com/enterprise']").click();
        $x("//*[@id='hero-section-brand-heading']").shouldHave(text("The AI-powered\n" +
                "developer platform"));
    }
}
