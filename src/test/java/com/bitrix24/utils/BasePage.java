package com.bitrix24.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public abstract class BasePage {
        //we don't want to access these variables outside
        private static final Logger logger = LogManager.getLogger();


        @FindBy(css = "find")
        @CacheLookup
        protected WebElement loaderMask;

        @FindBy(id = "pagetitle")
        protected WebElement pageTitle;


        public BasePage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }


        /**
         * @return page name, for example: Dashboard
         */
        public String getPageTitle() {
            //ant time we are verifying page name, or page subtitle, loader mask appears
          //  waitUntilLoaderScreenDisappear();
            BrowserUtils.waitForStaleElement(pageTitle);
            return pageTitle.getText();
        }


        /**
         * Waits until loader screen present. If loader screen will not pop up at all,
         * NoSuchElementException will be handled  bu try/catch block
         * Thus, we can continue in any case.
         */
        public void waitUntilLoaderScreenDisappear() {
            try {
                WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Integer.valueOf(ConfigurationReader.getProperty("SHORT_WAIT")));
                wait.until(ExpectedConditions.invisibilityOf(loaderMask));
            } catch (Exception e) {
                logger.error("Loader mask doesn't present.");
                System.out.println("Loader mask doesn't present.");
            }
        }

        /**
         * This method will navigate user to the specific module in vytrack application.
         * For example: if tab is equals to Activities, and module equals to Calls,
         * Then method will navigate user to this page: https://login1.nextbasecrm.com/stream/
         *
         * @param tab
         * @param module
         */
        public void navigateToModule(String tab, String module) {
            String tabLocator = "" + tab + "";
            String moduleLocator = "" + module + "";
            try {
                BrowserUtils.waitForClickablility(By.xpath(tabLocator), Integer.valueOf(ConfigurationReader.getProperty("SHORT_WAIT")));
                WebElement tabElement = Driver.getDriver().findElement(By.xpath(tabLocator));
                new Actions(Driver.getDriver()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
            } catch (Exception e) {
                logger.error("Failed to click on :: "+tab);
                logger.error(e);
                BrowserUtils.clickWithWait(By.xpath(tabLocator), Integer.valueOf(ConfigurationReader.getProperty("SHORT_WAIT")));
            }
            try {
                BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), Integer.valueOf(ConfigurationReader.getProperty("SHORT_WAIT")));
                BrowserUtils.waitForVisibility(By.xpath(moduleLocator), Integer.valueOf(ConfigurationReader.getProperty("SHORT_WAIT")));
                BrowserUtils.scrollToElement(Driver.getDriver().findElement(By.xpath(moduleLocator)));
                Driver.getDriver().findElement(By.xpath(moduleLocator)).click();
            } catch (Exception e) {
                logger.error("Failed to click on :: "+module);
                logger.error(e);
                BrowserUtils.waitForStaleElement(Driver.getDriver().findElement(By.xpath(moduleLocator)));
                BrowserUtils.clickWithTimeOut(Driver.getDriver().findElement(By.xpath(moduleLocator)),  Integer.valueOf(ConfigurationReader.getProperty("SHORT_WAIT")));
            }
        }

        /**
         * This method will navigate user to the specific module in BriteERP application.
         * @param tab
         */
        public static void navigateToModule(String tab) {

            String tabLocator = "a[title='"+ tab + "']";
            BrowserUtils.clickWithWait(Driver.getDriver(), By.cssSelector(tabLocator), 5);
        }

    }


