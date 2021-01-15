package com.nobroker.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nobroker.automationconstants.BaseTest;
import com.nobroker.pageobject.AbuseReport;
import com.nobroker.pageobject.CommonElements;

public class VerifyAbuseReport extends BaseTest{
	
	@Test
	public void verify_Abuse_Report() throws Exception {
		log.info("Testing");
		
		AbuseReport abuseReport = new AbuseReport();
		abuseReport.selectBuyOption();
		log.info("Buy option has been selected");
		abuseReport.clickToSearchBox();
		log.info("clicked on the Search box");
		abuseReport.click_city_dropDown();
		log.info("clicked on city drop down");
		abuseReport.selectCity("Bangalore");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(abuseReport.returnSelected_city(), "Bangalore");
		log.info("Bangalore city has been selected");
		
		abuseReport.select_locality("marathalli");
		log.info("Marathalli selected");
		String marathalli = abuseReport.verify_selected_locality("Marathahalli");
		System.out.println(marathalli);
		soft.assertEquals(marathalli, "Marathahalli");
		log.info("Marathalli has been selected as a locality");
		abuseReport.select_locality("HSR");
		
		String HSR = abuseReport.verify_selected_locality("HSR Layout");
		System.out.println(marathalli);
		soft.assertEquals(HSR, "HSR Layout");
		log.info("HSR has been selected as a locality");
		CommonElements common = new CommonElements();
		common.clickDeviceBackButton();
		abuseReport.click_near_by_radio_btn();
		log.info("Near by Radio btn clicked");
		soft.assertTrue(abuseReport.is_no_bedrooms_displayed());
		log.info("Number of Bedroom section displayed");
		abuseReport.select_two_bhk();
		log.info("Two BHK selected");
		abuseReport.select_three_bhk();
		log.info("Three BHK selected");
		abuseReport.click_search();
		common.threadSleep(3000);
		
		//common.scrollToPerticularTxt("at Indipendent villa, 18th B Main Rd, Sector 3 near HelloWorld HSR");
		common.swipeVertical(0.8, 0.1, 0.5, 2000);
		common.swipeVertical(0.8, 0.1, 0.5, 2000);
		common.swipeVertical(0.8, 0.1, 0.5, 2000);
		common.swipeVertical(0.8, 0.1, 0.5, 2000);
		
		abuseReport.click_property_thumbnail();
		log.info("property selected");
		
		soft.assertTrue(abuseReport.is_basicInfo_displayed());
		soft.assertTrue(abuseReport.is_basic_info_cost_displayed());
		soft.assertTrue(abuseReport.is_contactOwnerInDetail_displayed());
		
		common.scrollToPerticularTxt("Wrong Info");
		abuseReport.click_wrong_info();
		log.info("clicked on the wrong info");
		//soft.assertTrue(abuseReport.is_page_title_displayed());
		
		
		abuseReport.select_location_validate();
		abuseReport.select_fakePhoto_validate();
		abuseReport.select_BhkType_validate();
		abuseReport.select_avablity_validate();
		abuseReport.select_price_validate();
		abuseReport.select_other_validate();
		
		abuseReport.click_report_btn();
		log.info("clicked on report btn");
		
		common.clickDeviceBackButton();
		common.clickDeviceBackButton();
		common.swipeVertical(0.8, 0.1, 0.5, 2000);
		common.swipeVertical(0.8, 0.1, 0.5, 2000);
		common.swipeVertical(0.8, 0.1, 0.5, 2000);
		abuseReport.enterText_edit_other();
		log.info("Test Message added");
		abuseReport.click_btn_save();
		log.info("clicked on save change");
		soft.assertTrue(abuseReport.verify_feedback_popup());
		
		log.info("Pop up has been verified");
		
		log.info("Done!!!");
		
		
	}

}
