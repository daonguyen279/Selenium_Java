package com.logigear.training.test.DA_MP;

import com.logigear.training.common.Constant;
import com.logigear.training.pages.DashBoardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DA_MP_TC0012_VerifyThatUserIsAbleToAddAdditionalPagesBesidesOverviewPageSuccessfully extends BaseTest {

    public void TC0012(String pageName, String parentPage, String columnNumber, String position, String expect) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWith(Constant.UPERCASE_USERNAME, Constant.PASSWORD);
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.clickAddPage();
        dashBoardPage.inputPageInformation(pageName, null, null, null);
        dashBoardPage.submitPageInformation();
    }
}
