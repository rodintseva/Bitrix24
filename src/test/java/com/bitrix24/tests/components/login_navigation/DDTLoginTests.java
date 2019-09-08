package com.bitrix24.tests.components.login_navigation;

import com.bitrix24.utils.ConfigurationReader;
import com.bitrix24.utils.ExcelUtil;
import com.bitrix24.utils.Pages;
import com.bitrix24.utils.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

public class DDTLoginTests extends TestBase {

    @FindBy(name = "USER_LOGIN")
    public WebElement userNameElement;
    @FindBy(name = "USER_PASSWORD")
    public WebElement passwordElement;
    @FindBy(css = "input.login-btn")
    public WebElement loginButtonElement;


    @Test(dataProvider = "credentials_info")
    public void loginTestWithDataProvider(String group, String username, String password, String environment){

        Pages page = new Pages();
        extentLogger = report.createTest("Data Driver Testing with excel");
        if(group.equalsIgnoreCase("Group 23")){
            page.loginPage().login(username, password);
            Assert.assertEquals(pages.messagePage().getPageTitle(),"Activity Stream");
            extentLogger.pass("Login as " + username + " successfull");
        }else{
            throw new SkipException("Test ignored");
        }
    }

    @DataProvider(name="credentials_info")
    public Object[][] credentials(){
        String filepath = System.getProperty("user.dir") +
                          ConfigurationReader.getProperty("filepath") +
                          ConfigurationReader.getProperty("excelFile");
        String sheet = ConfigurationReader.getProperty("excelSheet");
        ExcelUtil qa2 = new ExcelUtil(filepath, sheet);
        return qa2.getDataArray();
    }
}
