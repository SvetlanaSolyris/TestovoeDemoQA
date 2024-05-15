package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BaseModel {

    @FindBy(xpath = "(//button[@type='button'])[last()]")
    private WebElement clickMeButton;

    @FindBy(id = "dynamicClickMessage")
    private WebElement textAfterClickMe;

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public ButtonsPage clickClickMeButton() {
        clickMeButton.click();

        return this;
    }

    public String getTextAfterClickMe() {

        return textAfterClickMe.getText();
    }
}
