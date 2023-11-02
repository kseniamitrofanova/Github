package github;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;



public class JUnitFound {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void FindJUnit5(){
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("[placeholder='Find a page…']").setValue("SoftAssertions").pressEnter();
        $("#wiki-pages-box").shouldHave(text("SoftAssertion"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").scrollIntoView(true);
        $("#user-content-3-using-junit5-extend-test-class").sibling(0).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
