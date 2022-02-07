package Pages;

import Base.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeliveryPage extends BasePage {

    private Logger logger=Logger.getLogger(DeliveryPage.class);

    private final By deliveryPageProductNameLabel=By.xpath("//div[@class=\"name_1O4H5\"]");
    private final By deliveryFormLink=By.xpath("//span[@data-test-class=\"new-address-link\"]");
    private final By firstNameTextBox=By.xpath("//div[@class='input_outer_1QKx4']//input[@name='contact.firstName']");
    private final By lastNameTextBox=By.xpath("//div[@class='input_outer_1QKx4']//input[@name='contact.lastName']");
    private final By phoneNumberTextBox=By.xpath("//div[@class='input_outer_1QKx4']//input[@name='phoneNumber.gsmNumber']");

    private final By cityDropdown=By.cssSelector("div[data-test-class='city']>div>input");
    private final By cityDropdownFirstSelect=By.xpath("(//div[@data-test-class='select_menu']//div[contains(@class,'option')])[1]");
    private final By cityInput=By.xpath("//div[@data-test-class='city']//input[@id='city']");

    private final By districtDropdown=By.cssSelector("div[data-test-class='town']>div>input");
    private final By districtDropdownFirstSelect=By.xpath("(//div[@data-test-class='select_menu']//div[contains(@class,'option')])[1]");
    private final By districtInput=By.xpath("//div[@data-test-class='town']//input[@id='town']");

    private final By neighbourhoodDropdown=By.cssSelector("div[data-test-class='district']>div>input");
    private final By neighbourhoodDropdownFirstSelect=By.xpath("(//div[@data-test-class='select_menu']//div[contains(@class,'option')])[1]");
    private final By neighbourhoodInput=By.xpath("//div[@data-test-class='district']//input[@id='district']");

    private final By addressTextBox=By.xpath("//div[@class='input_outer_1QKx4']//textarea");
    private final By addressTitleTextBox=By.xpath("//div[@class='input_outer_1QKx4']//input[@name='name']");
    private final By saveAddress=By.xpath("//button[text()='Adresi kaydet']");

    private final By continuePaymentButton=By.id("continue_step_btn");


    public DeliveryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void isDeliveryPageOpen(){
        String basketPageProductName=getData("basketPage_selectedProductName");
        String deliveryPageProductName=getText(deliveryPageProductNameLabel);
        Assert.assertTrue(basketPageProductName.equals(deliveryPageProductName));
        logger.info("Teslimat sayfası başarılı şekilde açılmıştır.");
    }

    public void createDeliveryAddress(String FirstName, String LastName, String PhoneNumber, String City, String District,String Neighbourhood, String Address, String AddressTitle){
        click(deliveryFormLink);
        write(firstNameTextBox,FirstName);
        storeData("deliveryPage_firstName",FirstName);

        write(lastNameTextBox,LastName);
        storeData("deliveryPage_lastName",LastName);

        write(phoneNumberTextBox,PhoneNumber);
        storeData("deliveryPage_phoneNumber",PhoneNumber);

        doubleClick(cityDropdown);
        write(cityInput, City);
        storeData("deliveryPage_town",City);
        doubleClick(cityDropdownFirstSelect);

        doubleClick(districtDropdown);
        write(districtInput, District);
        storeData("deliveryPage_town",District);
        doubleClick(districtDropdownFirstSelect);

        doubleClick(neighbourhoodDropdown);
        write(neighbourhoodInput, Neighbourhood);
        storeData("deliveryPage_neighbourhood",Neighbourhood);
        doubleClick(neighbourhoodDropdownFirstSelect);

        write(addressTextBox,Address);
        storeData("deliveryPage_address",Address);

        write(addressTitleTextBox,AddressTitle);
        storeData("deliveryPage_phoneNumber",AddressTitle);

        click(saveAddress);
    }

    public void clickContinueButton(){
        click(continuePaymentButton);
    }
}
