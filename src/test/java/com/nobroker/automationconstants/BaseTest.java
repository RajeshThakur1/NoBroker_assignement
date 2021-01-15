package com.nobroker.automationconstants;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import com.nobroker.generic.Property;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest implements Automation_Constants{

	
	public Logger log;
	// public static WebDriver driver;

	public static String un;
	public static String pw;
	
	public static long timeout;
	

	public static String deviceName;
	public static String udid;
	public static String platformName;
	public static String platformVersion;
	public static String appPackage;
	public static String appActivity;
	
	public static URL url;

	
	public static AndroidDriver<WebElement> driver;

	public static boolean loginRequired = true;
	public static boolean logoutRequired = true;

	
	public BaseTest() {

		log = log.getLogger("LOg_ Logger");
		PropertyConfigurator.configure("log4j.properties");
		log = Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
	}

	
	public void initFrameWork() throws MalformedURLException {
        log.info("initilizing framework");
        //url=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "URL");
        un= Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "UN");
        //System.out.println(un);
        pw=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "PW");
        timeout=Long.parseLong(Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "IMPLICIT"));
        deviceName=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "deviceName");
        udid=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "udid");
        platformName=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "platformName");
        platformVersion=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "platFormVersion");
        appPackage=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "appPackage");
        appActivity=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "appActivity");
        
        
    }
	
	
	@BeforeTest
	public void initApplication() throws Exception {
		initFrameWork();

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		// caps.setCapability("deviceName", deviceName);
		caps.setCapability(MobileCapabilityType.UDID, udid);
		// caps.setCapability("udid", udid);
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		// caps.setCapability("platformName", platformName);
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		// caps.setCapability("platformVersion", platformVersion);
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		// caps.setCapability("appPackage", appPackage);
		// caps.setCapability("appActivity", appActivity);
		caps.setCapability("noReset", true);

		caps.setCapability("automationName", "uiautomator2");
		caps.setCapability("noSign", "true");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);

		url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, caps);
		// driver.manage().window().maximize();

		log.info("TimeOut:" + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public void relaunchApp() throws InterruptedException {
		driver.closeApp();
		Thread.sleep(2000);
		driver.launchApp();
	}
	
	
	
	
}


