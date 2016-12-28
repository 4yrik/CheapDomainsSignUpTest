package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import java.util.*;

public class RegisterPage {

    private WebDriver driver;

    @FindBy(name = "first_name")
    private WebElement firstName;

    @FindBy(name = "last_name")
    private WebElement lastName;

    @FindBy(name = "address")
    private WebElement address;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "post_code")
    private WebElement postCode;

    @FindBy(xpath = "//*[@id='country_name']//option[@value!='null']")
    private List<WebElement> countryList;

    @FindBy(name = "state")
    private WebElement state;

    @FindBy(id = "phone_number")
    private WebElement phoneNumber;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "acc_type")
    private List<WebElement> userTypes;

    @FindBy(id = "business")
    private WebElement businessName;

    @FindBy(id = "business_number_element")
    private WebElement businessNumber;

    @FindBy(name = "username")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//input[@value='Continue Order']")
    private WebElement continueOrder;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        driver.get("http://www.cheapdomains.com.au/register/member_register_test.php");
        PageFactory.initElements(driver, this);
    }

    public RegisterPage fillFirstName(String _firstName){
        firstName.sendKeys(_firstName);
        return this;
    }

    public RegisterPage fillLastName(String _lastName){
        lastName.sendKeys(_lastName);
        return this;
    }

    public RegisterPage fillAddress(String _address){
        address.sendKeys(_address);
        return this;
    }

    public RegisterPage fillCity(String _city){
        city.sendKeys(_city);
        return this;
    }

    public RegisterPage fillPostCode(String _postCode){
        postCode.sendKeys(_postCode);
        return this;
    }

    public RegisterPage chooseCountry(String _countryName){
        for(WebElement country: countryList){
            if(country.getText().equals(_countryName)){
                country.click();
                return this;
            }
        }
        throw new IllegalArgumentException(String.format("There is no such country: %s", _countryName));
    }

    public RegisterPage fillState(String _state){
        state.sendKeys(_state);
        return this;
    }

    public RegisterPage fillPhoneNumber(String _phoneNumber){
        phoneNumber.sendKeys(_phoneNumber);
        return this;
    }

    public RegisterPage fillEmail(String _email){
        email.sendKeys(_email);
        return this;
    }

    public RegisterPage chooseUserType(String _userType){
        for(WebElement userType: userTypes){
            if(userType.getAttribute("value").equals(_userType.toLowerCase())){
                userType.click();
                return this;
            }
        }
        throw new IllegalArgumentException(String.format("There is no such User Type: %s", _userType));
    }

    public RegisterPage fillBusinessName(String _businessName){
        if(userTypes.get(1).isSelected()) {
            businessName.sendKeys(_businessName);
        }
        return this;
    }

    public RegisterPage fillBusinessNumber(String _businessNumber){
        if(userTypes.get(1).isSelected()) {
            businessName.sendKeys(_businessNumber);
        }
        return this;
    }

    public RegisterPage fillUserName(String _userName){
        userName.sendKeys(_userName);
        return this;
    }

    public RegisterPage fillPassword(String _password){
        password.sendKeys(_password);
        return this;
    }

    public void clickContinueOrder(){
        continueOrder.click();
    }
}
