package com.logigear.training.test.DA_DP;

import com.logigear.training.common.Constant;
import com.logigear.training.pages.DashBoardPage;
import com.logigear.training.pages.DataProfilesPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class DA_DP_TC065 extends BaseTest {
	LoginPage loginPage = new LoginPage();
	DashBoardPage dashBoardPage = new DashBoardPage();
	DataProfilesPage dataProfilesPage = new DataProfilesPage();

	@Test(description = "Verify that all Pre-set Data Profiles are populated correctly")
	public void TC065() {
		loginPage.selectRepository(Constant.REPOSITORY);
		loginPage.loginWith(Constant.UPERCASE_USERNAME, Constant.PASSWORD);

		Assert.assertEquals( Constant.UPERCASE_USERNAME, dashBoardPage.getLoginSuccessText());
		dashBoardPage.clickDataProfilesMenu();

		List<String> profiles = dataProfilesPage.profilesList();
		Assert.assertTrue(profiles.contains("Action Implementation By Status"));
		Assert.assertTrue(profiles.contains("Test Case Execution"));
		Assert.assertTrue(profiles.contains("Test Case Execution History"));
		Assert.assertTrue(profiles.contains("Test Case Execution Results"));
		Assert.assertTrue(profiles.contains("Test Case Execution Trend"));
		Assert.assertTrue(profiles.contains("Test Module Execution"));
		Assert.assertTrue(profiles.contains("Test Module Execution Failure Trend"));
		Assert.assertTrue(profiles.contains("Test Module Execution History"));
		Assert.assertTrue(profiles.contains("Test Module Execution Results"));
		Assert.assertTrue(profiles.contains("Test Module Execution Results Report"));
		Assert.assertTrue(profiles.contains("Test Module Execution Trend"));
		Assert.assertTrue(profiles.contains("Test Module Implementation By Priority"));
		Assert.assertTrue(profiles.contains("Test Module Implementation By Status"));
		Assert.assertTrue(profiles.contains("Test Module Status per Assigned Users"));
		Assert.assertTrue(profiles.contains("Test Objective Execution"));
	}

}
