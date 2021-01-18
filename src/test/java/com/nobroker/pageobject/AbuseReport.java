package com.nobroker.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import org.apache.log4j.Logger;

import com.google.common.collect.ImmutableMap;
import com.nobroker.commonpage.BasePage;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class AbuseReport extends BasePage{
	
	public AbuseReport() {
		PageFactory.initElements(driver, this);
		
	}
	
	public static Logger log = Logger.getLogger(AbuseReport.class);

	@FindBy(id = "buyLayoutText")
	private WebElement buy;
	
	public void selectBuyOption() {
		waitTillElementIsClickable(buy);
		buy.click();
	}
	
	@FindBy(id="searchEditHome")
	private WebElement searchEditHome;
	
	public void clickToSearchBox() {
		waitTillElementIsVisible(searchEditHome);
		searchEditHome.click();
	}
	
	@FindBy(id = "spinnergo")
	private WebElement selectCityDropDown;
	
	public void click_city_dropDown() {
		
		waitTillElementIsVisible(selectCityDropDown);
		selectCityDropDown.click();
		
	}
	
	public String returnSelected_city() {
		waitTillElementIsVisible(selectCityDropDown);
		return selectCityDropDown.getText();
		
	}
	
	//@FindBy(xpath = "//android.widget.CheckedTextView[@text=")
	
	public void selectCity(String city_name) {
		String xp1="//android.widget.CheckedTextView[@text='";
		String xp2 = "']";
		WebElement cityname = driver.findElement(By.xpath(xp1+city_name+xp2));
		waitTillElementIsClickable(cityname);
		cityname.click();
	}
	
	@FindBy(id = "localityAutoCompleteTxt")
	private WebElement localityAutoCompleteTextBox;
	
	
	public void select_locality(String locality) throws InterruptedException {
		waitTillElementIsVisible(localityAutoCompleteTextBox);
		localityAutoCompleteTextBox.sendKeys(locality);
		
		Thread.sleep(2000);
		//((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
		
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN);
		
				
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		
		
	}
	
	//@FindBy(xpath = "//android.widget.CheckBox[@text='")
	
	public String verify_selected_locality(String locality) {
		String xp1 ="//android.widget.CheckBox[@text='";
		String xp2 ="']";
		WebElement locality_element = driver.findElement(By.xpath(xp1+locality+xp2));
		waitTillElementIsVisible(locality_element);
		return locality_element.getText();
		
		
		
	}
	
	@FindBy(id = "nearByRadio")
	private WebElement nearByRadioBtn;
	
	public void click_near_by_radio_btn() {
		waitTillElementIsClickable(nearByRadioBtn);
		nearByRadioBtn.click();
	}
	
	@FindBy(id="nb_search_label_bhk_type")
	private WebElement no_bedrooms;
	
	public boolean is_no_bedrooms_displayed() {
		waitTillElementIsVisible(no_bedrooms);
		return no_bedrooms.isDisplayed();
	}
	
	@FindBy(id="bhktwo")
	private WebElement two_bhk;
	
	public void select_two_bhk() {
		waitTillElementIsVisible(two_bhk);
		two_bhk.click();
		
	}
	
	
	@FindBy(id="bhkthree")
	private WebElement three_bhk;
	
	public void select_three_bhk() {
		waitTillElementIsVisible(three_bhk);
		three_bhk.click();
		
	}
	
	@FindBy(id = "searchProperty")
	private WebElement search;
	
	public void click_search() {
		waitTillElementIsClickable(search);
		search.click();
	}
	
	
	@FindBy(id="property_thumbnail")
	private WebElement prop_thumbnail;
	
	public void click_property_thumbnail() {
		waitTillElementIsClickable(prop_thumbnail);
		prop_thumbnail.click();
	}
	
	@FindBy(id="basic_info_title")
	private WebElement basic_info;
	
	public boolean is_basicInfo_displayed() {
		waitTillElementIsVisible(basic_info);
		return basic_info.isDisplayed();
	}
	
	@FindBy(id="basic_info_cost")
	private WebElement basic_info_cost;
	
	public boolean is_basic_info_cost_displayed() {
		waitTillElementIsVisible(basic_info_cost);
		return basic_info_cost.isDisplayed();
		
	}
	@FindBy(id= "contactOwnerInDetail")
	private WebElement contact_owner;
	
	public boolean is_contactOwnerInDetail_displayed() {
		waitTillElementIsVisible(contact_owner);
		return contact_owner.isDisplayed();
		
	}
	
	@FindBy(id = "tv_report_wrong_info")
	private WebElement wrong_info;
	
	public void click_wrong_info() {
		waitTillElementIsVisible(wrong_info);
		wrong_info.click();
		
	}
	
	
	
	@FindBy(id="cb_location")
	private WebElement cb_location;
	
	
	@FindBy(id="cb_fake_photos")
	private WebElement cb_fake_photos;
	
	@FindBy(id="cb_bhk_type")
	private WebElement cb_bhk_type;
	
	
	
	
	
	@FindBy(id="cb_availability_date")
	private WebElement cb_availability_date;
	
	@FindBy(id="cb_price")
	private WebElement cb_price;
	
	@FindBy(id="cb_other")
	private WebElement cb_other;
	
	
	@FindBy(xpath = "//android.widget.TextView[@text()='What's wrong?']")
	private WebElement what_wrong_page;
	
	public boolean is_page_title_displayed() {
		waitTillElementIsVisible(what_wrong_page);
		return what_wrong_page.isDisplayed();
	}
	
	public boolean select_location_validate() {
		waitTillElementIsVisible(cb_location);
		cb_location.click();
		return cb_location.isSelected();
	}
	
	public boolean select_fakePhoto_validate() {
		waitTillElementIsVisible(cb_fake_photos);
		cb_fake_photos.click();
		return cb_fake_photos.isSelected();
	}
	
	
	public boolean select_BhkType_validate() {
		waitTillElementIsVisible(cb_bhk_type);
		cb_bhk_type.click();
		return cb_bhk_type.isSelected();
	}
	
	public boolean select_avablity_validate() {
		waitTillElementIsVisible(cb_availability_date);
		cb_availability_date.click();
		return cb_availability_date.isSelected();
	}
	
	public boolean select_price_validate() {
		waitTillElementIsVisible(cb_price);
		cb_price.click();
		return cb_price.isSelected();
	}
	
	
	public boolean select_other_validate() {
		waitTillElementIsVisible(cb_other);
		cb_other.click();
		return cb_other.isSelected();
	}
	
	@FindBy(id="btn_report")
	private WebElement reportBtn;
	
	public void click_report_btn() {
		waitTillElementIsClickable(reportBtn);
		reportBtn.click();
		
	}
	
	@FindBy(id="edt_others")
	private WebElement edt_others;
	
	public void enterText_edit_other() {
		waitTillElementIsVisible(edt_others);
		edt_others.sendKeys("Test");
		
		
		
	}
	
	@FindBy(id="btn_save")
	private WebElement btn_save;
	
	public void click_btn_save() {
		waitTillElementIsClickable(btn_save);
		btn_save.click();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Thank you for the feedback']")
	private WebElement feedback_pop_up;
	
	public boolean verify_feedback_popup() {
		waitTillElementIsVisible(feedback_pop_up);
		return feedback_pop_up.isDisplayed();
	}
	
	
	
}
