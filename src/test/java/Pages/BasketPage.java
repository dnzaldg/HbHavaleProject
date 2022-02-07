package Pages;

import Base.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage extends BasePage {
    private Logger logger=Logger.getLogger(BasePage.class);

    private final By basketPageProductNameLabel=By.xpath("//div[@class=\"product_name_3Lh3t\"]");
    private final By continueButton=By.id("continue_step_btn");

    public BasketPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void isBasketPageOpen(){
        String productDetailPageProductName=getData("productDetail_selectedProductName");
        String basketPageProductName=getText(basketPageProductNameLabel);
        storeData("basketPage_selectedProductName", basketPageProductName);
        Assert.assertTrue(productDetailPageProductName.equals(basketPageProductName));
        logger.info("Sepetim sayfası başarılı şekilde açılmıştır.");
    }

    public void goToDeliveryPage(){
        click(continueButton);
    }
}
