package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(xpath = "//a[contains(@href,'ru.lipsum.com')]")
    private WebElement RUSSIAN_LANG;

    @FindBy(xpath = "//p[contains(text(), \" - это текст-\")]")
    private WebElement SearchFirstParagraphs;

    @FindBy(xpath = "//*[@id = \"generate\"]")
    private WebElement GenerateButton;

    @FindBy(xpath = "//*[@id = \"words\"]")
    private WebElement WORDS_INPUT;

    @FindBy(xpath = "//*[@id = \"amount\"]")
    private WebElement AMOUNT_INPUT;

    @FindBy(xpath = "//*[@id = \"bytes\"]")
    private WebElement BYTES_INPUT;

    @FindBy(xpath = "//*[@id = \"start\"]")
    private WebElement START_INPUT;


    public void openHomePage(String url) {
        driver.get(url);
    }


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void changeLang() {
        RUSSIAN_LANG.click();


    }

    public String getSearchResultsFirstParagraph() {
        return SearchFirstParagraphs.getText();
    }

    public void clickOnGenerateButton() {
        GenerateButton.click();
    }


    public void clickOnWordsInput() {
        WORDS_INPUT.click();
    }

    public void clickOnAmountInput( final String  amount ) {
        AMOUNT_INPUT.clear();
        AMOUNT_INPUT.sendKeys(amount);
    }

    public void clickOnBytesInput() {
        BYTES_INPUT.click();
    }

    public void clickOnStartInput() {
        START_INPUT.click();
    }

}

