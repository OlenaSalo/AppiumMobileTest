package com.epam.TA.pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;


public class GmailPageObject extends GmailBasePage {


    @FindBy(xpath = "//*[@text='GOT IT']")
    private MobileElement gotIt;

    @FindBy(xpath = "//*[@text='Add an email address']")
    private MobileElement addGmail;

    @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/providers_list']/*[@class='android.widget.LinearLayout'][5]")
    private MobileElement googleGmail;

    @FindBy(xpath = "//*[contains(@class, 'android.widget.EditText')]")
    private MobileElement loginInput;

    @FindBy(xpath = "//*[@text='NEXT']")
    private MobileElement nextButton;

    @FindBy(xpath = "//android.view.View[4]/android.widget.Button[@resource-id='identifierNext']")
    private MobileElement littleNext;

    @FindBy(xpath = "//*[@resource-id='com.google.android.gm:id/setup_fragment_content']/*[@class='android.widget.LinearLayout'][1]")
    private MobileElement personalChoose;

    @FindBy(xpath = "//*[@resource-id='password']")
    private MobileElement pswInput;

    @FindBy(xpath = "//*[@text = 'Next']")
    private MobileElement next;

    @FindBy(xpath = "//*[@text = 'I agree']")
    private MobileElement agree;

    @FindBy(id = "com.google.android.gm:id/alertTitle")
    private MobileElement dubplicatedAccount;

    @FindBy(xpath = "//*[@text = 'OK']")
    private MobileElement ok;

    @FindBy(id = "android:id/navigationBarBackground")
    private MobileElement buttonBack;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Gmail']")
    private MobileElement gmailIcon;

    @FindBy(xpath = "//*[@text = 'TAKE ME TO GMAIL']")
    private MobileElement takeMeToGmail;


    public GmailPageObject() throws MalformedURLException {
    }

    public MobileElement getGotIt() {
        return gotIt;
    }

    public MobileElement getAddGmail() {
        return addGmail;
    }

    public void getOther() {
        clickOther(googleGmail);
    }

    public MobileElement getLoginInput() {
        return loginInput;
    }

    public void getLittleNext() {
        clickOther(littleNext);
    }

    public void getPswInput(String psw) {
        sendPsw(pswInput, psw);
    }

    public MobileElement getNextButton() {
        return nextButton;
    }

    public void setNext() {
        clickOther(next);
    }

    public void setAgree() {
        clickOther(agree);
    }

    public boolean getDubplicatedAccount() {
        return isElementPresent(dubplicatedAccount);
    }

    public void setOk() {
        clickOther(ok);
    }

    public MobileElement getButtonBack() {
        return buttonBack;
    }

    public void setGmailIcon() {
        clickOther(gmailIcon);
    }

    public MobileElement getTakeMeToGmail() {
        return takeMeToGmail;
    }

}
