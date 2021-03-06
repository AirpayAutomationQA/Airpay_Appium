package com.Airpay.InitialSetup;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Airpay.Utilities.Constants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Driver_Setup {

	public AppiumDriver<MobileElement> driver = null;
	public String TC_ID = null;
	public String driverPath = Constants.drivePath;

	public AppiumDriver<MobileElement> getDriver(){
		return driver;

	}
	public void setDriver(String browserType, String appURL) throws InterruptedException, MalformedURLException{
		switch(browserType){

		/*
		 * case "IE": driver = initIEDriver(appURL); break;
		 * 
		 * case "CHROME": driver = initChromeDriver(appURL); break;
		 * 
		 * case "FIREFOX": driver = initfirefoxDriver(appURL); break;
		 * 
		 * case "SAFARI": driver = initfirefoxDriver(appURL); break;
		 */
		case "MOBILE":
			driver = initmobile(appURL);
			break;	

		default :
			System.out.println("you have enetered as invalid browser");
		}		
	}

	/*
	 * public WebDriver initChromeDriver(String appURL) throws InterruptedException
	 * { //driver.get("chrome://settings/clearBrowserData");
	 * 
	 * System.out.println("Launching google chrome driver!!! .");
	 * System.setProperty("webdriver.chrome.driver", driverPath +
	 * "chromedriver.exe"); driver = new ChromeDriver();
	 * driver.manage().window().maximize();
	 * //driver.navigate().to("chrome://settings/clearBrowserData");
	 * Thread.sleep(5000);
	 * //driver.findElement(By.xpath("//*[@id='clearBrowsingDataConfirm']")).click()
	 * ; driver.navigate().to(appURL); driver.manage().deleteAllCookies(); return
	 * driver; }
	 * 
	 * 
	 * public AppiumDriver<MobileElement> initIEDriver(String appURL) {
	 * System.out.println("Launching google IE driver!!! .");
	 * System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
	 * 
	 * DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
	 * cap.setCapability(InternetExplorerDriver.
	 * INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	 * cap.setCapability("nativeEvents", false);
	 * cap.setCapability("ignoreProctedModeSettings", true);
	 * cap.setCapability("disable-popup-blocking", true);
	 * 
	 * driver = new InternetExplorerDriver(cap);
	 * driver.manage().window().maximize(); driver.navigate().to(appURL);
	 * driver.manage().deleteAllCookies(); return driver;
	 * 
	 * 
	 * }
	 * 
	 * public WebDriver initfirefoxDriver(String appURL) {
	 * System.out.println("Launching Firefor driver  !!!.");
	 * System.setProperty("webdriver.gecko.driver", driverPath+ "geckodriver.exe");
	 * //DesiredCapabilities capabilities = DesiredCapabilities.firefox(); driver=
	 * new FirefoxDriver(); driver.manage().window().maximize();
	 * driver.navigate().to(appURL); return driver; }
	 */
	public AppiumDriver<MobileElement> initmobile(String appURL) throws InterruptedException, MalformedURLException {
		System.out.println("Launching appium driver!!! .");
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/App/");
		File app = new File(appDir, "Airpay Demo_com.example.sampleairpay_upi.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Redmi");
		capabilities.setCapability("udid", "594daa44");
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("platformName", "Android");
	
		capabilities.setCapability("nativeWebScreenshot", true);
		capabilities.setCapability("newCommandTimeout", 100);
		//capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.example.sampleairpay_upi");
		capabilities.setCapability("appActivity", "com.example.sampleairpay_upi.Splashscreen");

	//	driver = new AndroidDriver(new URL("https://127.0.0.1:4723/wd/hub"), capabilities);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		MobileElement el1 = (MobileElement) driver.findElementById("com.example.sampleairpay_upi:id/btget");
		el1.click();
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		Thread.sleep(8000);
		return driver;
	}
	
	@Parameters({ "browserType", "appURL","tcID" })
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String appURL,String tcID) {
		try {
			setDriver(browserType.toUpperCase(), appURL);
			TC_ID = tcID;

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
