package com.logigear.training.test.DA_MP;

import com.logigear.training.common.Constant;
import com.logigear.training.forms.NewPageForm;
import com.logigear.training.pages.DashBoardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DA_MP_TC0014_VerifyAllUsersOfWorkingRepositoryAreAbleToViewAndAccessPublicPages extends BaseTest {

    @Test(description = "Verify that \"Public\" pages can be visible and accessed by all users of working repository")
    public void TC0013() throws InterruptedException {
        String pageName = "page 0786";

        LoginPage loginPage = new LoginPage();
        loginPage.loginWith(Constant.UPERCASE_USERNAME, Constant.PASSWORD);
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.clickAddPage();
        dashBoardPage.inputPageInformation(new NewPageForm() {{
            pageName = pageName;
        }});
        dashBoardPage.checkOnIsPublicCheckbox();
        dashBoardPage.submitPageInformation();
        dashBoardPage.logout();
        loginPage = new LoginPage();
        loginPage.loginWith(Constant.LOWERCASE_USERNAME, Constant.PASSWORD);

    }
}
