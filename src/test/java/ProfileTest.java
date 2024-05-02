import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import pageObject.SignInPage;
import pageObject.MainPage;
import pageObject.HeaderPage;
import pageObject.ProfilePage;

public class ProfileTest extends BaseTest {

    String name = RandomStringUtils.randomAlphabetic(10);
    String email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
    String password = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void setUp() {
        startUp("yandex");
        signUpUser(name, email, password);
        signInUser(email, password);
    }

    @Test
    @DisplayName("Profile: profile -> main page by logotype")
    @Description("Profile: transition from profile to main page by logotype")
    public void fromPrivateAreaToMainPageByLogotypeTest() {

        HeaderPage header = new HeaderPage(driver);
        header.clickProfileButton();
        header.clickLogotype();

        MainPage mainPage = new MainPage(driver);
        mainPage.checkMainPage();


    }

    @Test
    @DisplayName("Profile: profile -> main page by main page button")
    @Description("Profile: transition from profile to main page by main page button")
    public void fromProfileToMainPageByMainPageButtonTest() {

        HeaderPage header = new HeaderPage(driver);
        header.clickProfileButton();
        header.clickMainPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.checkMainPage();

    }



    @Test
    @DisplayName("Profile: exit button")
    @Description("Profile: exit button flow")
    public void profileExitButtonTest() {

        HeaderPage header = new HeaderPage(driver);
        header.clickProfileButton();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickExit();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.checkEmptySignInPage();


    }

}
