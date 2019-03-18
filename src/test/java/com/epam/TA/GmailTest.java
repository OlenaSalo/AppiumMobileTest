package com.epam.TA;

import com.epam.TA.businessObj.GmailHomePageBO;
import com.epam.TA.businessObj.GmailLoginPageBo;
import com.epam.TA.pages.GmailHomePage;
import com.epam.TA.unit.User;
import com.epam.TA.unit.JsonObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class GmailTest {
    public static final Logger LOG = LogManager.getLogger(GmailTest.class);

    JsonObject jsonObject = new JsonObject();

    @BeforeSuite(alwaysRun = true)
    public void configSuite() {

        LOG.info("===================================");
        LOG.info("   TESTS  VALID - STARTED");
        LOG.info("===================================");
}

    @Test(dataProvider = "getUser")
    public void verifyDeleteCanceledMsgTest(User user) throws MalformedURLException {

        GmailLoginPageBo gmailPageObject = new GmailLoginPageBo();
        GmailHomePageBO gmailDeleteCanceled = new GmailHomePageBO();
        gmailPageObject.actionBeforeLogIn();
        gmailPageObject.logIn(user.getUserName(), user.getPsw());
        Assert.assertTrue(gmailDeleteCanceled.verifyHomePage());

    }

    @AfterMethod
    public void closeAll() throws MalformedURLException {
        DriverManager.getInstance().getDriver().quit();
    }


    @DataProvider()
    public Object[][] getUser() throws FileNotFoundException {

        return jsonObject.getDataForUser();
    }
}
