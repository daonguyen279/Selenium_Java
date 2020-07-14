package com.logigear.training.test.DA_MP;

import com.logigear.training.common.Constant;
import com.logigear.training.forms.NewPageForm;
import com.logigear.training.pages.DashBoardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DA_MP_TC0012_VerifyThatUserIsAbleToAddAdditionalPagesBesidesOverviewPageSuccessfully extends BaseTest {

    @Test(description = "Verify that user is able to add additional pages besides Overview page successfully")
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
        Assert.assertEquals((int) dashBoardPage.getPagePosition(newPageName),
                (int)dashBoardPage.getPagePosition("Overview") + 1);
    }
}
