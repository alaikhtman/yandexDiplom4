package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HeaderPage {

    private WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка главной страницы
    private By headerMainPageButton = By.xpath(".//*[text()= 'Конструктор']");

    //Логотип
    private By headerLogotypeButton = By.className("AppHeader_header__logo__2D0X2");

    //Кнопка личного кабинета
    private By headerProfileButton = By.linkText("Личный Кабинет");


    //Нажать на кнопку главной страницы
    @Step("Click main page button")
    public void clickMainPage() {
        driver.findElement(headerMainPageButton).click();
    }

    //Нажатие на кнопку личного кабинета
    @Step("Click profile")
    public void clickProfileButton() {
        driver.findElement(headerProfileButton).click();
    }

    //Нажать на логотип
    @Step("Click logotype")
    public void clickLogotype() {
        driver.findElement(headerLogotypeButton).click();

    }
}
