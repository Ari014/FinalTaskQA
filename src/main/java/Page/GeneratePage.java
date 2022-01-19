package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class GeneratePage extends BasePage {

    @FindBy(xpath = "//*[@id = \"lipsum\"]")
    private WebElement GenerateFirstParagraphs;

    @FindBy(xpath = "//*[@id = \"generated\"]")
    private WebElement GeneratedResults;

    @FindBy(xpath = "//*[@id = \"lipsum\"]/p")
    private List<WebElement>  ParagraphsList;

    public GeneratePage(WebDriver driver) {
        super(driver);
    }

    public String getSearchGenerateFirstParagraph() {
        return GenerateFirstParagraphs.getText();
    }

    public String  getSearchResultsGenerated() {
        return GeneratedResults.getText();
    }

    public List<WebElement> getSearchResultsParagraphsWithLipsumList() {
        return ParagraphsList;
    }
}