package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public abstract class BaseTest {

   private WebDriver driver;

//    private WebDriverWait wait5;

//    private void startDriver() {
//        driver = new ChromeDriver();
//        driver.get("https://demoqa.com/");
//    }

//    @BeforeClass
//    protected void beforeClass() {
//        System.out.println("Перед классаом");
//        System.out.println(getClass());
//    }
//
//    @AfterClass
//    protected void afterClass() {
//        System.out.println("После класса");
//        System.out.println(getClass());
//    }
//
//    @BeforeSuite
//    protected void beforeSuite() {
//        System.out.println("Перед каждым сьютом");
//    }

    @BeforeMethod
    protected void beforeMethod(Method method) {
        System.out.println("Перед каждым методом");
        System.out.println(method.getName());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        System.out.println(driver.getCurrentUrl());
//        startDriver();
//        System.out.println(driver);
    }

//    @BeforeTest(alwaysRun = true)
//    protected void beforeTest() {
//
//        System.out.println("Перед каждым тестом");
//
//        startDriver();
//        driver.get("https://demoqa.com/");
//    }

    @AfterMethod
    protected void afterMethod(Method method) {
        System.out.println("После каждого метода");
        System.out.println(method.getName());
        driver.quit();
    }

    protected WebDriver getDriver() {
        System.out.println(driver.getCurrentUrl());
        return driver;
    }
}
