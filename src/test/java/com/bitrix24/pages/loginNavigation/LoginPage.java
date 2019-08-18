package com.bitrix24.pages.loginNavigation;

import com.bitrix24.utils.ConfigurationReader;
import com.bitrix24.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@id=\"login-popup\"]/form/div[1]/div[1]/input")
    public WebElement userNameElement;
    @FindBy(xpath = "//*[@id=\"login-popup\"]/form/div[1]/div[2]/input")
    public WebElement passwordElement;


    @FindBy(xpath = "//*[@id=\"login-popup\"]/form/div[2]/input")
    public WebElement loginButtonElement;

    public void login(String username, String password) {
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }

    public void login() {
        String username = ConfigurationReader.getProperty("helpdesk35username");
        String password = ConfigurationReader.getProperty("helpdesk35password");
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }
    public void goToLandingPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url" + ConfigurationReader.getProperty("environment")));
    }
}

