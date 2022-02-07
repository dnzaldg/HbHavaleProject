package Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSummaryPage extends BasketPage{
    private Logger logger=Logger.getLogger(OrderSummaryPage.class);

    public OrderSummaryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private final By bankNameLabel=By.xpath("(//div[@class='detail_20j8y']//span)[2]");

    public void isOrderSummaryPageOpen(){
        String paymentPageBankName=getData("bankList_selectedBankName");
        String orderPageBankName=getText(bankNameLabel);
        Assert.assertTrue(paymentPageBankName.contains(orderPageBankName));
        logger.info("Ödeme özet sayfası başarılı şekilde açılmıştır.");
    }
}
