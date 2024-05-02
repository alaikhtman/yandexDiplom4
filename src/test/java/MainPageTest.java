import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;
import pageObject.MainPage;

public class MainPageTest extends BaseTest{

    @Before
    public void setUp() {
        startUp("chrome");
    }

    @Test
    @DisplayName("Main Page: buns section")
    @Description("Main Page: select buns section")
    public void selectBunsSectionTest(){

        MainPage mainPage = new MainPage(driver);
        mainPage.selectFilling();
        mainPage.selectBuns();
        mainPage.checkBuns();

    }

    @Test
    @DisplayName("Main Page: sauces section")
    @Description("Main Page: select sauces section")
    public void selectSaucesSectionTest(){

        MainPage mainPage = new MainPage(driver);
        mainPage.selectSauce();
        mainPage.checkSauce();


    }

    @Test
    @DisplayName("Main Page: fillings section")
    @Description("Main Page: select fillings section")
    public void selectFillingsSectionTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.selectFilling();
        mainPage.checkFilling();

    }
}
