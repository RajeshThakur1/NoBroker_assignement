package com.nobroker.commonpage;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nobroker.automationconstants.Automation_Constants;
import com.nobroker.automationconstants.BaseTest;
import com.nobroker.generic.Property;

import io.appium.java_client.android.AndroidDriver;

public class BasePage {
	
	
	public Logger log = Logger.getLogger(this.getClass());
    public AndroidDriver<WebElement> driver;
    public String configFile;
    public long timeout;


    public BasePage(){
        this.driver= BaseTest.driver;
        configFile= Automation_Constants.CONFIG_PATH+Automation_Constants.CONFIG_FILE;
        timeout=Long.parseLong(Property.getPropertyValue(configFile,"EXPLICIT"));
    }
    
    
    public void waitTillElementIsVisible(WebElement Element)
    {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(Element));
    }

    public void waitTillElementIsVisible(List<WebElement> Element)
    {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElements(Element));
    }

    
    public void waitTillElementIsClickable(WebElement element)
    {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
    }
    
    
    public boolean isTestElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
