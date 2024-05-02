package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.Config.URL;
import static org.junit.Assert.assertEquals;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    //Раздел "Булки"

    private By bunSection = By.xpath(".//div/span[text()='Булки']/..");
    //Раздел "Соусы"
    private By saucesSection = By.xpath(".//div/span[text()='Соусы']/..");
    //Раздел "Начинки"
    private By fillingsSection = By.xpath(".//div/span[text()='Начинки']/..");

    //Кнопка войти в аккаунт
    private By signInButton = By.xpath("//*[text()= 'Войти в аккаунт']");

    //Текст страницы
    private By pageText = By.xpath(".//*[text()= 'Соберите бургер']");


    //Нажать на раздел "Булки"
    @Step("Select buns section")
    public void selectBuns() {
        driver.findElement(bunSection).click();
    }


    //Нажать на раздел "Соусы"
    @Step("Select sauces section")
    public void selectSauce() {
        driver.findElement(saucesSection).click();
    }


    //Нажать на раздел "Начинки"
    @Step("Select fillings section")
    public void selectFilling() {
        driver.findElement(fillingsSection).click();
    }

    //Нажатие на кнопку личного кабинета
    @Step("Click signIn button on main page")
    public void clickSignInButton() {
        waitMainPage();
        driver.findElement(signInButton).click();

    }

    //Ожидание загрузки страницы
    public void waitMainPage() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(pageText));

    }

    //Проверить раздел "Булки"
    @Step("Check buns section is selected")
    public void checkBuns() {
        assertEquals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect", driver.findElement(bunSection).getAttribute("class"));
    }


    //Проверить раздел "Соусы"
    @Step("Check sauces section is selected")
    public void checkSauce() {
        assertEquals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect", driver.findElement(saucesSection).getAttribute("class"));

    }


    //Проверить раздел "Начинки"
    @Step("Check fillings section is selected")
    public void checkFilling() {
        assertEquals("tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect", driver.findElement(fillingsSection).getAttribute("class"));

    }

    //Проверить загрузку страницы
    @Step("Check main page is loaded")
    public void checkMainPage() {
        waitMainPage();
        assertEquals(URL, driver.getCurrentUrl());
        assert (driver.findElement(bunSection).isDisplayed());
        assert (driver.findElement(saucesSection).isDisplayed());
        assert (driver.findElement(fillingsSection).isDisplayed());
    }


}
