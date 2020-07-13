package com.logigear.training.test.DA_MP;

import com.logigear.training.common.Constant;
import com.logigear.training.forms.NewPageForm;
import com.logigear.training.pages.DashBoardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DA_MP_TC0012_VerifyThatUserIsAbleToAddAdditionalPagesBesidesOverviewPageSuccessfully extends BaseTest {
    @Test
    public void TC0012() {
        String newPageName = "New Page";
        LoginPage loginPage = new LoginPage();
        loginPage.loginWith(Constant.UPERCASE_USERNAME, Constant.PASSWORD);
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.clickAddPage();
        dashBoardPage.inputPageInformation(new NewPageForm() {{
            pageName = newPageName;
        }});
        dashBoardPage.submitPageInformation();
        Assert.assertNotEquals(dashBoardPage.getPagePosition(newPageName), -1);
        Assert.assertEquals(dashBoardPage.getPagePosition(newPageName), dashBoardPage.getPagePosition("Overview") + 1);
    }
}
