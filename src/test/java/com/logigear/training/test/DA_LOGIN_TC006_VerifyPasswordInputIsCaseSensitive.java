package com.logigear.training.test;

import com.logigear.training.common.Constant;
import com.logigear.training.pages.GeneralPage;
import com.logigear.training.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DA_LOGIN_TC006_VerifyPasswordInputIsCaseSensitive extends BaseTest {
    LoginPage loginPage = new LoginPage();
    GeneralPage generalPage = new GeneralPage();

    @Test
    public void TC006() throws InterruptedException {
        loginPage.loginWith(Constant.VALID_USERNAME, Constant.UPPERCASE_PASSWORD);
        Assert.assertEquals(Constant.VALID_USERNAME, generalPage.getLoginSuccessText());
        generalPage.logout();
        loginPage = new LoginPage();
        loginPage.loginWith(Constant.VALID_USERNAME, Constant.LOWERCASE_PASSWORD);
        Thread.sleep(1000);
        Assert.assertEquals(Constant.PASSWORD_ERROR_MESSAGE, loginPage.getLoginErrorMessageText());
    }
}
