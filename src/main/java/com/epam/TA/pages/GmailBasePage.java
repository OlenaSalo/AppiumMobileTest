package com.epam.TA.pages;

import com.epam.TA.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class GmailBasePage {
    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    public GmailBasePage() throws MalformedURLException {
        driver = DriverManager.getInstance().getDriver();
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void sendPsw(MobileElement mobileElement, String psw) {
        wait.until(ExpectedConditions.visibilityOf(mobileElement));
        mobileElement.sendKeys(psw);
    }

    public void clickOther(MobileElement mobileElement) {
        wait.until(ExpectedConditions.elementToBeClickable(mobileElement)).click();
    }

    protected boolean isElementPresent(MobileElement mobileElement) {
        try {
            mobileElement.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}


