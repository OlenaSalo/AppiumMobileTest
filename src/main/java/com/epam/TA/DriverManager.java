package com.epam.TA;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static final Logger LOG = LogManager.getLogger(DriverManager.class);

    private DriverManager() {
    }

    private static DriverManager instance = new DriverManager();
    public static DriverManager getInstance() {
        return instance;
    }
    private static ThreadLocal<AndroidDriver> driverPool = new ThreadLocal<AndroidDriver>();

    public AndroidDriver getDriver() throws MalformedURLException {
        if (driverPool.get() == null) {
            LOG.info("Driver initialize successful");
            driverPool.set(initAndroidDriver());
        }
        return driverPool.get();
    }

    static AndroidDriver initAndroidDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("appPackage", "com.google.android.gm");
        capabilities.setCapability("appActivity", "GmailActivity");
        AndroidDriver<MobileElement> androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        androidDriver.resetApp();
        return androidDriver;
    }
}
