package com.epam.TA.pages;


import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;


public class GmailHomePage extends GmailBasePage {


    @FindBy(xpath = "//*[@text = 'ACCEPT'") //
    private MobileElement accept;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Gmail']")
    private MobileElement gmailIcon;

    @FindBy(xpath = "//*[@text = 'TAKE ME TO GMAIL']")
    private MobileElement takeMeToGmail;

    @FindBy(xpath = "//*[@text = 'Welcome']")
    private MobileElement welcome;

    @FindBy(xpath = "//*[@text = 'Next']")
    private MobileElement nextButton;

    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.Button[@resource-id='android:id/button1']")
    private MobileElement okButton;

    @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/owner']")
    private MobileElement countOwner;

    public GmailHomePage() throws MalformedURLException {
    }

    public void setOk() {
        clickOther(okButton);
    }

    public void setTakeMeToGmail() {
        clickOther(takeMeToGmail);
    }

    public boolean isOwner() {
        return isElementPresent(countOwner);
    }

    public void setWelcome() {
        clickOther(welcome);
    }

}
