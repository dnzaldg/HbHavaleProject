package Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PaymentPage extends BasketPage{
    private Logger logger=Logger.getLogger(PaymentPage.class);

    public PaymentPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private final By transferOption=By.xpath("//h3[text()='Anında Havale']");
    private final By bankList=By.xpath("//p[@class='sardesPaymentPage-MoneyTransfer-bank_name']");
    private final By continueButton=By.id("continue_step_btn");

    public void isPaymentPageOpen(){
        Assert.assertTrue(isDisplayed(transferOption));
        logger.info("Odeme sayfası başarılı şekilde açılmıştır.");
    }

    public void clickTransferMenu(){
        click(transferOption);
    }

    public void selectRandomBank(){
        List<WebElement> elementList= getElementList(bankList);
        int randomNumber=getRandomNumber(elementList.size());
        WebElement selectedBank= elementList.get(randomNumber);
        storeData("bankList_selectedBankName", selectedBank.getText());
        selectedBank.click();
    }

    public void clickPaymentContinueButton(){
        click(continueButton);
    }

}
