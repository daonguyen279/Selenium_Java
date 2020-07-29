package com.logigear.training.test.DA_DP;

import com.logigear.training.common.Constant;
import com.logigear.training.pages.DashBoardPage;
import com.logigear.training.pages.DataProfilesPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class DA_DP_TC066 extends BaseTest {
	LoginPage loginPage = new LoginPage();
	DashBoardPage dashBoardPage = new DashBoardPage();
	DataProfilesPage dataProfilesPage = new DataProfilesPage();

	@Test(description = "Verify that all Pre-set Data Profiles are populated correctly")
	public void TC066() {
		loginPage.selectRepository(Constant.REPOSITORY);
		loginPage.loginWith(Constant.UPERCASE_USERNAME, Constant.PASSWORD);
		Assert.assertEquals( Constant.UPERCASE_USERNAME, dashBoardPage.getLoginSuccessText());
		dashBoardPage.clickDataProfilesMenu();
		Assert.assertTrue(dataProfilesPage.editButtonsList().isEmpty());
		Assert.assertTrue(dataProfilesPage.deleteButtonsList().isEmpty());
	}

}
