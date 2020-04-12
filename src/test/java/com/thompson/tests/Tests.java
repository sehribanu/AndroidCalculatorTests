package com.thompson.tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Tests {
    private AndroidDriver <MobileElement> driver;

    @Test
    public void test1() throws InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3 API 24");
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        //desiredCapabilities.setCapability("automationName", "UiAutomator2");
        //desiredCapabilities.setCapability("newCommandTimeout", "10000");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("w3c", true);
        //desiredCapabilities.setCapability("adbExecTimeout", "20000");

        try {
            //Local Appium server http address
            driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Test1 : 72 + 55 = 127
        MobileElement seven = driver.findElementById("com.android.calculator2:id/digit_7");
        MobileElement two = driver.findElementById("com.android.calculator2:id/digit_2");
        MobileElement five = driver.findElementById("com.android.calculator2:id/digit_5");
        MobileElement plus = driver.findElementByAccessibilityId("plus");
        MobileElement equals = driver.findElementByAccessibilityId("equals");
        MobileElement result = driver.findElementById("com.android.calculator2:id/result");


        seven.click();
        two.click();
        plus.click();
        five.click();
        five.click();
        equals.click();
        String expResult = "127";
        String actResult = result.getText();
        System.out.println("Test1 actResult = " + actResult);
        Assert.assertEquals(expResult, actResult);

    }

}
