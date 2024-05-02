import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import pageObject.*;


public class SignUpTest extends BaseTest {

    @Before
    public void setUp() {
        startUp("chrome");
    }

    @Test
    @DisplayName("SignUp: positive flow")
    @Description("Sign Up user: positive flow for successfully registration")
    public void registrationTest() {

        String name = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
        String password = RandomStringUtils.randomAlphabetic(10);

        signUpUser(name, email, password);
        signInUser(email, password);
        checkAccountData(name, email);


    }

    @Test
    @DisplayName("SignUp: incorrect password (less than 6 symbols)")
    @Description("Sign Up user: negative flow for unsuccessfully registration when password less than 6 symbols")
    public void registrationUnsuccessfullyIncorrectPasswordTest() {
        String name = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
        String password = RandomStringUtils.randomAlphabetic(4);

        signUpUser(name, email, password);

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.checkPasswordError();


    }
}
