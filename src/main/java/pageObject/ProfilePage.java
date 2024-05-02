package pageObject;

import io.qameta.allure.Step;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Locale;

public class ProfilePage {

    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле имени
    public By nameField = By.xpath(".//li[1]/div/div/input");

    //Поле имейла
    public By emailField = By.xpath(".//li[2]/div/div/input");

    //Кнопка выхода
    public By exitButton = By.xpath(".//button[text()='Выход']");



    //Ожидание загрузки страницы с данными
    public void waitUntilAccountDetails() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));

    }

    //Получить имя
    @Step("Get the name")
    public String getName() {
        String name = driver.findElement(nameField).getAttribute("value");
        return name;
    }


    // Получить имейл
    @Step("Get the email")
    public String getEmail() {
        String email = driver.findElement(emailField).getAttribute("value");
        return email;
    }


    //Нажать на выход
    @Step("Click exit button")
    public void clickExit() {
        waitUntilAccountDetails();
        driver.findElement(exitButton).click();
    }


    //Проверить данные
    @Step("Check account's data")
    public void checkAccountsData(String name, String email) {
        waitUntilAccountDetails();
        String formattedEmail = email.toLowerCase(Locale.ROOT);
        assertEquals(name, getName());
        assertEquals(formattedEmail, getEmail());
    }

}
