package Pages;

import Base.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage {
    private Logger logger=Logger.getLogger(ProductDetailPage.class);

    private final By productNameLabel=By.id("product-name");
    private final By goToBasket=By.id("addToCart");
    private final By goToBasketPage=By.xpath("//button[text()=\"Sepete git\"]");

    public ProductDetailPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void isProductDetailPageOpen(){
        changeWindow(1);
        String productListPageProductName=getData("productList_selectedProductName");
        String productDetailPageProductName=getText(productNameLabel);
        storeData("productDetail_selectedProductName", productDetailPageProductName);
        Assert.assertTrue(productListPageProductName.equals(productDetailPageProductName));
        logger.info("Ürün detay sayfası başarılı şekilde açılmıştır.");
    }

    public void goToBasket(){
        click(goToBasket);
        click(goToBasketPage);
    }
}
