package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BaseModel {

    @FindBy(xpath = "//*[@id='app']/div/div/div[2]/div/div[1]")
    private WebElement elementCard;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ElementPage clickElementCard() {

        getWait5().until(ExpectedConditions.visibilityOf(elementCard));
        elementCard.click();

        return new ElementPage(getDriver());
    }
}

