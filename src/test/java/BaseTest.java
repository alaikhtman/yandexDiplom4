import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.*;

import static config.Config.URL;

public class BaseTest {

    WebDriver driver;


    public void startUp(String browser) {

        switch (browser) {
            case "yandex":
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                driver.get(URL);
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(URL);
                break;
        }
    }

    @Step("Open main page")
    public void openMainPage() {
        driver.get(URL);
    }

    @Step("Sign up new user")
    public void signUpUser(String name, String email, String password) {
        HeaderPage header = new HeaderPage(driver);
        header.clickProfileButton();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickSignUpButton();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUpUser(name, email, password);
    }

    @Step("Sign in new user")
    public void signInUser(String email, String password) {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signInUser(email, password);
    }

    @Step("Check accounts data")
    public void checkAccountData(String name, String email) {
        HeaderPage header = new HeaderPage(driver);
        header.clickProfileButton();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.checkAccountsData(name, email);
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
