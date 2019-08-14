package com.Airpay.Tests;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class App {

		private static AndroidDriver driver;
		public static void main(String[] args) throws MalformedURLException, InterruptedException {

			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "/App/");
			File app = new File(appDir, "Airpay Demo_com.example.sampleairpay_upi.apk");

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability("deviceName", "Redmi");
			capabilities.setCapability("udid", "594daa44");
			capabilities.setCapability("platformVersion", "9");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", "com.example.sampleairpay_upi");
			capabilities.setCapability("appActivity", "com.example.sampleairpay_upi.Splashscreen");

		//	driver = new AndroidDriver(new URL("https://127.0.0.1:4723/wd/hub"), capabilities);
			AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			Thread.sleep(10000);
			MobileElement el1 = (MobileElement) driver.findElementById("com.example.sampleairpay_upi:id/btget");
			el1.click();
			driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
			Thread.sleep(8000);
			MobileElement el2 = (MobileElement) driver.findElementById("com.example.sampleairpay_upi:id/firstName_et");
			Thread.sleep(8000);
			el2.sendKeys("Swapnil");
			MobileElement el3 = (MobileElement) driver.findElementById("com.example.sampleairpay_upi:id/lastName_et");
			Thread.sleep(1000);
			el3.sendKeys("Pawar");
			driver.findElementById("com.example.sampleairpay_upi:id/phone_et").sendKeys("8080326836");
			//MobileElement el4 = (MobileElement) 
			//el4.sendKeys("8080326836");
			driver.findElementById("com.example.sampleairpay_upi:id/orderId_et").sendKeys("Test100");
			driver.findElementById("com.example.sampleairpay_upi:id/amount_et").sendKeys("1.00");
			driver.findElementById("com.example.sampleairpay_upi:id/nextButton").click();
			
		
		  Set<String> contextNames = driver.getContextHandles(); 
		  for (String contextName : contextNames)
		  { 
			  System.out.println(contextName); 
		  //prints out something like NATIVE_APP \n WEBVIEW_1 
		  } 
		  driver.context("WEBVIEW_com.example.sampleairpay_upi");
		  //contextNames.toArray()[1]); // set context to WEBVIEW_1
		 
		  driver.findElementByXPath("//a[contains(@data-tab-id,'credit')]").click();
			
		//  NATIVE_APP
		//  WEBVIEW_com.example.sampleairpay_upi
		//  WEBVIEW_chrome
			
			
			//driver.quit();

	}

}