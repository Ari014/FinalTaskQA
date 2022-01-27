package stepdefinitions;

import Page.GeneratePage;
import Page.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    GeneratePage generatePage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {driver.close();}

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User switches to Russian language")
    public void userSwitchesToRussianLanguage() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.changeLang();
    }



    @Then("User checks that the text of the first  element, which is the first paragraph, contains {string}")
    public void CheckThatTheTextOfTheFirstElementWhichIsTheFirstParagraphContainsWord(final String word) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue( homePage.getSearchResultsFirstParagraph().contains(word));

    }


    @When("User clicks Generate Lorem Ipsum button")
    public void ClickGenerateLoremIpsumButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnGenerateButton();
    }

    @Then("User checks that the first paragraph starts with {string}")
    public void CheckThatTheFirstParagraphStartsWithText(final String text) {
        generatePage = pageFactoryManager.getGeneatePage();
        generatePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(generatePage.getSearchGenerateFirstParagraph().contains(text));
    }

    @And("User сlicks on Words button")
    public void СlickOnWordsButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnWordsInput();
    }

    @And("User enters {string} into the number field")
    public void EnterAmountIntoTheNumberField(final String amount) {
        homePage.clickOnAmountInput(amount);

    }

    @Then("User checks that the result has {string} words")
    public void CheckThatTheResultHasAmountOfWordsWords(final String amountOfWords) {
        generatePage = pageFactoryManager.getGeneatePage();
        generatePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(generatePage.getSearchResultsGenerated().contains(amountOfWords));
    }

    @And("User сlicks on Bytes button")
    public void СlickOnBytesButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnBytesInput();
    }

    @Then("User checks that the result has {string} bytes")
    public void CheckThatTheResultHasAmountBytes(final String amount) {
        generatePage = pageFactoryManager.getGeneatePage();
        generatePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(generatePage.getSearchResultsGenerated().contains(amount));
    }

    @And("User uncheck Start with Lorem Ipsum checkbox")
    public void UncheckStartWithLoremIpsumCheckbox() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnStartInput();
    }


    @Then("User checks that result no longer starts with {string}")
    public void CheckThatResultNoLongerStartsWithText(final String text) {
        generatePage = pageFactoryManager.getGeneatePage();
        generatePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertFalse(generatePage.getSearchGenerateFirstParagraph().contains(text));
    }

    @Then("User checks that result from each paragraph and determine the number of paragraphs containing the {string}")
    public void CheckThatResultFromEachParagraphContainingTheWord(final  String word) {
        generatePage = pageFactoryManager.getGeneatePage();
        int k = 0;
        for (WebElement webElement : generatePage.getSearchResultsParagraphsWithLipsumList()) {

            if (webElement.getText().contains(word)) {
                k++;
            }

        }
       generatePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(k > 2);
    }
}

