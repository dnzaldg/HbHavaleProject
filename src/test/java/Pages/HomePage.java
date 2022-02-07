package Pages;

import Base.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    private Logger logger=Logger.getLogger(HomePage.class);

    private final By myAccountButton=By.id("myAccount");
    private final By myLoginButton=By.id("login");
    private final By myAccountUser=By.className("sf-OldMyAccount-1k66b");
    private final By searchTextBox=By.xpath("//div[@id='SearchBoxOld']//input");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void isHomePageOpen(){
        Assert.assertTrue(getPageTitle().equals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com"));
        logger.info("Anasayfa başarılı şekilde açılmıştır.");
    }

    public void gotoLoginPage(){
        hover(myAccountButton);
        click(myLoginButton);
    }

    public void isUserLogin(){
        boolean isUserLogin=isDisplayed(myAccountUser);
        Assert.assertTrue(isUserLogin);
        logger.info("User başarılı şekilde login olmuştur.");
    }

    public void search(String text){
        write(searchTextBox,text);
        enter(searchTextBox);
    }


}
