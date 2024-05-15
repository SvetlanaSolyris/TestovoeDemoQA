package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ElementPage extends BaseModel {

    @FindBy(id = "item-0")
    private WebElement textBox;

    @FindBy(id = "userName")
    private WebElement fullNameForm;

    @FindBy(id = "userEmail")
    private WebElement userMailForm;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressForm;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressForm;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;

    @FindBy(id = "name")
    private WebElement nameAnswerBlock;

    @FindBy(id = "email")
    private WebElement emailAnswerBlock;

    @FindBy(xpath = "//p[@id='currentAddress']")
    private WebElement currentAddressAnswerBlock;

    @FindBy(css = "p#permanentAddress")
    private WebElement permanentAddressAnswerBlock;

    @FindBy(id = "item-4")
    private WebElement buttonsFromElement;

    public ElementPage(WebDriver driver) {
        super(driver);
    }

    public ElementPage clickTextBox() {
        textBox.click();

        return this;
    }

    public ElementPage fillUserForm(String fullName, String e_mail, String currentAddress, String permanentAddress) {
        fullNameForm.sendKeys(fullName);
        userMailForm.sendKeys(e_mail);
        currentAddressForm.sendKeys(currentAddress);
        permanentAddressForm.sendKeys(permanentAddress);

        return this;
    }

    public ElementPage clickSubmit() {
        submitButton.click();

        return this;
    }

    public List<String> getListAnswerBlock() {
        String [] fullName = nameAnswerBlock.getText().split(":");
        String [] email = emailAnswerBlock.getText().split(":");
        String [] currentAddress =  currentAddressAnswerBlock.getText().split(":");
        String [] permanentAddress = permanentAddressAnswerBlock.getText().split(":");

        List<String> currentFiled = List.of(fullName[1], email[1], currentAddress[1], permanentAddress[1]);

        return currentFiled;
    }

    public ButtonsPage clickButtons() {
        buttonsFromElement.click();

        return new ButtonsPage(getDriver());
    }
}
