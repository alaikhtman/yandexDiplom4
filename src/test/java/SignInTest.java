import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import pageObject.*;


public class SignInTest extends BaseTest {

    String name = RandomStringUtils.randomAlphabetic(10);
    String email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
    String password = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void setUp() {
        startUp("yandex");
        signUpUser(name, email, password);
        openMainPage();
    }

    @Test
    @DisplayName("SignIn: positive flow on profile")
    @Description("Sign in user: positive flow for successfully sign in on profile page")
    public void signInPrivateArea() {

        HeaderPage header = new HeaderPage(driver);
        header.clickProfileButton();
        signInUser(email, password);
        checkAccountData(name, email);

    }

    @Test
    @DisplayName("SignIn: positive flow on main page")
    @Description("Sign in user: positive flow for successfully sign in on main page")
    public void signInMainPage() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignInButton();

        signInUser(email, password);
        checkAccountData(name, email);


    }

    @Test
    @DisplayName("SignIn: positive flow on sign up page")
    @Description("Sign in user: positive flow for successfully sign in on sign up page")
    public void signInSignUp() {

        HeaderPage header = new HeaderPage(driver);
        header.clickProfileButton();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickSignUpButton();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickSignInButton();

        signInUser(email, password);
        checkAccountData(name, email);

    }

    @Test
    @DisplayName("SignIn: positive flow on restore password page")
    @Description("Sign in user: positive flow for successfully sign in on restore password page")
    public void signInRestorePassword() {

        HeaderPage header = new HeaderPage(driver);
        header.clickProfileButton();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickPasswordRestoreButton();

        RestorePasswordPage restorePasswordPage = new RestorePasswordPage(driver);
        restorePasswordPage.clickSignInButton();

        signInUser(email, password);
        checkAccountData(name, email);

    }
}
