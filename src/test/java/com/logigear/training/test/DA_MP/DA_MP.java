package com.logigear.training.test.DA_MP;

import com.logigear.training.common.Constant;
import com.logigear.training.pages.DashBoardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DA_MP extends BaseTest {
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {"page 1", null, null, null, ""},
                {"page 2", "page 1", null, null, ""}
        };
    }

    @Test(dataProvider = "data-provider")
    public void TC(String pageName, String parentPage, String columnNumber, String position, String expect) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginWith(Constant.UPERCASE_USERNAME, Constant.PASSWORD);
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.clickAddPage();
        dashBoardPage.inputPageInformation(pageName, parentPage, columnNumber, position);
        dashBoardPage.submitPageInformation();
    }
}
