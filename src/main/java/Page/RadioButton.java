package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButton extends BasePage {

    @FindBy(xpath = "//*[@id = \"words\"]")
    private WebElement WORDS_INPUT;

    @FindBy(xpath = "//*[@id = \"amount\"]")
    private WebElement AMOUNT_INPUT;

    @FindBy(xpath = "//*[@id = \"bytes\"]")
    private WebElement BYTES_INPUT;

    @FindBy(xpath = "//*[@id = \"start\"]")
    private WebElement START_INPUT;
    // final String RADIO_BUTTON = "//*[@type = \"radio\"]";

    public RadioButton(WebDriver driver) {
        super(driver);
    }

    public void SetValue(String value)
    {

        if ( value == "words") WORDS_INPUT.click();
        if ( value == "amount") AMOUNT_INPUT.click();
        if ( value == "bytes") BYTES_INPUT.click();
        if ( value == "start") START_INPUT.click();

    }


}
