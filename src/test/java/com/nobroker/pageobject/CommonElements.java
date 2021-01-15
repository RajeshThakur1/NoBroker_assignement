package com.nobroker.pageobject;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;


import com.nobroker.commonpage.BasePage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonElements extends BasePage{

	
	public CommonElements(){
        PageFactory.initElements(driver, this);
    }
	
	public static Logger log = Logger.getLogger(CommonElements.class);
	
	public void threadSleep(Integer time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
	
	public void relaunchAppForPopup() {
        driver.closeApp();
        threadSleep(2000);
        driver.launchApp();
        threadSleep(2000);
        System.out.println("App relaunched successfully for Popup");

        log.info("App relaunched successfully for Popup");
    }
	
	
	public void clickDeviceBackButton() {

        // ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
        driver.pressKeyCode(AndroidKeyCode.BACK);
        System.out.println("Back Button Clicked");

    }
	
	public  TouchAction getTouchAction () {
		  return new TouchAction(driver);
		}
	
	
	 public  void swipeVertical (double startPercentage, double finalPercentage, double anchorPercentage, int duration)throws Exception {
		  Dimension size = driver.manage().window().getSize();
		  int anchor = (int) (size.width * anchorPercentage);
		  int startPoint = (int) (size.height * startPercentage);
		  int endPoint = (int) (size.height * finalPercentage);
		  getTouchAction().press(PointOption.point(anchor, startPoint))
		  .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
		  .moveTo(PointOption.point(anchor, endPoint)).release().perform();
		}
	 
	 
	 public boolean isElementDisplayed(By by) {
			try {
				driver.findElement(by).isDisplayed();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	 
	 public  boolean scrollToElement (By by) throws Exception {
			boolean isFoundTheElement=true;
			//boolean isFoundTheElement = driver.findElements(by).size() > 0;
			//boolean isFoundTheElement=driver.findElement(by).isDisplayed();
			while (isElementDisplayed(by) == false) {
			swipeVertical(0.8, 0.1, 0.5, 2000);
			isFoundTheElement=isElementDisplayed(by);
			//isFoundTheElement = driver.findElements(by).is
			}

			log.info("Option found where user want to click");
					  return isFoundTheElement;
					}
	 
	 public void scrollToPerticularTxt(String text) throws Exception {
			CommonElements common = new CommonElements();
			String xp1="//android.widget.TextView[@text='";
			String xp2="']";
			By by = By.xpath(xp1+text+xp2);
			common.scrollToElement(by);
			
			
		}
}
