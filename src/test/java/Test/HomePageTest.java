package Test;

import Base.BaseTest;
import Pages.*;
import org.junit.Test;


public class HomePageTest extends BaseTest{

    @Test
    public void HomePageTest(){
       HomePage homePage=new HomePage(driver,wait);
       LoginPage loginPage=new LoginPage(driver,wait);
       ProductListPage productListPage=new ProductListPage(driver,wait);
       ProductDetailPage productDetailPage=new ProductDetailPage(driver,wait);
       BasketPage basketPage=new BasketPage(driver,wait);
       DeliveryPage deliveryPage=new DeliveryPage(driver,wait);
       PaymentPage paymentPage=new PaymentPage(driver,wait);
       OrderSummaryPage orderSummaryPage=new OrderSummaryPage(driver,wait);
       homePage.isHomePageOpen();
       homePage.gotoLoginPage();
       loginPage.isLoginPageOpen();
       loginPage.login("levokrtrn@gmail.com", "1234Qwer");
       homePage.isUserLogin();
       homePage.search("kitap");
       productListPage.selectRandomProduct();
       productDetailPage.isProductDetailPageOpen();
       productDetailPage.goToBasket();
       basketPage.isBasketPageOpen();
       basketPage.goToDeliveryPage();
       deliveryPage.isDeliveryPageOpen();
       deliveryPage.clickContinueButton();
       paymentPage.isPaymentPageOpen();
       paymentPage.clickTransferMenu();
       paymentPage.selectRandomBank();
       paymentPage.clickPaymentContinueButton();
       orderSummaryPage.isOrderSummaryPageOpen();
    }

}
