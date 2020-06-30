package com.logigear.training.test.DA_LOGIN;

import com.logigear.training.common.Constant;
import com.logigear.training.pages.GeneralPage;
import com.logigear.training.pages.LoginPage;
import com.logigear.training.test.BaseTest;
import com.logigear.training.utilities.ElementHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DA_LOGIN_TC005_VerifyThereIsnoLoginDialogWhenSwitchingBetween2RepositorieswithTheSameAccount extends BaseTest {
    LoginPage loginPage = new LoginPage();
    GeneralPage generalPage = new GeneralPage();
    ElementHelper elementHelper = new ElementHelper();

    @Test
    public void TC005() throws InterruptedException {
        loginPage.loginWith(Constant.VALID_USERNAME, Constant.UPPERCASE_PASSWORD);
        Assert.assertEquals(Constant.VALID_USERNAME, generalPage.getLoginSuccessText());
        generalPage.swithReponsitoryinDashboard();
        elementHelper.waitForVisibility();
        Assert.assertEquals(Constant.REPONSITORYLV2_NAME, generalPage.getReponsitoryonDaboard());
    }

}
