package com.logigear.training.test;

import com.logigear.training.common.Constant;
import com.logigear.training.pages.GeneralPage;
import com.logigear.training.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DA_LOGIN_TC004_VerifyThatUserIsAbleToLogInDifferentRepositoriesSuccessfullyAfterLoggingOutCurrentRepository extends BaseTest {
    LoginPage loginPage = new LoginPage();
    GeneralPage generalPage = new GeneralPage();

    @Test
    public void TC_004() throws InterruptedException {
        loginPage.loginWith(Constant.UPERCASE_USERNAME, Constant.PASSWORD);
        Assert.assertEquals(Constant.UPERCASE_USERNAME, generalPage.getLoginSuccessText());
        generalPage.logout();
        loginPage.switchRepositoryLV2inLoginPage();
        loginPage = new LoginPage();
        loginPage.loginWith(Constant.UPERCASE_USERNAME, Constant.PASSWORD);
        generalPage = new GeneralPage();
        Assert.assertEquals(Constant.UPERCASE_USERNAME.toUpperCase(), generalPage.getLoginSuccessText());
    }
}

