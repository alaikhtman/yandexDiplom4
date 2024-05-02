package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.Config.LOGIN_URL;
import static config.Config.URL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignInPage {

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка регистрации
    public By signUpButton = By.xpath(".//p[1]/a");

    //Кнопка входа
    public By entranceButton = By.xpath(".//button[text()='Войти']");

    //Поле имейла
    public By emailField = By.xpath(".//fieldset[1]//input");

    //Поле пароля
    public By passwordField = By.xpath(".//fieldset[2]//input");

    //Текст Вход
    public By entranceText = By.xpath(".//*[text()='Вход']");


    //Кнопка для восстановления пароля
    public By restorePasswordButton = By.xpath(".//p[2]/a");


    //Заполнить емейл
    @Step("Fill an email")
    public void fillEmailField(String email) {
        assertTrue(driver.findElement(emailField).isEnabled());
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);

    }

    //Заполнить пароль
    @Step("Fill a password")
    public void fillPasswordField(String password) {
        assertTrue(driver.findElement(passwordField).isEnabled());
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }


    //Нажатие на кнопку регистрации
    @Step("Click signUp button")
    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    //Нажатие на кнопку войти
    @Step("Click entrance button")
    public void clickEntranceButton() {
        driver.findElement(entranceButton).click();
    }


    //Нажатие на кнопку забыл пароль
    @Step("Click password button")
    public void clickPasswordRestoreButton() {
        driver.findElement(restorePasswordButton).click();
         }

    //Ожидание загрузки страницы
    public void waitSignInPage() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(entranceText));

    }


    //Авторизовать пользователя
    @Step("Sign in user")
    public void signInUser(String email, String password) {
        waitSignInPage();
        fillEmailField(email);
        fillPasswordField(password);
        clickEntranceButton();

    }

    //Нажатие кнопки авторизации
    @Step("Check empty signIn page is loaded")
    public void checkEmptySignInPage() {
        waitSignInPage();
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
        assert(driver.findElement(emailField).getAttribute("value").isEmpty());
        assert(driver.findElement(passwordField).getAttribute("value").isEmpty());
    }

}
