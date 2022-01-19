package manager;

import Page.GeneratePage;
import Page.HomePage;
import Page.RadioButton;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public GeneratePage getGeneatePage() {
        return new GeneratePage(driver);
    }

    public RadioButton getRadioButton() {
        return new RadioButton(driver);
    }



}
