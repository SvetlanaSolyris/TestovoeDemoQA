package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver;

//    private WebDriverWait wait5;

    static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        return driver;
    }

    private void startDriver() {
        driver = createDriver();
    }

    @BeforeClass
    protected void beforeClass() {
        System.out.println("Перед классаом");
        System.out.println(getClass());
    }

    @AfterClass
    protected void afterClass() {
        System.out.println("После класса");
        System.out.println(getClass());
    }

    @BeforeSuite
    protected void beforeSuite() {
        System.out.println("Перед каждым сьютом");
    }

    @BeforeMethod(alwaysRun = true)
    @Step("Инициализация браузера")
    protected void beforeMethod(Method method) {
        System.out.println("Перед каждым методом");
        System.out.println(method.getName());

        startDriver();
        driver.get("https://demoqa.com/");
        System.out.println(driver);
        System.out.println("Драйвер инициализирован: " + driver);
    }

    @BeforeTest(alwaysRun = true)
    protected void beforeTest() {

        System.out.println("Перед каждым тестом");

    }

    @AfterMethod(alwaysRun = true)
    protected void afterMethod(Method method) {
        System.out.println("После каждого метода");
        System.out.println(method.getName());
        if (driver != null) {
            driver.quit();
        }
    }

    @Step("Получение драйвера")
    protected WebDriver getDriver() {

        if (driver != null) {
            System.out.println("Текущий URL: " + driver.getCurrentUrl());
        }
        return driver;
    }
}
