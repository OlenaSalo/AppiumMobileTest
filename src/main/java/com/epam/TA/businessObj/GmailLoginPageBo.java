package com.epam.TA.businessObj;

import com.epam.TA.pages.GmailPageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;


public class GmailLoginPageBo {
    public static final Logger LOG = LogManager.getLogger(GmailLoginPageBo.class);


    private GmailPageObject gmailPageObject = new GmailPageObject();

    public GmailLoginPageBo() throws MalformedURLException {
    }

    public void actionBeforeLogIn() {
        LOG.info("Welcome to gmail");
        gmailPageObject.getGotIt().click();
        LOG.info("Add user to google mail");
        gmailPageObject.getAddGmail().click();
        LOG.info("Choose other system");
        gmailPageObject.getOther();
    }

    public void logIn(String username, String psw) {
        LOG.info("Send your username");
        gmailPageObject.getLoginInput().sendKeys(username);
        gmailPageObject.getNextButton().click();
        LOG.info("Wait a moment for connection");
        if (gmailPageObject.getDubplicatedAccount()) {
            LOG.info("This account exist, try another");
            gmailPageObject.setOk();
            gmailPageObject.getButtonBack().tap(2, 10);
            gmailPageObject.getButtonBack().click();
            gmailPageObject.setGmailIcon();
            gmailPageObject.getTakeMeToGmail();
        } else {
            LOG.info("One more next button");
            gmailPageObject.getLittleNext();
            gmailPageObject.getLittleNext();
            LOG.info("Send psw");
            gmailPageObject.getPswInput(psw);
            gmailPageObject.setNext();
            LOG.info("Agree with security of gmail");
            gmailPageObject.setAgree();
        }
    }

}
