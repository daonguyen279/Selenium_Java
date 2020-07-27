package com.logigear.training.test.DA_MP;

import com.logigear.training.common.Constant;
import com.logigear.training.drivermanager.DriverManager;
import com.logigear.training.forms.NewPageForm;
import com.logigear.training.pages.DashBoardPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DA_MP_TC0013 extends BaseTest {

    @Test(description = "Verify that the newly added main parent page is positioned at the location specified as set with Displayed After field of New Page form on the main page bar Parent Page dropped down menu")
    public void TC0013() throws InterruptedException {
        String pageName1 = "page 0786";
        String pageName2 = "page 989786";

        LoginPage loginPage = new LoginPage();
        loginPage.loginWith(Constant.UPERCASE_USERNAME, Constant.PASSWORD);
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.clickAddPage();
        dashBoardPage.inputPageInformation(new NewPageForm() {{
            pageName = pageName1;
        }});
        dashBoardPage.submitPageInformation();

        dashBoardPage = new DashBoardPage();
        dashBoardPage.clickAddPage();
        dashBoardPage.inputPageInformation(new NewPageForm() {{
            pageName = pageName2;
            position = pageName1;

        }});
        dashBoardPage.submitPageInformation();

        Assert.assertEquals(dashBoardPage.checkPagePosition(pageName1,pageName2),"True");
    }
}
