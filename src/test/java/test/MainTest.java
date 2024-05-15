package test;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import model.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

@Epic(value = "Тестовое задание 1")
@Feature(value = "Фича 1")
@Story(value = "US-1")
public class MainTest extends BaseTest {

    final String FULL_NAME = "Иванов Иван Иванович";
    final String E_MAIL = "Ivanov@gmail.com";
    final String CURRENT_ADDRESS = "Moscow";
    final String PERMANENT_ADDRESS = "Moscow";

    List<String> list = List.of(FULL_NAME, E_MAIL, CURRENT_ADDRESS, PERMANENT_ADDRESS);

    @Test(groups = "smoke")
    @Description(value = "Проверить, что данные в блоке сохранены корректно.")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Кто создал тест")
    @Link(name = "Website", url = "https://demoqa.com/")
    @Issue("AUTH-123")
    @TmsLink(value = "TMS-456")
    public void dataSaveCorrectlyDemoqaTest() {

        List<String> currentFiled = new HomePage(getDriver())
                .clickElementCard()
                .clickTextBox()
                .fillUserForm(FULL_NAME, E_MAIL, CURRENT_ADDRESS, PERMANENT_ADDRESS)
                .clickSubmit()
                .getListAnswerBlock();

        Assert.assertEquals(currentFiled, list, " The data is not saved correctly");



     /* WebElement massageRightClickMe= driver.findElement(By.xpath("//p[text()='You have done a right click']"));
      massageRightClickMe.;

      Assert.assertEquals(massageRightClickMe.getText(),
              "You have done a right click",
              "Текст не появился");

      String massageDoubleClickMe= driver.findElement(By.xpath("//p[text()='Double Click Me']")).getText();

      Assert.assertEquals(massageDoubleClickMe,
              "Double Click Me",
              "Текст не появился");
*/
    }

    @Test
    public void textIsVisibleDemoqaTest() {
//      driver.findElement(By.id("item-4")).click();
//      driver.findElement(By.xpath("(//button[@type='button'])[last()]")).click();
//
//      WebElement massageClickMe= driver.findElement(By.xpath("//p[text()='You have done a dynamic click']"));
//      massageClickMe.click();
//
//      Assert.assertEquals(massageClickMe.getText(), "You have done a dynamic click", "Текст не появился");

        String visibleText = new HomePage(getDriver())
                .clickElementCard()
                .clickButtons()
                .clickClickMeButton()
                .getTextAfterClickMe();

        Assert.assertEquals(visibleText, "You have done a dynamic click", "Текст не появился");
    }
}
