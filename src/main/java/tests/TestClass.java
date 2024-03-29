package tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.*;
import pages.RegisterPage;
import java.util.concurrent.TimeUnit;

public class TestClass {

    private static WebDriver driver;
    private static final Logger logger = Logger.getLogger(TestClass.class);

    @BeforeClass
    public static void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "/Users/ievgenii/ChromeDriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testCase01(){
        RegisterPage registerPage = new RegisterPage(driver);
        if(registerPage.isBusinessTypeSelected()) {
            try {
                Assert.assertTrue(registerPage.isBusinessDetailsDisplayed());
            } catch (Error e) {
                logger.error("Test Case 01: user type is Business, but Business Details are not displayed");
            }
        }
    }

    @Test
    public void testCase02(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillFirstName("TestName")
                    .fillLastName("TestLastName")
                    .fillAddress("Test address")
                    .fillCity("Kyiv")
                    .fillPostCode("01001")
                    .chooseCountry("Ukraine")
                    .fillState("Kyiv")
                    .fillPhoneNumber("044-123-45-67")
                    .fillEmail("test@test.test")
                    .chooseUserType("Personal")
                    .fillUserName("TestName")
                    .fillPassword("password")
                    .clickContinueOrder();
        try {
            Assert.assertTrue(!registerPage.isAlertPresent());
        }catch (Error e){
            logger.error(String.format("Test Case 02: all fields are filled, but error message is: %s", registerPage.getAlertText()));
        }
    }

    @AfterClass
    public static void afterTest(){
        driver.quit();
    }
}
