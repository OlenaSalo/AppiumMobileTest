package com.epam.TA.businessObj;

import com.epam.TA.pages.GmailHomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;


public class GmailHomePageBO {
    public static final Logger LOG = LogManager.getLogger(GmailHomePageBO.class);


    private GmailHomePage gmailHomePage = new GmailHomePage();

    public GmailHomePageBO() throws MalformedURLException {
    }

    public boolean verifyHomePage() {
        boolean condition;
        LOG.info("Accept all thing from google service");
        LOG.info("Go to you gmail home page");
        gmailHomePage.setTakeMeToGmail();
        gmailHomePage.setOk();
        if (gmailHomePage.isOwner()) {
            LOG.info("Account present");
            gmailHomePage.setTakeMeToGmail();
            LOG.info("Successful log in");
            condition = true;
        } else condition = false;

        return condition;
    }


}
